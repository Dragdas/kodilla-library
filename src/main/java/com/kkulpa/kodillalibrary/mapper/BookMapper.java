package com.kkulpa.kodillalibrary.mapper;

import com.kkulpa.kodillalibrary.controllers.book.BookNotFoundException;
import com.kkulpa.kodillalibrary.domain.Book;
import com.kkulpa.kodillalibrary.domain.BookDto;
import com.kkulpa.kodillalibrary.domain.BookStatus;
import com.kkulpa.kodillalibrary.domain.IllegalBookStatusException;
import com.kkulpa.kodillalibrary.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMapper {

    private final BookDbService bookDbService;

    public Book mapToBook(BookDto bookDto) throws BookNotFoundException, IllegalBookStatusException {

        Book book = bookDbService.getBook(bookDto.getId());

        try {
            BookStatus status = BookStatus.valueOf(bookDto.getStatus());
            book.setStatus(status);
            return book;
        }catch (Exception e){
            throw new IllegalBookStatusException();
        }
    }


}
