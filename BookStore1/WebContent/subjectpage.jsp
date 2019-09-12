<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	long val = session.getMaxInactiveInterval();
	String user = (String) session.getAttribute("userid");
	if (user == null) {
		response.sendRedirect("index.jsp");
	}
%>
<%
	String sql = "SELECT distinct subject from book";
	java.sql.ResultSet rs = com.bookstore.DBManager.getResultSet(sql);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>subject</title>
</head>
<body>
	<form action="BookListServlet">
		subject<select name="subject">
			<option>SELECT</option>
			<%
				while (rs.next()) {
					String s1 = rs.getString(1);
			%>
			<option><%=s1%></option>
			<%
				}
			%>
		
	</form>
</body>
</html>