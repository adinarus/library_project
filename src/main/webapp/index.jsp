<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Biblioteca Virtuală">
    <div class="welcome-section">
        <img src="${pageContext.request.contextPath}/images/welcome-image.jpg" alt="Biblioteca" class="background-image"/>
        <div class="welcome-text">

            <c:if test="${pageContext.request.userPrincipal ne null}">
                <div class="user-info">
                    <h1>Bine ati venit ${pageContext.request.userPrincipal.name}!</h1>
                </div>
            </c:if>
            <p>Biblioteca Virtuală deschide o lume de cunoaștere și aventură prin fiecare carte pe care o oferim. Explorați colecția noastră vastă și alăturați-vă comunității noastre de cititori pasionați astăzi.</p>
        </div>
    </div>
</t:pageTemplate>
