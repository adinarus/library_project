<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Biblioteca mea">
    <div class="welcome-section">
    <br/>
    <br/>
    <h1>Bine ai venit la biblioteca ta, ${pageContext.request.userPrincipal.name}</h1>
    <div class="container mt-3">
        <div class="row">
        <c:forEach var="borrowedbook" items="${borrowedbooks}" varStatus="loop">
            <!-- Folosim col-md-4 pentru a avea 3 cărți pe rând pe ecrane medii și mari -->
            <div class="col-md-4">
                <div class="card-body">
                    <h5 class="card-title">${borrowedbook.title}</h5>
                    <p class="card-text">${borrowedbook.author}</p>
                    <p class="card-text">Gen: ${borrowedbook.genre}</p>
                    <img src="${pageContext.request.contextPath}/BookPhotos?id=${borrowedbook.id}" class="card-img"/>
                    <br/>
                    <br/>
                    <a href="${pageContext.request.contextPath}/ReturnBook?id=${borrowedbook.id}" class="btn btn-info">Returneaza carte</a>
                    <a href="${borrowedbook.pdfUrl}" class="btn btn-info">Citeste carte</a>

                </div>
            </div>
        </c:forEach>
        </div>
    </div>
</t:pageTemplate>
