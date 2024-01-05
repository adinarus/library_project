<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">
  <h1>Carti</h1>
  <a href="${pageContext.request.contextPath}/AddBook"
      class="btn btn-primary btn-lg">
      Adauga o carte
  </a>
  <div class="container text-center">
    <c:forEach var="book" items="${books}">
      <div class="row">
        <div class="col-sm-3" style="padding-top: 5px">
            ${book.title}
        </div>
        <div class="col-sm-2" style="padding-top: 5px">
            ${book.author}
        </div>
        <div class="col-sm-2" style="padding-top: 5px">
            ${book.genre}
        </div>
        <div class="col-sm-1" style="padding-top: 5px">
            ${book.quantity}
        </div>
        <div class="col-sm-1" style="padding-top: 5px">
          <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditBook?id=${book.id}">
            Editare
          </a>
        </div>
        <div class="col-sm-1" style="padding-top: 5px">
          <a class="btn btn-danger" href="${pageContext.request.contextPath}/DeleteBook?id=${book.id}">
            Sterge
          </a>
        </div>
      </div>
    </c:forEach>
  </div>
  <h5>Carti valabile: ${numberOfAvailableBooks}</h5>
</t:pageTemplate>
