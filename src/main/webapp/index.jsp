<html>
<body>
<link rel="stylesheet" type="text/css" href="css\style.css">
<div class="headerDiv">
    <jsp:include page="header.jsp"></jsp:include>

</div>

<div class="mainDiv">
    <h2>Welcome!</h2>
    <h3> Login, please </h3>
    <form action="login" method="post" id="loginForm">

        <label for="login">Login:</label>  <input type="text" name="login" class="loginInput">
        <br><br>
        <label for="password">Password:</label>  <input type="password" name="password" class="passInput">
        <br><br>
        <input type="submit" value="Submit">
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
