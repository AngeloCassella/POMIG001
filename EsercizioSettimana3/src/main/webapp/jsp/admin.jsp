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
    <h1>Admin Page</h1>
        <form action="/admin" method="POST">
            <div class="row g-3 mt-3 mb-3">
                <div class="col-sm">
                    <input type="text" class="form-control" name="title" placeholder="Course title">
                </div>
                <div class="col-sm">
                    <input type="text" class="form-control" name="teacher" placeholder="Teacher">
                </div>
                <div class="col-sm">
                    <input type="number" class="form-control" name="duration" placeholder="Duration">
                </div>
                <div class="col-sm">
                    <input type="number" class="form-control" name="max_students" placeholder="Max Students">
                </div>
                <div class="col-sm">
                    <button type="submit" class="btn btn-dark w-100"  role="button">Add Course</a>
                </div>
            </div>
        </form>
        <c:if test="${not empty success}">
            <div class="alert alert-success mt-3" role="alert">${success}</div>
        </c:if>
        <hr />

        <div class="row align-items-start">
            <div class="col">
                <h2>Course List</h2>
                <ul class="list-group list-group-flush m-3">
                    <c:forEach var="c" items="${courses}">
                        <li class="list-group-item">
                            ${c.title} (${c.teacher})
                            <form class="float-end" action="/admin" method="POST">
                                <button type="submit" class="btn btn-dark btn-sm float-end" name="remove" value="${c.id}" role="button">delete</a>
                            </td>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col">
                <h2>Enroll Table</h2>
                <table class="table">
                          <thead>
                              <tr>
                                  <th scope="col">User</th>
                                  <th scope="col">Title</th>
                                  <th scope="col">Teacher</th>
                                  <th scope="col">Duration</th>
                                  <th scope="col">Date</th>
                              </tr>
                          </thead>
                          <tbody>
                              <c:forEach var="e" items="${enrollments}">
                                  <tr>
                                      <td>${e.user.fullname}</td>
                                      <td>${e.course.title}</td>
                                      <td>${e.course.teacher}</td>
                                      <td>${e.course.duration}</td>
                                      <td>${e.enrollment_date}</td>
                                  </tr>
                              </c:forEach>
                          </tbody>
                      </table>
            </div>
          </div>




    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>