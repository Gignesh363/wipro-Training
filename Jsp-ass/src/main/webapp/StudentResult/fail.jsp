<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head><title>Result</title></head>
<body>
    <h2 style="color:red;">Result: FAIL ❌</h2>
    <p>Name: <%= session.getAttribute("studentName") %></p>
    <p>Marks: <%= session.getAttribute("studentMarks") %></p>
</body>
</html>
