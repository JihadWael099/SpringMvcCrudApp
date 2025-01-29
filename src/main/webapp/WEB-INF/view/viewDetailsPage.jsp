<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--        import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
<body class="container">
        <form:form  modelAttribute="productDetails" action="${pageContext.request.contextPath}/products/details/${productDetails.id}"  method="GET">
            <h1 class="mt-5">Product Details</h1>
            <div class="d-flex justify-content-center align-items-center" style="width: 18rem;   background-color: #f8f9fa;
    color: #333; " >
                <div class="card-body">
                    <h5 class="card-title">Product Name: ${productDetails.name}</h5>
                    <p class="card-text">Manufacturer: ${productDetails.manufacturer}</p>
                    <p class="card-text">Price: $${productDetails.price}</p>
                    <p class="card-text">Expiration Date: ${productDetails.expirationDate}</p>
                    <p class="card-text">Available: ${productDetails.available}</p>
                    <a href="${pageContext.request.contextPath}/products/list" class="btn btn-primary">Back to Products List</a>
                </div>
            </div>
        </form:form>
</body>

</html>