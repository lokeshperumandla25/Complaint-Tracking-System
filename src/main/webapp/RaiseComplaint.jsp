<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Submit a new Complaint</h2>
	<form action="RaiseComplaint" method="post">
		Category :<input type="text" name="category"><br><br>
		Subject :<input type="text" name="subject"><br><br>
		Description :
		<textarea rows="3" cols="50" name="description"></textarea><br><br>
		<input type="submit" value="submit">
	</form>

</body>
</html>