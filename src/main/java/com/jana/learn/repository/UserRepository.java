package com.jana.learn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jana.learn.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findById(Long id);
} 
