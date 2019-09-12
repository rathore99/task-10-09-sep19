<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
	long val=session.getMaxInactiveInterval();
	String user=(String)session.getAttribute("userid");
	if(user==null){
		response.sendRedirect("index.jsp");
	}
%>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>DashBoard-For-Admin</h3>
	<hr>
	<pre>
		<a href="AddBook">Add-Product</a>
		<a href="">Update-Product</a>
		<a href="">Remove-Product</a>
		<a href="">View-Orders</a>
		<a href="">Logout</a>
	</pre>		
	<hr>
</body>
</html>