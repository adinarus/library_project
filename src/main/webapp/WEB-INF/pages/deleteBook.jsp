<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Stergere Carte">
    <br/>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/DeleteBook">
        <input type="hidden" name="book_id" value="${book.id}"> <!-- Câmp ascuns pentru ID -->
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label" for="book_title">Titlu</label>
                <input type="text" class="form-control" id="book_title" name="book_title" value="${book.title}" readonly>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label" for="book_author">Autor</label>
                <input type="text" class="form-control" id="book_author" name="book_author" value="${book.author}" readonly>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label" for="book_genre">Genul</label>
                <input type="text" class="form-control" id="book_genre" name="book_genre" value="${book.genre}" readonly>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label" for="book_quantity">Cantitate</label>
                <input type="text" class="form-control" id="book_quantity" name="book_quantity" value="${book.quantity}" readonly>
            </div>
        </div>
        <br/>
        <a href="${pageContext.request.contextPath}/Books" class="btn btn-secondary btn-lg">Renunță</a>
        <button type="submit" class="btn btn-danger btn-lg">Confirmare ștergere</button>
    </form>
    <br/>
    <br/>
</t:pageTemplate>


