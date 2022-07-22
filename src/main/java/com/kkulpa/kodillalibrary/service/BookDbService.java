package com.kkulpa.kodillalibrary.service;

import com.kkulpa.kodillalibrary.controllers.book.BookNotFoundException;
import com.kkulpa.kodillalibrary.controllers.title.TitleNotFoundException;
import com.kkulpa.kodillalibrary.domain.Book;
import com.kkulpa.kodillalibrary.domain.BookStatus;
import com.kkulpa.kodillalibrary.domain.Title;
import com.kkulpa.kodillalibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(long bookId) throws BookNotFoundException {

        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public long countBooksByStatusAndTitleId(BookStatus status, long titleId){
        return bookRepository.countBooksByStatusAndTitleId(status.toString(),titleId);
    }

}
