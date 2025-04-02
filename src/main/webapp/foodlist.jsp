<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2025. 04. 02.
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ételek listája</title>
</head>
<body>
<h1>Ételek listája</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Étterem</th>
        <th>Étel</th>
        <th>Ár(Ft)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="food" items="${foods}">
        <tr>
            <td>${food.id}</td>
            <td>${food.restaurantName}</td>
            <td>${food.foodName}</td>
            <td>${food.price}</td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/delete-food" style="display:inline;">
                    <input type="hidden" name="id" value="${food.id}" />
                    <button type="submit">Törlés</button>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/favorite-food" style="display:inline;">
                    <input type="hidden" name="id" value="${food.id}" />
                    <button type="submit">Kedvenc</button>
                </form>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

