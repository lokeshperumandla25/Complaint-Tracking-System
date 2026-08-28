<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int complaintId =Integer.parseInt(request.getParameter("complaintId")); %>

<form action="UpdateStatus" method="post">
	<input type="hidden" name="complaintId" value=<%=complaintId %>>
	<input type="radio" name="status" value="pending">Pending
	<input type="radio" name="status" value="progress">Progress
	<input type="radio" name="status" value="resolved">Resolved

	<input type="submit" value="update">

</form>

</body>
</html>