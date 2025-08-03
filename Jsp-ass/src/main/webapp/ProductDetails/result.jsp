<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="product" class="beans.Product" scope="request" />
<jsp:setProperty name="product" property="*" />

<html>
<head><title>Product Details</title></head>
<body>
    <h2>Product Details</h2>
    Product ID: <jsp:getProperty name="product" property="productId" /><br><br>
    Name: <jsp:getProperty name="product" property="name" /><br><br>
    Price: ₹<jsp:getProperty name="product" property="price" /><br><br>
    Quantity: <jsp:getProperty name="product" property="quantity" /><br><br>
</body>
</html>
