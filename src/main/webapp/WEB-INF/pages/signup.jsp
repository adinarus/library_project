<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Inregistrare">

    <div class="signupFrm">
            <%--    <form action="<%=request.getContextPath()%>/register" method="post" class="form">--%>
        <form action="${pageContext.request.contextPath}/Signup" method="post" class="form">
            <h1 class="title">Inregistrare</h1>

                <%--@declare id=""--%>
            <div class="inputContainer">
                <input type="text" class="input" placeholder="Prenume" name="firstName" id="firstName" required><br>
                <label for="firstName" class="label">Prenume</label>
            </div>

            <div class="inputContainer">
                <input type="text" class="input" placeholder="Nume" name="lastName" id="lastName" required><br>
                <label for="lastName"  class="label">Nume</label>
            </div>

            <div class="inputContainer">
                <input type="text" class="input" placeholder="Nume de utilizator" name="userName" id="userName" required><br>
                <label for="userName"  class="label">Nume de utilizator</label>
            </div>

            <div class="inputContainer">
                <input type="email" class="input" placeholder="Email" name="email" id="email" required><br>
                <label for="email" class="label">Email</label>
            </div>

            <div class="inputContainer">
                <input type="password" class="input" placeholder="Parola" name="password" id="password" required><br>
                <label for="password" class="label">Parola</label>
            </div>
            <input type="submit" class="submitBtn" name="submit" value="Inregistrare">
        </form>
    </div>
</t:pageTemplate>
