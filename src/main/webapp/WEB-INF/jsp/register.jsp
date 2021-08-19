<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file = "common/header.jspf" %>

<c:url var="registerUrl" value="/register"/>
<form:form action="${registerUrl}" method="POST" modelAttribute="user">
    <h1 class = "display-6" style = "margin-top: 10px; margin-bottom: 10px;">Registration</h1>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <form:input class="form-control" path="firstName" placeholder="enter first name"/>
        <form:errors path="firstName" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <form:input class="form-control" path="lastName" placeholder="enter last name"/>
        <form:errors path="lastName" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input class="form-control" path="username" placeholder="enter username"/>
        <form:errors path="username" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input class="form-control" path="email" placeholder="enter email"/>
        <form:errors path="email" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="confirmEmail">Confirm Email</label>
        <form:input class="form-control" path="confirmEmail" placeholder="confirm email"/>
        <form:errors path="emailMatching" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:password class="form-control" path="password" placeholder="enter password"/>
        <form:errors path="password" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <form:password class="form-control" path="confirmPassword" placeholder="confirm password"/>
        <form:errors path="passwordMatching" cssClass="bg-danger"/>
    </div>
    <button type="submit" class="btn btn-outline-dark" style = "margin-top: 10px;">Register</button>
</form:form>

<%@ include file = "common/footer.jspf" %>