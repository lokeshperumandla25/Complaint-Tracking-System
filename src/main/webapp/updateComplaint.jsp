<%@page import="com.model.Complaint"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% Complaint com =(Complaint)request.getAttribute("complaint");%>
<h2>My Complaints</h2>

<form action="UpdatedComplaint" method="post">
		<input type="hidden" name="complaintId" value=<%=com.getComplaintId() %>>
		<input type="hidden" name="userId" value=<%=com.getUserId() %>>
		Category :<input type="text" name="category" value=<%=com.getCategory()%>><br><br>
		Subject :<input type="text" name="subject" value=<%=com.getSubject()%>><br><br>
		Description :
		<textarea rows="3" cols="50" name="description"><%=com.getDescription()%></textarea><br><br>
		<input type="hidden" name="status" value=<%=com.getStatus() %>>
		<input type="submit" value="submit">
	</form>
</body>
</html>