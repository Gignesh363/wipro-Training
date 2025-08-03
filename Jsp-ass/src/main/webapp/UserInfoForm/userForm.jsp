<!DOCTYPE html>
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <h2>User Information</h2>
    <form action="userSuccess.jsp" method="post">
        User Name <input type="text" name="username"><br><br>
        Password <input type="password" name="password"><br><br>
        Address <br>
        <textarea name="address" rows="4" cols="30">Sample Address</textarea><br><br>

        Subscribe Newsletter
        <input type="checkbox" name="subscribe"><br><br>

        Favorite Web Frameworks:<br>
        <input type="checkbox" name="framework" value="Spring MVC">Spring MVC
        <input type="checkbox" name="framework" value="Struts 1">Struts 1
        <input type="checkbox" name="framework" value="Struts 2">Struts 2
        <input type="checkbox" name="framework" value="Apache Wicket">Apache Wicket
        <br><br>

        Gender:<br>
        <input type="radio" name="gender" value="Male">Male
        <input type="radio" name="gender" value="Female">Female<br><br>

        Favorite Number:<br>
        <input type="radio" name="number" value="1">1
        <input type="radio" name="number" value="2">2
        <input type="radio" name="number" value="3">3
        <input type="radio" name="number" value="4">4<br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
