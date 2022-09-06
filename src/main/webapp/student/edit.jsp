<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Detail</title>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<%

%>
<form method="post" action="/admin?action=editCustomer&id=${thisStu.id}">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Name</label>
            <input type="text" class="form-control" id="inputEmail4" value="${thisStu.name}" name="name">
        </div>
        <div class="form-group col-md-6">
            <label for="inputAge">Age</label>
            <input type="text" class="form-control" id="inputAge" value="${thisStu.age}" name="age">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Address</label>
        <input type="text" class="form-control" id="inputAddress" value="${thisCus.address}" name="address">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Phone</label>
        <input type="text" class="form-control" id="inputAddress2" value="${thisCus.phone}" name="phone">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCity">Email</label>
            <input type="email" class="form-control" id="inputCity" value="${thisCus.email}" name="email">
        </div>
        <div class="form-group col-md-2">
            <label for="inputZip">Account</label>
            <input type="text" class="form-control" id="inputZip" value="${thisCus.account}" name="account">
        </div>
        <div class="form-group col-md-2">
            <label for="inputZip">Password</label>
            <input type="text" class="form-control" value="${thisCus.password}" name="password">
        </div>
        <div class="form-group col-md-2">
            <label for="inputZip">Gender</label>
            <p class="form-control" value="${thisCus.gender}" name="gender">${thisCus.gender} (Can't Change)</p>
        </div>
        <div class="form-group col-md-2">
            <label for="inputZip">Date Join</label>
            <p  class="form-control" value="${thisCus.startDate}" name="date">${thisCus.startDate} (Can't Change)</p>
        </div>

    </div>
    <button type="submit" class="btn btn-primary">Confirm</button>
</form>
<p>
    <c:if test="${mess != null}">
        <span>${mess}</span>
    </c:if>
</p>
<h3><a href="/admin?action=showAllCus">Back To Customers List</a></h3>
</body>
</html>
