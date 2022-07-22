package com.kkulpa.kodillalibrary.controllers;

import com.kkulpa.kodillalibrary.controllers.book.BookNotFoundException;
import com.kkulpa.kodillalibrary.controllers.book.BookUnavailableException;
import com.kkulpa.kodillalibrary.controllers.lending.LendingNotFoundException;
import com.kkulpa.kodillalibrary.controllers.title.TitleNotFoundException;
import com.kkulpa.kodillalibrary.controllers.user.UserNotFoundException;
import com.kkulpa.kodillalibrary.controllers.book.IllegalBookStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<Object> handleTitleNotFoundException(TitleNotFoundException exception){
        return new ResponseEntity<>("Title with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception){
        return new ResponseEntity<>("Book with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalBookStatusException.class)
    public ResponseEntity<Object> handleIllegalBookStatusException(IllegalBookStatusException exception){
        return new ResponseEntity<>("User provided illegal book status", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception){
        return new ResponseEntity<>("User with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookUnavailableException.class)
    public ResponseEntity<Object> handleBookUnavailableException(BookUnavailableException exception){
        return new ResponseEntity<>("Provided book is unavailable to let at this moment", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LendingNotFoundException.class)
    public ResponseEntity<Object> handleLendingNotFoundException(LendingNotFoundException exception){
        return new ResponseEntity<>("Lending with given id does not exist", HttpStatus.BAD_REQUEST);
    }
}
