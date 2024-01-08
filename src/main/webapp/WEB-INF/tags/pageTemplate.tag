<%@ tag description="base page template" pageEncoding="UTF-8" %>
<%@attribute name="pageTitle"%>

<!DOCTYPE html>
<html>
<head>
    <title class="title">${pageTitle}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link  href="css/style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/pages/menu.jsp" />
    <main class="container-fluid mt-5">
        <jsp:doBody/>
        <jsp:include page="/WEB-INF/pages/footer.jsp" />
        <script src="${pageContext.request.contextPath}/scripts/form-validation.js"></script>
    </main>
</body>
</html>