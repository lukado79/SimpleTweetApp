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

	<table>
		<tr class="table-active">
			<th>Title</th>
			<th>Tweet Text</th>

		</tr>
		<c:forEach items="${tweet}" var="boo">
			<tr>
				<td>${boo.title}</td>
				<td>${boo.tweetText}</td>

			</tr>
		</c:forEach>

	</table>

	<h4>
		<a href="/SimpleTweetApp/user/all">Back to Users List</a>
s	</h4>

</body>
</html>