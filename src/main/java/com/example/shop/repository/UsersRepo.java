package com.example.shop.repository;

import com.example.shop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findBySurnameAndPhone(String surname, String phoneNumber);
}
