<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<link rel="stylesheet" type="text/css" href="css\style.css">
<div class="headerDiv">
    <jsp:include page="header.jsp"></jsp:include>

</div>

<div class="mainDiv">
    <h3> Register, please </h3>
    <form action="registration" method="post" id="registrationForm">

        <label for="firstName">First Name:</label>  <input type="text" name="firstName" class="inputName">
        <br>
        <label for="lastName">Last Name:</label>  <input type="text" name="lastName" class="inputName">
        <br>
        <label for="email">Email:</label>  <input type="text" name="email" class="loginInput">
        <br>
        <label for="password1">New Password:</label>  <input type="password" name="password" id="password1" class="passInputReg1">
        <br>
        <label for="password2">Repeat password: </label>  <input type="password" name="password2" id="password2" class="passInputReg2">
        <br>
        <input type="submit" value="Submit" id="submitReg" disabled>
        <br>
        <a href="/login.jsp">Login</a>
        <a href="/">Homepage</a>

    </form>

    <script>
        password1.oninput = function () {
          if (password1.value !== password2.value) {
              password1.classList.remove('accepted');
              password1.classList.add('error');
              password2.classList.remove('accepted');
              password2.classList.add('error');
              document.getElementById('submitReg').disabled = true;
              //submitReg.removeAttribute('disabled')
          } else {
              password1.classList.add('accepted');
              password1.classList.remove('error');
              password2.classList.add('accepted');
              password2.classList.remove('error');
              document.getElementById('submitReg').disabled = false;
          }
        }
        password2.oninput = function () {
            if (password1.value !== password2.value) {
                password1.classList.remove('accepted');
                password1.classList.add('error');
                password2.classList.remove('accepted');
                password2.classList.add('error');
                document.getElementById('submitReg').disabled = true;
            } else {
                password1.classList.add('accepted');
                password1.classList.remove('error');
                password2.classList.add('accepted');
                password2.classList.remove('error');
                document.getElementById('submitReg').disabled = false;
            }
        }


    </script>

    <p>
        Entered the page at <%= new java.util.Date() %>
    </p>

</div>

<div class="footerDiv">
    <jsp:include page="footer.jsp"></jsp:include>

</div>


</body>
</html>
