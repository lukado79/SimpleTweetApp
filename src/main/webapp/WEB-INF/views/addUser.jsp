<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>Add new User</h1>

	<div>
		<form:form method="post" modelAttribute="user">
			Username:<form:errors path="username" />
			<form:input path="username" />
			First Name:<form:errors path="firstName" />
			<form:input path="firstName" />
			Last Name:<form:errors path="lastName" />
			<form:input path="lastName" />
			Email:<form:errors path="email" />
			<form:input path="email" />
			Password:<form:errors path="password" />
			<form:input path="password" />
			<input type="submit" value="Save">
		</form:form>
	</div>
	<h4>
		<a href="/SimpleTweetApp/home">Back to Home</a>
	</h4>
</body>
</html>