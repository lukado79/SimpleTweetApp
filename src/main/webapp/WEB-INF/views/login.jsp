<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/cosmo/bootstrap.min.css">
</head>
<body>
	<div>
		<h2>Login</h2>
		<form method="post" action="/SimpleTweetApp/login">
			<input type="text" name="email" placeholder="Enter username">
			<input type="password" name="password" placeholder="Enter password">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit" value="Log in">
		</form>
	</div>

	<div>
		<h2>Register</h2>
		<form:form action="/SimpleTweetApp/register" method="post" modelAttribute="user">
			<input path="firstName" placeholder="Enter firstname" />
			<input path="lastName" placeholder="Enter lastname" />
			<input path="email" placeholder="Enter email" />
			<input path="password" placeholder="Enter password" type="password" />
			<input path="role" value="user" type="hidden" />	
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<input type="submit" value="Register">
		</form:form>
	</div>
</body>
</html>