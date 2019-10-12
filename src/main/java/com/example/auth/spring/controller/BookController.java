package com.example.auth.spring.controller;

import com.example.auth.spring.entity.Book;
import com.example.auth.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping( method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute ("books", bookService.getList ());
        return "book/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("book", new Book ());
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchName(@RequestParam(value = "title", required = false) String title,
                             @RequestParam(value = "author", required = false) String author,
                             @RequestParam(value = "genre", required = false) String genre, Model model) {
        List<Book> listBooks = bookService.getList ();
        model.addAttribute("search", bookService.getBookByTitle (title, author, genre));
        return "book/search";
    }
}
