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
	<h1>Car Details:</h1>
	<%ResultSet rs= (ResultSet) request.getAttribute("resultSet"); %>
	<table border="1">
		<tr>
			<th>carId</th>
			<th>carModel</th>
			<th>carBrand</th>
			<th>carColor</th>
			<th>carPrice</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getInt(5)%></td>
			<td><a href="find-car-by-id?carId=<%=rs.getInt(1)%>">update</a></td>
			<td><a href="delete-car-by-id?carId=<%=rs.getInt(1)%>">delete</a> </td>
		</tr>
		<%}%>
		
	</table>

	<a href="index.jsp">Go back to Dashboard</a>

</body>
</html>