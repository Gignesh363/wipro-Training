package dao;

import model.Book;
import java.sql.*;
import java.util.*;

public class BookDAO {
    private Connection con;

    public BookDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb","root","pass123");
    }

    public void addBook(Book book) throws Exception {
        String sql = "INSERT INTO books(title, author, price) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3, book.getPrice());
        ps.executeUpdate();
    }

    public List<Book> getAllBooks() throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Book b = new Book();
            b.setId(rs.getInt("id"));
            b.setTitle(rs.getString("title"));
            b.setAuthor(rs.getString("author"));
            b.setPrice(rs.getDouble("price"));
            list.add(b);
        }
        return list;
    }
}
