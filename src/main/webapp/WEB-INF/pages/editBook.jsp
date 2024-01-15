<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Editare Carte">
    <br/>
    <br/>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditBook">
        <input type="hidden" name="book_id" value="${book.id}"> <!-- Câmp ascuns pentru ID -->
        <div class="row">
            <div class="col-md-6 md-3">
                <label class="form-label" for="book_title">Titlu</label>
                <input type="text" class="form-control" id="book_title" placeholder="" value="${book.title}" name="book_title" required>
                <div class="invalid-feedback">
                    Titlul cartii este necesar.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 md-3">
                <label class="form-label" for="book_author">Autor</label>
                <input type="text" class="form-control" id="book_author" name="book_author" placeholder="" value="${book.author}" required>
                <div class="invalid-feedback">
                    Autorul cartii este necesar.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 md-3">
                <label class="form-label" for="book_genre">Genul</label>
                <select id="book_genre" class="form-select" name="book_genre">
                    <option value="Comedie" ${book.genre == 'Comedie' ? 'selected' : ''}>Comedie</option>
                    <option value="Dragoste" ${book.genre == 'Dragoste' ? 'selected' : ''}>Dragoste</option>
                    <option value="Drama" ${book.genre == 'Drama' ? 'selected' : ''}>Drama</option>
                    <option value="Fantezie" ${book.genre == 'Fantezie' ? 'selected' : ''}>Fantezie</option>
                    <option value="Literatura universala" ${book.genre == 'Literatura universala' ? 'selected' : ''}>Literatura universala</option>
                    <option value="Literatura romana" ${book.genre == 'Literatura romana' ? 'selected' : ''}>Literatura romana</option>
                    <option value="Literatura clasica" ${book.genre == 'Literatura clasica' ? 'selected' : ''}>Literatura clasica</option>
                </select>
                <div class="invalid-feedback">
                    Genul cartii este necesar.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 md-3">
                <label class="form-label" for="book_quantity">Cantitate</label>
                <input type="text" class="form-control" id="book_quantity" name="book_quantity" placeholder="" value="${book.quantity}" required>
                <div class="invalid-feedback">
                    Cantitatea de carti este necesara.
                </div>
            </div>
        </div>
        <br/>
        <a href="${pageContext.request.contextPath}/Books" class="btn btn-secondary btn-lg">Renunță</a>
        <button type="submit" class="btn btn-primary btn-lg">Editare carte</button>
    </form>
    <br/>
    <br/>
</t:pageTemplate>
