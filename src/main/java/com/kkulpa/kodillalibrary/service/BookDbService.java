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
    private final TitleDbService titleDbService;

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

    public Book addNewBook(long titleId) throws TitleNotFoundException {
        Title title = titleDbService.getTitle(titleId);
        Book book = new Book(0, title, BookStatus.AVAILABLE);
        return saveBook(book);
        }

}
