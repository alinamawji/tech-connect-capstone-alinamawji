<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file = "common/header.jspf" %>

<style>
    .form-group {
        margin: 5px;
    }
</style>



<c:url var="registerUrl" value="/register"/>
<form:form action="${registerUrl}" method="POST" modelAttribute="user">
    <div class="form-group">
        <label for="first_name">First Name</label>
        <form:input class="form-control" path="first_name" placeholder="Enter First Name"/>
        <form:errors path="first_name" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="last_name">Last Name</label>
        <form:input class="form-control" path="last_name" placeholder="Enter Last Name"/>
        <form:errors path="last_name" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input class="form-control" path="username" placeholder="Enter Username"/>
        <form:errors path="username" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input class="form-control" path="email" placeholder="Enter Email"/>
        <form:errors path="email" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="confirmEmail">Confirm Email</label>
        <form:input class="form-control" path="confirmEmail" placeholder="Confirm Email"/>
        <form:errors path="confirmEmail" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:password class="form-control" path="password" placeholder="Enter Password"/>
        <form:errors path="password" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <form:password class="form-control" path="confirmPassword" placeholder="Confirm Password"/>
        <form:errors path="passwordMatching" cssClass="bg-danger"/>
    </div>
<%--    <fieldset>--%>
<%--        <legend>Role</legend>--%>
<%--        <form:errors path="role" cssClass="bg-danger"/>--%>
<%--        <div class="radio">--%>
<%--            <label>--%>
<%--                <form:radiobutton path="role" value="user" checked="checked"/>--%>
<%--                User--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <div class="radio">--%>
<%--            <label>--%>
<%--                <form:radiobutton path="role" value="admin"/>--%>
<%--                Administrator--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <div class="radio">--%>
<%--            <label>--%>
<%--                <form:radiobutton path="role" value="editor"/>--%>
<%--                Editor--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </fieldset>--%>
    <button type="submit" class="btn btn-outline-dark">Register</button>
</form:form>

<%@ include file = "common/footer.jspf" %>