<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<div>
		<h2>Register</h2>
	</div>
	<div>
		<form:form method="post" modelAttribute="user">
			Username
			<input path="username" placeholder="Username" />
			First name
			<input path="firstName" placeholer="First name" />
			Last name
			<input path="lastName" placeholder="Last name" />
			Email
			<input path="email" placeholder="Email" />
			Password
			<input type="password" path="password" placeholder="Password" />
			<input type="submit" value="Register" />
		</form:form>
	</div>

</body>
</html>