<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<div class="headerDiv">
    <jsp:include page="header.jsp"></jsp:include>

</div>

<div class="mainDiv">
    <a href="/">Homepage</a>
    <a href="/login.jsp">Login</a>
    <a href="/registration.jsp">Registration</a>
    <h3> Login, please to continue canceling registration </h3>
    <form action="cancel" method="post" id="cancelForm">

        <label for="login">Email:</label>  <input type="text" name="login" class="loginInput">
        <br>
        <label for="password">Password:</label>  <input type="password" name="password" class="passInput">
        <br>
        <input type="submit" value="Cancel Registration">
        <br>

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
