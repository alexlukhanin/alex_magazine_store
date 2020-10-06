<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<div class="headerDiv">
    <jsp:include page="header.jsp"></jsp:include>

</div>

<div class="mainDiv">
    <h3> Login, please </h3>
    <form action="login" method="post" id="loginForm">

        <label for="login">Email:</label>  <input type="text" name="login" class="loginInput">
        <br>
        <label for="password">Password:</label>  <input type="password" name="password" class="passInput">
        <br>
        <input type="submit" value="Submit">
        <br>
        <a href="/registration.jsp">Registration</a>
        <a href="/">Homepage</a>
    </form>

    <p>
        Entered the page at <%= new java.util.Date() %>
    </p>

</div>

<div class="footerDiv">
    <jsp:include page="footer.jsp"></jsp:include>

</div>


</body>
</html>
