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
  <div class="container w-50">
    <h1>Hello User</h1>
           <h3 class="m-3">Name: ${userLogin.fullname}</h3>
           <h3 class="m-3">Username: ${userLogin.username}</h3>
           <h3 class="m-3">Num Enroll: ${userEnrollments.size()}</h3>
            <hr>

            <table class="table">
              <thead>
                <tr>
                  <th scope="col">Title</th>
                  <th scope="col">Teacher</th>
                  <th scope="col">Duration</th>
                  <th scope="col">Date</th>
                </tr>
              </thead>
              <tbody>
                 <c:forEach var="e" items="${userEnrollments}">
                    <tr>
                        <td>${e.course.title}</td>
                        <td>${e.course.teacher}</td>
                        <td>${e.course.duration}</td>
                        <td>${e.enrollment_date}</td>
                    </tr>
                 </c:forEach>
              </tbody>
            </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>