package com.kkulpa.kodillalibrary.controllers.book;


import com.kkulpa.kodillalibrary.controllers.title.TitleNotFoundException;
import com.kkulpa.kodillalibrary.domain.*;
import com.kkulpa.kodillalibrary.mapper.BookMapper;
import com.kkulpa.kodillalibrary.service.BookDbService;
import com.kkulpa.kodillalibrary.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;
    private final TitleDbService titleDbService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookDbService.getAllBooks());
    }

    @GetMapping(value = "{titleId}")
    public ResponseEntity<Long> countAvailableBooksByTitleId(@PathVariable long titleId){
        return ResponseEntity.ok(bookDbService.countBooksByStatusAndTitleId(BookStatus.AVAILABLE,titleId));
    }


    @PostMapping(value = "{titleId}")
    public ResponseEntity<Void> addNewBook(@PathVariable Long titleId) throws TitleNotFoundException {

        Title title = titleDbService.getTitle(titleId);
        Book book = new Book(0, title, BookStatus.AVAILABLE);
        bookDbService.saveBook(book);

        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBookStatus (@RequestBody BookDto bookDto) throws IllegalBookStatusException, BookNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);

        return ResponseEntity.ok().build();
    }






}
