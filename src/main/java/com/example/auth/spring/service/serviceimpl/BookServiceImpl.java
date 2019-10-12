package com.example.auth.spring.service.serviceimpl;

import com.example.auth.spring.entity.Book;
import com.example.auth.spring.repository.BookRepository;
import com.example.auth.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getList() {
        return bookRepository.findAll ();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save (book);
    }

    @Override
    public Book getDetails(int id) {
        return bookRepository.findById (id).orElse (null);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save (book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById (id);
    }

    @Override
    public List<Book> getBookByTitle(String title, String author, String genre) {
        return bookRepository.findBooksByTitleAndAndAuthorAndGenre (title, author, genre);
    }
}
