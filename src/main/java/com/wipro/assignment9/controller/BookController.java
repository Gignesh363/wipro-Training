package com.wipro.assignment9.controller;

import com.wipro.assignment9.model.Book;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping(value = "/bookXYZ", produces = "application/xml")
    public BooksWrapper getBooks() {
        List<Book> books = Arrays.asList(
                new Book(101, "Java Tutorials", "Krishna"),
                new Book(102, "Spring Tutorials", "Mahesh"),
                new Book(103, "Angular Tutorials", "Shiva")
        );
        return new BooksWrapper(books);
    }

    // Inner wrapper class for XML <List><item>...</item></List>
    @XmlRootElement(name = "List")
    public static class BooksWrapper {
        private List<Book> books;

        public BooksWrapper() {}

        public BooksWrapper(List<Book> books) {
            this.books = books;
        }

        @jakarta.xml.bind.annotation.XmlElement(name = "item")
        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }
}
