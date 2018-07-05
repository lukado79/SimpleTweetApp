<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/cosmo/bootstrap.min.css">
</head>
<body>

	<h1>Edit User</h1>

	<div class="form-group">
		<form:form method="post" modelAttribute="user">
			First Name:<form:errors path="firstName" />
			<form:input path="firstName" />
			Last Name:<form:errors path="lastName" />
			<form:input path="lastName" />
			Email:<form:errors path="email" />
			<form:input path="email" />
			<input type="submit" value="Save">
		</form:form>
	</div>
	<h4>
		<a href="/SimpleTweetApp/home">Back to Home</a>
	</h4>
</body>
</html>