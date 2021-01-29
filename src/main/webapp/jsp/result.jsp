<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>Решение квадратного уравнения</title>
	<link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<h2>Решение квадратного уравнения</h2>
<br>

<c:if test="${quadEq.a != 0}">
	<b><fmt:formatNumber groupingUsed="false" maxFractionDigits="10" value="${quadEq.a}"/></b>x&#178;
	<c:if test="${quadEq.b != 0}"> 
		+ <b><fmt:formatNumber groupingUsed="false" maxFractionDigits="10" value="${quadEq.b}"/></b>x
	</c:if>
	<c:if test="${quadEq.c != 0}">	
		 + <b><fmt:formatNumber groupingUsed="false" maxFractionDigits="10" value="${quadEq.c}"/></b>
	</c:if>
	= 0
	<br>
</c:if>

<c:if test="${quadEq.error != null}">
	<c:out value="${quadEq.error}" />
</c:if>

<c:if test="${quadEq.error == null}">
	<div class="roots">
		<c:if test="${quadEq.rootCount == 0}">
			Уравнение не имеет корней
		</c:if>	
		<c:if test="${quadEq.rootCount == 1}">
			x = <fmt:formatNumber groupingUsed="false" maxFractionDigits="10" value="${quadEq.x1}"/>
		</c:if>	
		<c:if test="${quadEq.rootCount == 2}">
				x&#8321; = <fmt:formatNumber groupingUsed="false" maxFractionDigits="10" value="${quadEq.x1}"/>
				x&#8322; = <fmt:formatNumber groupingUsed="false" maxFractionDigits="10" value="${quadEq.x2}"/>	
		</c:if>	
	</div>
</c:if>

<hr>

<form method="POST" action="/">
	<input name="a" type="hidden" value="<c:out value="${quadEq.a}"/>">
	<input name="b" type="hidden" value="<c:out value="${quadEq.b}"/>">
	<input name="c" type="hidden" value="<c:out value="${quadEq.c}"/>">
	<input type="submit" value="Назад">
</form>

</body>
</html>
