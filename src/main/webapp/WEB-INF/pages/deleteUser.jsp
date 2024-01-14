<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Stergere Utilizator">
  <br/>
  <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/DeleteUser">
    <input type="hidden" name="user_id" value="${user.id}"> <!-- Câmp ascuns pentru ID -->
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label" for="firstname">Prenume</label>
        <input type="text" class="form-control" id="firstname" name="firstname" value="${user.surname}" readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label" for="lastname">Nume</label>
        <input type="text" class="form-control" id="lastname" name="lastname" value="${user.name}" readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label" for="username">Nume Utilizator</label>
        <input type="text" class="form-control" id="username" name="username" value="${user.username}" readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label" for="email">E-mail</label>
        <input type="text" class="form-control" id="email" name="email" value="${user.email}" readonly>
      </div>
    </div>
    <br/>
    <a href="${pageContext.request.contextPath}/Users" class="btn btn-secondary btn-lg">Renunță</a>
    <button type="submit" class="btn btn-danger btn-lg">Confirmare ștergere</button>
  </form>
</t:pageTemplate>