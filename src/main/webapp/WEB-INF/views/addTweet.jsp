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

	<h1>Add new Tweet</h1>

	<div>
		<form:form method="post" modelAttribute="tweet">
		
			Ttitle:<form:errors path="title" />
			<form:input path="title" />
			Tweet Text:<form:errors path="tweetText" />
			<form:input path="tweetText" />

			<!-- User: <form:select path="user.id" itemValue="id" itemLabel="lastName"
				items="${user}" />-->
			<input type="submit" value="Save">
		</form:form>
	</div>
	<h4>
		<a href="/SimpleTweetApp/home">Back to Home</a>


	</h4>
</body>
</html>