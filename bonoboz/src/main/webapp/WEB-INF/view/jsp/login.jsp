<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div th:if="${param.success}">
			<label>You have been logged in now</label>
		</div>
		<div th:if="${param.error}">
			<label>Invalid user Name or password.</label>
		</div>
		<div th:if="${param.logout}">
			<label> You have been logged out.</label>
		</div>

		<form th:action="@/login" method="post">
			<div>
				<label>User name: <input type="text" name="username" /><br />
					<br /></label>
			</div>
			<div>
				<label>Password:<input type="password" name="password" /><br />
					<br />
				</label>
			</div>
			<input type="submit" value="login" />


		</form>
	</div>
</body>
</html>