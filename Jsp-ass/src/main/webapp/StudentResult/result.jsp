<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("studentName");
    int marks = Integer.parseInt(request.getParameter("studentMarks"));

    // Store values in session so we can access in pass/fail page
    session.setAttribute("studentName", name);
    session.setAttribute("studentMarks", marks);

    if (marks >= 40) {
        response.sendRedirect("pass.jsp");
    } else {
        response.sendRedirect("fail.jsp");
    }
%>
