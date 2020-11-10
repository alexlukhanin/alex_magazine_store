<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Magazines table</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/cabinet.css">
    <script src="js/header.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
    String email=(String)session.getAttribute("email");

    //redirect user to login page if not logged in
    if(email==null){
        response.sendRedirect("index.jsp");
    }
%>
<%--==================================Main===============================--%>




<div class="container">

    <h1>Magazines table</h1>
    <hr/>

   <%-- <p>${NOTIFICATION}</p>--%>
    <p>
        <button class = "btn btn-primary" onclick="window.location.href = '/createProduct.jsp'">Add Magazine</button>
    </p>
    <table class = "table table-striped table-bordered" id="datatable">
        <thead>
        <tr class = "thead-dark">
            <th>Name</th>
            <th>Description</th>
            <th>Price, $/year</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>
                    <a href = "${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a>
                    |
                    <a href = "${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>




























<%--=================================================================--%>
<jsp:include page="footer.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
<script>
    $(document).ready(function(){
        $("#datatable").DataTable();
    })
</script>

</body>
</html>
