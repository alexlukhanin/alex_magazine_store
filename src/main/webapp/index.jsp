
<html>
<body>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<div class="headerDiv">
    <jsp:include page="header.jsp"></jsp:include>

</div>

<div class="mainDiv">
    <a href="/login.jsp">Login</a>
    <a href="/registration.jsp">Registration</a>

    <h2>Welcome!</h2>


    <img src="images/photo1.jpg" alt="magazines" id="photo1">
    <p>
        Entered the page at <%= new java.util.Date() %>
    </p>

</div>

<div class="footerDiv">
    <jsp:include page="footer.jsp"></jsp:include>

</div>


</body>
</html>
