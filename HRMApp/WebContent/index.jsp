<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="./login" method="post">
		UserName<input type="text" name="username"><br>
		Password<input type="text" name="password"><br>
		<input type="submit" value="Submit">
		</form>
		<p style="color:red;">${msg}</p>
</body>
</html>