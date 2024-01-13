<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Lista Cărți">
  <h1 class="page-title">Lista Cărți</h1>
  <c:if test="${pageContext.request.isUserInRole('grup1')}">
    <a href="${pageContext.request.contextPath}/AddBook" class="btn btn-primary btn-lg">Adauga o carte</a>
  </c:if>
  <div class="container mt-3">
    <div class="row">
      <c:forEach var="book" items="${books}" varStatus="loop">
      <!-- Folosim col-md-4 pentru a avea 3 cărți pe rând pe ecrane medii și mari -->
      <div class="col-md-4">
          <div class="card-body">
            <h5 class="card-title">${book.title}</h5>
            <p class="card-text">${book.author}</p>
            <p class="card-text">Gen: ${book.genre}</p>
            <p class="card-text">Disponibile: ${book.quantity}</p>
              <img src="${pageContext.request.contextPath}/BookPhotos?id=${book.id}" class="card-img"/>
          </div>
          <div class="card-footer">
            <c:if test="${pageContext.request.isUserInRole('grup2') or pageContext.request.isUserInRole('grup1')}">
              <a href="${pageContext.request.contextPath}/BorrowBook?id=${book.id}" class="btn btn-secondary">Imprumuta</a>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('grup1')}">
              <a href="${pageContext.request.contextPath}/EditBook?id=${book.id}" class="btn btn-info">Editare</a>
              <a href="${pageContext.request.contextPath}/DeleteBook?id=${book.id}" class="btn btn-danger">Sterge</a>
              <a href="${pageContext.request.contextPath}/AddBookPhoto?id=${book.id}" class="btn btn-danger">Adauga imagine</a>
            </c:if>
          </div>
      </div>
      <!-- Adaugăm o linie nouă după fiecare 3 cărți -->
        <c:if test="${loop.index % 3 == 2 && !loop.last}">
    </div><div class="row">
    </c:if>
    </c:forEach>
  </div>
  </div>
</t:pageTemplate>
