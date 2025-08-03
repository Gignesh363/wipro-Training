<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Success Page</title></head>
<body>
    <h2>Form Submitted Successfully</h2>
    <p><b>User Name:</b> <%= request.getParameter("username") %></p>
    <p><b>Password:</b> <%= request.getParameter("password") %></p>
    <p><b>Address:</b> <%= request.getParameter("address") %></p>
    <p><b>Subscribed:</b> <%= request.getParameter("subscribe") != null ? "Yes" : "No" %></p>
    <p><b>Framework:</b> <%= request.getParameter("framework") %></p>
    <p><b>Gender:</b> <%= request.getParameter("gender") %></p>
    <p><b>Favorite Number:</b> <%= request.getParameter("number") %></p>
</body>
</html>

