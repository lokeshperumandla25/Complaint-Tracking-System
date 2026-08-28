<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="signup" method="post">
	Username :<input type="text" name="username"><br>
	email :<input type="email" name="email"><br>
	password :<input type="password" name="password"><br>
	Role :
	<input type="radio" name="role" value="resident">Resident
	<input type="radio" name="role" value="admin">Admin
	<br>
	<br>
	<input type="submit" value="submit">

</form>

</body>
</html>