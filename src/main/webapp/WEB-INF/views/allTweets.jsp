<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/cosmo/bootstrap.min.css">
</head>
<body>
	<h1>All Tweets List</h1>

	<h4>
		<a href="/SimpleTweetApp/tweet/add">Add Tweet</a>


	</h4>

	<table>
		<tr class="table-active">
			<th>Id</th>
			<th>Title</th>
			<th>Tweet Text</th>
			<th>Created</th>
			<th>User First Name</th>
			<th>User Last Name</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${tweet}" var="boo">
			<tr>
				<td>${boo.id}</td>
				<td>${boo.title}</td>
				<td>${boo.tweetText}</td>
				<td>${boo.created}</td>
				<td>${boo.user.firstName}</td>
				<td>${boo.user.lastName}</td>
				<td><a href="<c:url   value="/tweet/delete/${boo.id}"/>">Delete</a></td>
			</tr>
			<tr class="table-active">
				<td>Comments</td>
			</tr>
				<tr class="table-active">
				<td><a href="/SimpleTweetApp/comment/add">Add Comments</a></td>
			</tr>
		</c:forEach>

	</table>

	<h4>
		<a href="/SimpleTweetApp/home">Back to Home</a>


	</h4>

</body>
</html>