<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Conectare">
    <c:if test ="${message != null}">
        <div class="alert alert-warning" role="alert">
            ${message}
        </div>
    </c:if>
    <br/>
    <div class="loginFrm">
            <%--    <form action="<%=request.getContextPath()%>/register" method="post" class="form">--%>
        <form method="POST" action="j_security_check" class="form">
            <h1 class="title">Conectare</h1>

                <%--@declare id=""--%>
            <div class="inputContainer">
                <input type="text" id="username" name="j_username" class="input" placeholder="Username" required><br>
                <label for="username" class="label">Username</label>
            </div>
            <div class="inputContainer">
                <input type="password" id="password" name="j_password" class="input" placeholder="Password" required><br>
                <label for="password" class="label">Parola</label>
            </div>
            <input type="submit" class="submitBtn" name="submit" value="Conectare">
        </form>
    </div>
</t:pageTemplate>