<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="account" class="beans.BankAccount" scope="request" />
<jsp:setProperty name="account" property="*" />

<%-- Set accountType in session --%>
<%
    String accType = request.getParameter("accountType");
    session.setAttribute("accType", accType);
%>

<html>
<head><title>Bank Account Result</title></head>
<body>
    <h2>Account Information (via EL)</h2>
    Account No: ${account.accountNo} <br><br>
    Name: ${account.name} <br><br>
    Balance: ₹${account.balance} <br><br>
    Account Type (from session): ${sessionScope.accType} <br><br>

    <b>Balance Status:</b>
    <c:choose>
        <c:when test="${account.balance >= 1000}">
            ✅ Sufficient Balance
        </c:when>
        <c:otherwise>
            ❌ Insufficient Balance
        </c:otherwise>
    </c:choose>
</body>
</html>
