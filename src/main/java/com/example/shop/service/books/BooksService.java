package com.example.shop.service.books;

import com.example.shop.model.Books;
import java.util.List;
import java.util.Optional;

public interface BooksService {
    void save(Books book);
    Optional<Books> findByIsbn(int isbn);
    void remove(Books books);
    List<Books> findAll();
}
