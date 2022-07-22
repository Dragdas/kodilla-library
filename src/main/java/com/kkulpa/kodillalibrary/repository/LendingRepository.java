package com.kkulpa.kodillalibrary.repository;

import com.kkulpa.kodillalibrary.domain.Lending;
import com.kkulpa.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LendingRepository extends CrudRepository<Lending, Long> {

    List<Lending> findAll();
}
