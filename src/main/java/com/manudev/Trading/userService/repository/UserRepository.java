package com.manudev.Trading.userService.repository;

import com.manudev.Trading.userService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT o FROM Order o WHERE o.active = true")
    List<User> findAllActiveUsers();
}
