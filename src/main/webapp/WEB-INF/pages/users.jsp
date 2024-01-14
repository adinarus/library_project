<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Lista Utilizatori">
    <h1 class="page-title">Lista Utilizatori</h1>
    <c:if test="${pageContext.request.isUserInRole('grup1')}">
        <!-- <a href="${pageContext.request.contextPath}/AddUser" class="btn btn-primary btn-lg">Adauga un user</a> -->
    </c:if>
    <div class="container mt-3">
        <div class="row">
            <c:forEach var="users" items="${users}" varStatus="loop">
            <!-- Folosim col-md-4 pentru a avea 3 cărți pe rând pe ecrane medii și mari -->
            <div class="col-md">
                <div class="card-body">
                    <h5 class="card-text">Prenume: ${users.surname}</h5>
                    <p class="card-text">Nume: ${users.name}</p>
                    <p class="card-text">Nume de utilizator: ${users.username}</p>
                    <p class="card-text">E-mail: ${users.email}</p>
                </div>
                <div class="card-footer">
                    <c:if test="${pageContext.request.isUserInRole('grup1')}">
                        <a href="${pageContext.request.contextPath}/DeleteUser?id=${users.id}" class="btn btn-danger">Sterge</a>
                    </c:if>
                </div>
            </div>
            <!-- Adaugăm o linie nouă după fiecare user -->
        </div><div class="row">
        </c:forEach>
    </div>
    </div>
</t:pageTemplate>

