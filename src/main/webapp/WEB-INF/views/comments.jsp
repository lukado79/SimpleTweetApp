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
	<h1>Comments</h1>
	<table>
		<tr class="table-active">
			<th>Id</th>
			<th>Title</th>
			<th>Tweet Text</th>
			<th>Created</th>
			<th>User Name</th>
		</tr>
		<c:forEach items="${comment}" var="tweet">
		<tr>
			<td>${tweet.id}</td>
			<td>${tweet.title}</td>
			<td>${tweet.tweetText}</td>
			<td>${tweet.created}</td>
			<td>${tweet.user.username}</td>
		</tr>
		<tr>
			<td>Comments</td>
		</tr>
		<tr>
			<td>Id</td>
			<td>Text</td>
			<td>Created</td>
			<td>User Name</td>
		</tr>
		<c:forEach items="${tweet.comments}" var="boo">
			<tr>
				<td>${boo.id}</td>
				<td>${boo.text}</td>
				<td>${boo.created}</td>
				<td>${boo.user.username}</td>
			</tr>


		</c:forEach>
		</c:forEach>
	</table>
</body>
</html>