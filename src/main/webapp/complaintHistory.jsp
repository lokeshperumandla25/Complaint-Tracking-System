<%@page import="java.util.List"%>
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
<%List<Complaint> complaints= (List<Complaint>)request.getAttribute("complaints"); %>
<h2>My Complaints</h2>

<table border="1">

<tr>	
	<th>ComplaintId</th>
	<th>UserId</th>
	<th>Category</th>
	<th>Subject</th>
	<th>Description</th>
	<th>Status</th>
</tr>

<% for(Complaint com:complaints){ %>
<tr>
	<td><%=com.getComplaintId() %></td>
	<td><%=com.getUserId() %></td>
	<td><%=com.getCategory() %></td>
	<td><%=com.getSubject() %></td>
	<td><%=com.getDescription() %></td>
	<td><%=com.getStatus() %></td>

</tr>
<%} %>

</table>


</body>
</html>