package com.kkulpa.kodillalibrary.controllers.lending;


import com.kkulpa.kodillalibrary.controllers.book.BookNotFoundException;
import com.kkulpa.kodillalibrary.controllers.book.BookUnavailableException;
import com.kkulpa.kodillalibrary.controllers.user.UserNotFoundException;
import com.kkulpa.kodillalibrary.domain.Book;
import com.kkulpa.kodillalibrary.domain.Lending;
import com.kkulpa.kodillalibrary.domain.User;
import com.kkulpa.kodillalibrary.mapper.BookMapper;
import com.kkulpa.kodillalibrary.service.BookDbService;
import com.kkulpa.kodillalibrary.service.LendingDbService;
import com.kkulpa.kodillalibrary.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lending")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LendingController {
    private final LendingDbService lendingDbService;

    @GetMapping
    public ResponseEntity<List<Lending>> getAllLandings(){
        return ResponseEntity.ok(lendingDbService.getAllLendings());
    }

    @PostMapping
    public ResponseEntity<Void> lendBook(
            @RequestParam(name = "userId") long userId,
            @RequestParam(name = "bookId") long bookId )
            throws UserNotFoundException, BookNotFoundException, BookUnavailableException {

        lendingDbService.lendBook(userId,bookId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{lendingId}")
    public ResponseEntity<Void> returnBook(@PathVariable long lendingId) throws LendingNotFoundException {

        lendingDbService.returnBook(lendingId);

        return ResponseEntity.ok().build();
    }






}
