<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Product</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Update Product</h1>

    <form:form action="${pageContext.request.contextPath}/products/processUpdateProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <div class="form-group">
                    <label for="name">Product Name</label>
                    <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name" />
                    <form:errors path="name" cssClass="text-danger" />
                </div>
                    <form:input type="hidden" cssClass="form-control" path="id" placeholder="Enter product name" />
                <div class="form-group">
                    <label for="expirationDate">Expiration Date</label>
                    <form:input type="text" cssClass="form-control" path="expirationDate" placeholder="YYYY-MM-DD" />
                    <form:errors path="expirationDate" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="manufacturer">Manufacturer</label>
                    <form:input type="text" cssClass="form-control" path="manufacturer" placeholder="Manufacturer" />
                    <form:errors path="manufacturer" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input type="number" cssClass="form-control" path="price" placeholder="Price" />
                    <form:errors path="price" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="available">Availability</label>
                    <form:select cssClass="form-control" path="available">
                        <form:option value="true" label="Available" />
                        <form:option value="false" label="Unavailable" />
                    </form:select>
                    <form:errors path="available" cssClass="text-danger" />
                </div>

                <div class="form-group text-center">
                    <a href="/SpringMvcCrudApp/products/list" class="btn btn-primary">Back</a>
                    <input type="submit" class="btn btn-primary" value="Update Product" />
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
