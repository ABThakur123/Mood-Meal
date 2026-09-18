package com.moodmeal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodmeal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
