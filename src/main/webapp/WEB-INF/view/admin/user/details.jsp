<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content />
        <meta name="author" content />
        <title>Dashboard - SB Admin</title>
        <link href="/css/style.css" rel="stylesheet" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          
        />
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/Header.jsp" />
        <div id="layoutSidenav">
            <jsp:include page="../layout/Sidebar.jsp" />
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manger user</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"><a
                                    href="/admin">Dashboard</a></li>
                            <li class="breadcrumb-item active">users</li>
                        </ol>

                    </div>
                    <div class="container mt-5">
            <div class="row">
                <div class="col-12 mx-auto">
                    <div class="d-flex justify-content-between">
                        <h3>Users details ${id}</h3>

                    </div>
                    <hr />
                    <div class="card">
                        <div class="card-header">
                            User information
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Id- ${user.id}</li>
                            <li class="list-group-item">FullName- ${user.fullName}</li>
                            <li class="list-group-item">Email- ${user.email}</li>
                            <li class="list-group-item">Address-${user.address}</li>
                        </ul>
                    </div>
                    <a href="/admin/user" class="btn btn-success">Back</a>

                </div>
            </div>

        </div>



                </main>
                <jsp:include page="../layout/Footer.jsp" />
            </div>
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
        <script src="/js/scripts.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
            crossorigin="anonymous"></script>
        <script src="/js/chart-area-demo.js"></script>
        <script src="/js/chart-bar-demo.js"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
            crossorigin="anonymous"></script>
        <script src="/js/datatables-simple-demo.js"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    </body>
</html>