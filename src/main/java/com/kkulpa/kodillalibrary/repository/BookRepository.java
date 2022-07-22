package com.kkulpa.kodillalibrary.repository;

import com.kkulpa.kodillalibrary.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    @Query(value = "SELECT count(*) FROM books where status = :status and books.title_id = :titleId",
            nativeQuery = true)
    long countBooksByStatusAndTitleId(
            @Param("status") String status, @Param("titleId") long titleId);


}
