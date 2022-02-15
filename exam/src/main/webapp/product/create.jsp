<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/15/2022
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <p>Create New Product</p>
    </div>
    <div>
        <form action="" method="post">
            <table>
                <tr>
                    <th>Name</th>
                    <td><label>
                        <input type="text" placeholder="name" name="name">
                    </label></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><label><input type="text" name="price" placeholder="price"></label></td>
                </tr>
                <tr>
                    <th>Quantity</th>
                    <td><label><input type="text" name="quantity" placeholder="quantity"></label></td>
                </tr>
                <tr>
                    <th>Color</th>
                    <td><label><input type="text" name="color" placeholder="color"></label></td>
                </tr>
                <tr>
                    <th>Describe</th>
                    <td><label><input type="text" name="describe" placeholder="describe"></label></td>
                </tr>
                <tr>

                    <th>Category</th>
                    <td><label for=""></label><select name="category" id="">
                        <c:forEach items="${category}" var="category">
                            <option value="${category.getId()}">${category.getName()}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td><button type="submit"><a>Create</a></button></td>
                    <td><button><a href="${pageContext.request.contextPath}/products">Back</a></button></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
