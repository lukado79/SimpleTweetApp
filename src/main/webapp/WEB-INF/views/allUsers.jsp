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

	<h1>All Users List</h1>

	<h4>
		<a href="/SimpleTweetApp/user/add">Add User</a>


	</h4>

	<table>
		<tr class="table-active">
			<th>Id</th>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
			<th>Tweets</th>
		</tr>
		<c:forEach items="${users}" var="boo">
			<tr>
				<td>${boo.id}</td>
				<td>${boo.username}</td>
				<td>${boo.firstName}</td>
				<td>${boo.lastName}</td>
				<td>${boo.email}</td>
				<td><a href="<c:url   value="/user/edit/${boo.id}"/>">Edit</a>
					<a href="<c:url   value="/user/delete/${boo.id}"/>">Delete</a></td>
				<td><a href="<c:url   value="/user/${boo.id}/tweets"/>">Tweets of User</a></td>

			</tr>
		</c:forEach>

	</table>
	<h4>
		<a href="/SimpleTweetApp/home">Back to Home</a>


	</h4>


</body>
</html>