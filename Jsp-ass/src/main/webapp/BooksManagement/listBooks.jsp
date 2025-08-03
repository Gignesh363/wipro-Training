<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<html>
<head><title>Book List</title></head>
<body>
    <h2>List of Books</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>Price</th>
        </tr>
        <%
            List<Book> bookList = (List<Book>) request.getAttribute("bookList");
            if (bookList != null) {
                for (Book b : bookList) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getPrice() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="addBook.jsp">Add New Book</a>
</body>
</html>
