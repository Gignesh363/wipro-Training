package com.wipro.assignment12.controller;

import com.wipro.assignment12.model.Book;
import com.wipro.assignment12.repository.BookDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springrest")
public class BookRestController {

    private final BookDAO bookDAO;

    public BookRestController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookDAO.getAllBooks();
    }
}
