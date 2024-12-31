<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update car details:</h1>

	<%
	ResultSet rs = (ResultSet) request.getAttribute("result");
	rs.next();
	%>
	<form action="save-updated-car" method="post">
		<input type="number" value="<%=rs.getInt("regid")%>" name="carId" readonly="readonly"><br><br> 
		<input type="text" value="<%=rs.getString(2)%>" name="carModel"> <br><br>
		<input type="text" value="<%=rs.getString(3)%>" name="carBrand"><br><br> 
		<input type="text" value="<%=rs.getString(4)%>" name="carColor"> <br><br>
		<input type="number" value="<%=rs.getInt(5)%>" name="carPrice"><br><br>
	    <input type="submit" value="update">
	</form>
</body>
</html>