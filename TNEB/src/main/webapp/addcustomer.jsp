<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
}

form {
  max-width: 300px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 4px;
}

input[type="text"],
input[type="tel"],
input[type="number"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type="submit"] {
  width: 100%;
  padding: 10px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #45a049;
}

input[type="text"]:focus,
input[type="tel"]:focus,
input[type="number"]:focus {
  outline: none;
  border-color: #007bff;
}</style>
</head>

<body>
<form action="consumerregister" method="post">
		<input type="text" name="name" placeholder="Enter customer name"><br>
		<input type="tel" name="consumernumber" placeholder="Enter customer consumer no"><br>
		<input type="number" name="bill" placeholder="Enter customer bill amount"><br> 
		<input type="submit" value="Register">
	</form>
</body>
</html>