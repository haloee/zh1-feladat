<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" %>

<html>
<head>
    <title>${title}</title>
</head>
<body>

<h2>Sziasztok!</h2>

<nav>
    <a href="${pageContext.request.contextPath}/foods">Étel lista</a> |
    <a href="${pageContext.request.contextPath}/add-food">Új étel</a>
</nav>

<hr/>

<jsp:doBody />

</body>
</html>
