package com.kkulpa.kodillalibrary.service;

import com.kkulpa.kodillalibrary.controllers.book.BookNotFoundException;
import com.kkulpa.kodillalibrary.controllers.book.BookUnavailableException;
import com.kkulpa.kodillalibrary.controllers.lending.LendingNotFoundException;
import com.kkulpa.kodillalibrary.controllers.user.UserNotFoundException;
import com.kkulpa.kodillalibrary.domain.Book;
import com.kkulpa.kodillalibrary.domain.BookStatus;
import com.kkulpa.kodillalibrary.domain.Lending;
import com.kkulpa.kodillalibrary.domain.User;
import com.kkulpa.kodillalibrary.repository.LendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LendingDbService {

    private final LendingRepository lendingRepository;
    private final UserDbService userDbService;
    private final BookDbService bookDbService;

    public List<Lending> getAllLendings(){
        return lendingRepository.findAll();
    }

    public Lending lendBook(long userId, long bookId) throws UserNotFoundException, BookNotFoundException, BookUnavailableException {

        User user = userDbService.getUserById(userId);
        Book book = bookDbService.getBook(bookId);
        if(!book.getStatus().equals(BookStatus.AVAILABLE))
            throw new BookUnavailableException();

        Lending lending = new Lending(0,book,user, LocalDate.now(),LocalDate.now().plusDays(14));
        book.setStatus(BookStatus.LENT);

        bookDbService.saveBook(book);
        return lendingRepository.save(lending);
    }

    public void returnBook(long lendingId) throws LendingNotFoundException {

        Lending lending = lendingRepository.findById(lendingId).orElseThrow(LendingNotFoundException::new);

        Book book = lending.getLentBook();

        book.setStatus(BookStatus.AVAILABLE);
        bookDbService.saveBook(book);

        lendingRepository.delete(lending);
    }





}
