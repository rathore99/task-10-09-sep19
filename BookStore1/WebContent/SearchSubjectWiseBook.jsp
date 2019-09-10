<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Book</title>
<style>
div{
width: 100%;
height: 100%;
text-align:center;
align:center;
}
input{
width: 50%;
padding: 12px 20px;
margin: 8px 0px;
display: inline-block;
box-sizing: border-box
}
label{
text-align:left;
}
</style>
</head>
<body>
<div>
<h2>Search Books</h2>
<form action="SearchBooks" method="get">
<input type="text" name="booksubject" >
<input type="submit" value="submit">
</form>
</div>
</body>
</html>