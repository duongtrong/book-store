package com.example.auth.spring.service;

import com.example.auth.spring.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();

    Book save(Book book);

    Book getDetails(int id);

    Book update(Book book);

    void delete(int id);

    List<Book> getBookByTitle(String title, String author, String genre);
}
