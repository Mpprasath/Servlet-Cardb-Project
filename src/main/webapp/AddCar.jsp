<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Details</title>
</head>
<body>
	<h1>Enter car details:</h1>

	<form action="add-car" method="post">
		<input type="number" placeholder="Enter id" name="carId"><br><br> <input
			type="text" placeholder="Enter model" name="carModel"> <br><br> <input
			type="text" placeholder="Enter brand" name="carBrand"> <br><br> <input
			type="text" placeholder="Enter color" name="carColor"> <br><br> <input
			type="number" placeholder="Enter price" name="carPrice"> <br><br>  <input
			type="submit" value="Add">
	</form>
</body>
</html>