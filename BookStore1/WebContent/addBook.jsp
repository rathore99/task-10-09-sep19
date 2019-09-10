<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.center1{
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
<div class="center1">
<h1>Add New Book</h1>

<video controls>
<source src="Projects_in_PHP_and_MySQL_(83_videos).mp4">
</video>
<form action="AddBook" method="post">
<div>
<label style="text-align:left;">Book Code</label><br/>
<input type=text name="bookcode"><br/>
</div>
<div>
<label>Book Name</label><br/>
<input type=text name="bookname"><br/>
</div>
<div>
<label>Subject</label><br/>
<input type=text name="subject"><br/>
</div>
<div>
<label>Author</label><br/>
<input type=text name ="author"><br/>
</div>
<div>
<label>Price</label><br/>
<input type=text name="price"><br/>
</div>
<div>
<label>Upload book Cover</label><br/>
<input type="file" name="image"><br/>
</div>
<input type="submit" value="submit">
</form> 
</div>
</body>
</html>