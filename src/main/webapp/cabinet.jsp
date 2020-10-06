
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

    <h2>Welcome to user cabinet! ${userFirstName} ${userLastName} </h2>

    <h3> You can change Your info here and save </h3>
    <form action="cabinet" method="post" id="cabinetForm">

        <label for="firstName">First Name:</label>  <input type="text" name="firstName" class="inputName" value="${userFirstName}">
        <br>
        <label for="lastName">Last Name:</label>  <input type="text" name="lastName" class="inputName" value="${userLastName}">
        <br>
        <label for="email">Email:</label>  <input type="text" name="email" class="loginInput" value="${userEmail}">
        <br>
        <label for="password1">New Password:</label>  <input type="password" name="password" id="password1" class="passInputReg1" value="${userPassword}">
        <br>
        <label for="password2">Repeat password: </label>  <input type="password" name="password2" id="password2" class="passInputReg2" value="${userPassword}">
        <br>
        <input type="submit" value="Save" id="saveCab">
        <br>

    </form>
    <script>
        password1.oninput = function () {
            if (password1.value !== password2.value) {
                password1.classList.remove('accepted');
                password1.classList.add('error');
                password2.classList.remove('accepted');
                password2.classList.add('error');
                document.getElementById('saveCab').disabled = true;
                //submitReg.removeAttribute('disabled')
            } else {
                password1.classList.add('accepted');
                password1.classList.remove('error');
                password2.classList.add('accepted');
                password2.classList.remove('error');
                document.getElementById('saveCab').disabled = false;
            }
        }
        password2.oninput = function () {
            if (password1.value !== password2.value) {
                password1.classList.remove('accepted');
                password1.classList.add('error');
                password2.classList.remove('accepted');
                password2.classList.add('error');
                document.getElementById('saveCab').disabled = true;
            } else {
                password1.classList.add('accepted');
                password1.classList.remove('error');
                password2.classList.add('accepted');
                password2.classList.remove('error');
                document.getElementById('saveCab').disabled = false;
            }
        }


    </script>
<%--    <img src="images/photo1.jpg" alt="magazines" id="photo1">--%>
    <p>
        Entered the page at <%= new java.util.Date() %>
    </p>

</div>

<div class="footerDiv">
    <jsp:include page="footer.jsp"></jsp:include>

</div>


</body>
</html>
