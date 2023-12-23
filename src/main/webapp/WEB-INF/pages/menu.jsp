<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Library</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav me-auto mb-2 mb-md-0">
        <li class="nav-item">
          <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/about.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About</a>
        </li>
        <li class="nav-item">
          <%--  activePage is an attribute in the request. we use the value in that attribute to set the active class on the menu entries:
          if the value of activePage is 'Cars' then output the CSS class active         --%>
          <a class="nav-link ${activePage eq 'Books' ? 'active' : ''}" href="${pageContext.request.contextPath}/Books">Books</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Disabled</a>
        </li>
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" hnef="${paqeContext.request.contextPath}/Register">Register</a>
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" hnef="${paqeContext.request.contextPath}/Login">Loqin</a>
          </li>
        </ul>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
