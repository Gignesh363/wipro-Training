<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Success</title>
</head>
<body>
    <h2 style="text-align:center;">Registration Details</h2>
    <table align="center" border="1" cellpadding="8">
        <tr><td>Full Name</td><td><%= request.getParameter("fullName") %></td></tr>
        <tr><td>Email</td><td><%= request.getParameter("email") %></td></tr>
        <tr><td>Password</td><td><%= request.getParameter("password") %></td></tr>
        <tr><td>Date of Birth</td><td><%= request.getParameter("dob") %></td></tr>
        <tr><td>Gender</td><td><%= request.getParameter("gender") %></td></tr>
        <tr><td>Designation</td><td><%= request.getParameter("designation") %></td></tr>
        <tr><td>Married</td>
            <td><%= request.getParameter("married") != null ? "Yes" : "No" %></td></tr>
        <tr><td>Remarks</td><td><%= request.getParameter("remarks") %></td></tr>
    </table>
</body>
</html>
