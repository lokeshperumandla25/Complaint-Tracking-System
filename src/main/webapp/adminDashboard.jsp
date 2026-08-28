<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello <%= session.getAttribute("username") %></h1>

<ul>
	<li><a href="adminViewComplaint">View All Complaint</a></li>
	<li><a href="">Logout</a></li>
</ul>

</body>
</html>