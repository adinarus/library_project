<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Adauga imagine unei carti">
    <h1>Adauga Imagine Cartii</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddBookPhoto" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6 mb-3">
                Numele cărții: ${book.title}
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="file">Photo</label>
                <input type="file" name="file" id="file" required>
                <div class="invalid-feedback">
                    Photo is required.
                </div>
            </div>
        </div>
        <input type="hidden" name="book_id" value="${book.id}">
        <div class="mb-4">
            <a href="${pageContext.request.contextPath}/Books" class="btn btn-secondary btn-lg">Renunță</a>
            <button type="submit" class="btn btn-danger btn-lg">Adaugă imaginea</button>
        </div>
    </form>
</t:pageTemplate>

