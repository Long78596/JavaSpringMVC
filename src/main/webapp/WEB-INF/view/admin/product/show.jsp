<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="/css/style.css" rel="stylesheet" />
    </head>
    <body class="sb-nav-fixed">
          <jsp:include page="../layout/Header.jsp"/>
        <div id="layoutSidenav">
             <jsp:include page="../layout/Sidebar.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Products</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                            <li class="breadcrumb-item active">Products</li>
                        </ol>
                        <div class="mt-5">
                            <div class="row">
                                <div class="col-12 mx-auto">
                                    <div class="d-flex justify-content-between">
                                        <h3>Table products</h3>
                                        <a href="/admin/product/create" class="btn btn-primary">Create a product</a>
                                    </div>
                
                                    <hr />
                                    <table class=" table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Factory</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="product" items="${products}">
                                                                    <tr>
                                                                        <th>${product.id}</th>
                                                                        <td>${product.name}</td>
                                                                        <td>${product.price}</td>
                                                                        <td>${product.factory}</td>
                                                                        <td>
                                                                            <a href="/admin/product/${product.id}"
                                                                                class="btn btn-success">View</a>
                                                                            <a href="/admin/product/update/${product.id}"
                                                                                class="btn btn-warning  mx-2">Update</a>
                                                                            <a href="/admin/product/delete/${product.id}"
                                                                                class="btn btn-danger">Delete</a>
                                                                        </td>
                                                                    </tr>
                
                                                                </c:forEach>
                
                                        </tbody>
                                    </table>
                                </div>
                
                            </div>
                
                        </div>
                    </div>
                </main>
                <jsp:include page="../layout/Footer.jsp"/>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/js/chart-area-demo.js"></script>
        <script src="/js/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="/js/datatables-simple-demo.js"></script>
    </body>
</html>
