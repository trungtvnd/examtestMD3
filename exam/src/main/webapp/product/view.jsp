<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/15/2022
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .displayTable{
            border: 1px solid;
            border-collapse: collapse;
            width: 800px;

        }
        table{
            width: 700px;
        }
        table, tr, td {
            padding: 5px;
        }

    </style>
</head>
<body>
<div>
    <button><a href="${pageContext.request.contextPath}/products?action=create">CREATE NEW PRODUCT</a></button>
</div>

<div>

    <div>
        <div>
            <p>Product List</p>
        </div>

        <div class="displayTable">
            <div style="float:right;">
                <form action="${pageContext.request.contextPath}/products?action=search" method="get">
                    <label>
                        <input type="text" name="search">
                    </label>
                    <button  class="btn btn-success" type="submit">Search</button>
                </form>
            </div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category</th>
                    <th colspan="2">ACTION</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.getId()}</td>
                        <td>${product.getName()}</td>
                        <td>${product.getPrice()}</td>
                        <td>${product.getQuantity()}</td>
                        <td>${product.getDescribe()}</td>
                        <td>${product.getCategory()}</td>
                        <td><button  class="btn btn-success"><a style="text-decoration: none; color: white" href="${pageContext.request.contextPath}/products?action=edit&id=${product.getId()}">EDIT</a></button></td>
                        <td><button class="btn btn-success"><a style="text-decoration: none; color: white" href="${pageContext.request.contextPath}/products?action=delete&id=${product.getId()}">DELETE</a></button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
