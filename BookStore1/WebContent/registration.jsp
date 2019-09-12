<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
div {
	width: 100%;
	height: 100%;
	
	
}
form{
 margin: 0 auto;
 width: 800px;
 align: center;
 
}

input {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0px;
	display: inline-block;
	text-align: center;
	box-sizing: border-box
}

.txt {
	text-align: left;
}
</style>

</head>
<body style = "text-align:left">
	<div>
	<h3>Online Book Store</h3>
	<h4>Registration-Form</h4>
	<hr>
	<form action="SaveUser" method="post">
		<label class="txt">User Name</label><br />
		<input type="text" name="username" /><br/>
		<label class="txt">Password</label><br />
		<input type="password" name="password" /><br/>
		<label class="txt">Mobile</label><br />
		<input type="text" name="mobile" /><br/>
		<label class="txt">Email-Id</label><br />
		<input	type="text" name="email" /> <br/>
		<label class="txt">Address</label><br />
		<input type="text" name="address" /><br/>
		<input type="submit" value="Register" />

	</form>
	<hr>
	<a href="index.jsp">Home</a>

</div>
</body>
</html>