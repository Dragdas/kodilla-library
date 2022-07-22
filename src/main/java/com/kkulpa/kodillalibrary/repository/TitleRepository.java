package com.kkulpa.kodillalibrary.repository;

import com.kkulpa.kodillalibrary.domain.Title;
import com.kkulpa.kodillalibrary.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleRepository extends CrudRepository<Title, Long> {

    List<Title> findAll();
}
