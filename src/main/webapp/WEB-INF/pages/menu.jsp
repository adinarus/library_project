<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Biblioteca</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav me-auto mb-2 mb-md-0">
        <li class="nav-item">
          <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/about.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/about.jsp">Despre noi</a>
        </li>
        <li class="nav-item">
              <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/books.jsp' ? ' active' : ''}" href="${pageContext.request.contextPath}/Books">Carti</a>
        </li>
          <c:if test="${pageContext.request.getRemoteUser() != null}">
              <li class="nav-item">
                  <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/myLibrary.jsp' ? ' active' : ''}" href="myLibrary">Biblioteca mea</a>
              </li>
          </c:if>
          <!-- Verifies if the user is part of the required group and shows the menu accordingly -->
          <c:if test="${pageContext.request.isUserInRole('grup1')}">
              <li class="nav-item">
                  <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/users.jsp' ? ' active' : ''}" href="${pageContext.request.contextPath}/Users">Utilizatori</a>
              </li>
          </c:if>

          <ul class="navbar-nav">
              <li class="nav-item">
                  <c:choose>
                      <c:when test="${pageContext.request.getRemoteUser() == null}">
                          <a class="nav-link" href="${pageContext.request.contextPath}/Signup">Inregistrare</a>
                      </c:when>
                      <c:otherwise>
                      </c:otherwise>
                  </c:choose>
              </li>
          </ul>
        <ul class="navbar-nav">
          <li class="nav-item">
              <c:choose>
                  <c:when test="${pageContext.request.getRemoteUser() == null}">
                      <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                  </c:when>
                  <c:otherwise>
                      <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                  </c:otherwise>
              </c:choose>
          </li>
        </ul>
      </ul>
      <form action="${pageContext.request.contextPath}/SearchBook" method="GET" class="d-flex" role="search">
        <input  type="text" name="searchQuery" placeholder="Cauta" class="form-control me-2">
        <button type="submit" class="searchBtn">Cauta</button>
      </form>
    </div>
  </div>
</nav>
