<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All User Roles List</h1>

	<h4>
		<a href="/SimpleTweetApp/userRole/add">Add </a>


	</h4>

	<table>
		<tr class="table-active">
			<th>Id</th>
			<th>User Role</th>

		</tr>
		<c:forEach items="${userRoles}" var="boo">
			<tr>
				<td>${boo.id}</td>
				<td>${boo.userRole}</td>
	
				<td><a href="<c:url   value="/userRole/delete/${boo.id}"/>">Delete</a></td>

			</tr>
		</c:forEach>

	</table>

	<h4>
		<a href="/SimpleTweetApp/home">Back to Home</a>


	</h4>

</body>
</html>