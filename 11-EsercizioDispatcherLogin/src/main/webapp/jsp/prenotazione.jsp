<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
    <jsp:include page="fragments/header.jsp" />
    <div class="container">
        <h1 class="text-center">Prenota Eventi</h1>

        <form action="prenota" method="POST">
        <div class="row g-3 m-3">
          <div class="col-sm">
            <select class="form-select" name="event">
              <option selected>Open this select menu</option>
                <c:forEach var="e" items="${eventi}">
                    <option value="${e.id}">${e.titoloEvento}</option>
                </c:forEach>
            </select>
          </div>
          <div class="col-sm">
            <input type="text" class="form-control" name="nomeUtente" placeholder="User name">
          </div>
          <div class="col-sm">
            <input type="email" class="form-control" name="email" placeholder="Email address">
          </div>
          <div class="col-sm">
            <button type="submit" class="btn btn-dark w-100"  role="button">Prenota</a>
          </div>
        </div>
        </form>

        <jsp:include page="fragments/footer.jsp" />
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>