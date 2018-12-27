<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div>
		<h2>Login</h2>
	</div>
	<div>
		<form:form method="post" modelAttribute="user">
			Username 
			<input path="username" placeholder="Username" />
			Password 
			<input type="password" path="password" placeholder="Password" />
			<input type="submit" value="Login" />
		</form:form>
	</div>
	<div>
		<h4>
			<a href="/SimpleTweetApp/home">Back to Home</a>
		</h4>
	</div>
</body>
</html>