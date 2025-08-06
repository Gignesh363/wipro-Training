package com.wipro.assignment12.repository;

import com.wipro.assignment12.model.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/booksdb";
    private static final String USER = "root";
    private static final String PASSWORD = "pass123"; // 🔁 Change if needed

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books")
        ) {
            while (rs.next()) {
                books.add(new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
