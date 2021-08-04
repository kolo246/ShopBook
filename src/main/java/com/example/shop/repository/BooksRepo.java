package com.example.shop.repository;

import com.example.shop.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepo extends JpaRepository<Books, Long> {
    Optional<Books> findByIsbn(int isbn);
}
