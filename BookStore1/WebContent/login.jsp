<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
input {
	padding: 8px 12px;
}
</style>
<title>Login</title>
</head>
<body>

	<h3>Online Book Store</h3>
	<hr>
	<form action="VerifyUser" method="post">
		<label>User Name</label><br /> <input type="text" name="username"
			placeholder="Enter username " /><br /> <label>Password</label><br />
		<input type="password" name="password" /><br /> <label>Usertype
		</label><br /> <input type="radio" name="usertype" value="owner"
			checked="checked" />Owner<br /> <input type="radio" name="usertype"
			value="buyer" /> buyer <br /> RememberMe <input type="checkbox"
			name="save" value="yes" checked="checked" /><br /> <input
			type="submit" value="Login" />

	</form>
	<hr>
	<a href="registration.jsp">New-User</a>


</body>
</html>