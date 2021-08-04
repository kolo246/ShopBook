package com.example.shop.service.books;

import com.example.shop.entity.Books;
import com.example.shop.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepo booksRepo;

    public BooksServiceImpl(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    public BooksServiceImpl() {
    }

    @Override
    public void save(Books book) {
        booksRepo.save(book);
    }

    @Override
    public Optional<Books> findByIsbn(int isbn) {
        return booksRepo.findByIsbn(isbn);
    }
}
