<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello <%= session.getAttribute("username") %></h1>

<ul>
	<li><a href="RaiseComplaint.jsp">Raise Complaint</a></li>
	<li><a href="residentViewComplaint">View my Complaint</a></li>
	<li><a href="ComplaintHistory">Complaint History</a></li>
	<li><a href="index.html">Logout</a></li>
</ul>
</body>
</html>