package controller;

import model.Book;
import dao.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookController extends HttpServlet {
    BookDAO dao;

    public void init() {
        try {
            dao = new BookDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            if (dao == null) dao = new BookDAO();
            Book book = new Book();
            book.setTitle(req.getParameter("title"));
            book.setAuthor(req.getParameter("author"));
            book.setPrice(Double.parseDouble(req.getParameter("price")));
            dao.addBook(book);
            res.sendRedirect("BooksManagement/listBooks.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            if (dao == null) dao = new BookDAO();
            List<Book> list = dao.getAllBooks();
            req.setAttribute("bookList", list);
            RequestDispatcher rd = req.getRequestDispatcher("BooksManagement/listBooks.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
