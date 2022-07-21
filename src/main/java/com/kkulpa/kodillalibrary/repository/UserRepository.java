package com.kkulpa.kodillalibrary.repository;

import com.kkulpa.kodillalibrary.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
