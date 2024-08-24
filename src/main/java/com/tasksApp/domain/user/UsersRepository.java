package com.tasksApp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, String> {
    // Checar se funciona
    Optional<User> findByEmail(String email);
}
