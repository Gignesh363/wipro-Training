<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
</head>
<body>
    <h2 style="text-align:center;">Employee Registration</h2>
    <form action="success.jsp" method="post">
        <table align="center">
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="fullName" required /></td>
            </tr>
            <tr>
                <td>Email Address:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="date" name="dob" /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male" />Male
                    <input type="radio" name="gender" value="Female" />Female
                </td>
            </tr>
            <tr>
                <td>Designation:</td>
                <td>
                    <select name="designation">
                        <option>Developer</option>
                        <option>Tester</option>
                        <option>Manager</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Married?</td>
                <td><input type="checkbox" name="married" /></td>
            </tr>
            <tr>
                <td>Remarks:</td>
                <td><textarea name="remarks" rows="4" cols="30"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Register" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
