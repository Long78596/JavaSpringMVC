<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Update</title>
        <!-- Latest compiled and minified CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/demo.css">
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 col-12 mx-auto">
                    <h3>update a user</h3>
                    <hr />
                  
                        <form:form method="post" action="/admin/user/update" modelAttribute="newUser">
                        <div class="mb-3" style="display:none;">
                            <label class="form-label">Id:</label>
                            <form:input type="text" class="form-control"
                               
                                path="id" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email:</label>
                            <form:input type="email" class="form-control"
                                placeholder=" email"
                                path="email" disabled="true" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">password:</label>
                            <form:input type="password" class="form-control"
                                placeholder=" password"
                                path="password" disabled="true" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">phone:</label>
                            <form:input type="text" class="form-control"
                                placeholder=" phone" path="phone" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">full Name:</label>
                            <form:input type="text" class="form-control"
                                placeholder=" fullName" path="fullName" />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">address:</label>
                            <form:input type="text" class="form-control"
                                placeholder=" address" path="address" />
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-success">Update</button>
                        </div>
                    </form:form>

                </div>
            </div>

        </div>
    </body>
</html>