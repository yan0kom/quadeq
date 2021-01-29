<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Решение квадратных уравнения</title>
	<link href="/css/styles.css" rel="stylesheet" type="text/css">
 	<script src="/js/jquery-3.5.1.min.js"></script>
 	<script src="/js/jquery-dateformat.min.js"></script>
	<script src="/js/input.js"></script>
</head>

<body>

<h2>Решение квадратных уравнений</h2>
<br>
<b>a</b>x&#178; + <b>b</b>x + <b>c</b> = 0
<br>
<form method="POST" action="/eval" class="coeffs-form">
	<label for="a">a =</label>
	<input name="a" type="number" step="any" value="<c:out value="${coeffs.a}"/>">
	<label for="b">b =</label>
	<input name="b" type="number" step="any" value="<c:out value="${coeffs.b}"/>">
	<label for="c">c =</label>
	<input name="c" type="number" step="any" value="<c:out value="${coeffs.c}"/>">
	<input type="submit" value="Решить">
</form>
<hr>
<input id="evalHistoryBtn" type="button" value="История решений">
<div class="historyBlock"></div>
</body>
</html>
