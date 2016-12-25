<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bg.ittalents.model.WeatherData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Weather</title>
</head>
<body>
	<form action="./" method= "post">
	<label>Enter city   </label>
	<input type = "text" name="city" required/>
	</br>
	<label>Enter country</label>
	<input type = "text" name="country"/>
	<input type = "submit"/>
	</br>
	</form>
	
	<%
		if (request.getAttribute("data")!= null ) {
			WeatherData data =(WeatherData) request.getAttribute("data");
			out.print("<table align = 'center' border = '1'>");
			out.print("<tr>");
			out.print("<td> City: </td> <td>"+ data.getCity()+"</td>");
			out.print("<tr>");
			out.print("<td> Description: </td> <td>"+ data.getDescription()+"</td>");
			out.print("<tr>");
			out.print("<td> Temperature: </td> <td>"+ data.getTemp()+"</td>");
			out.print("<tr>");
			out.print("<td> Humidity: </td> <td>"+ data.getHumidity()+"</td>");
			out.print("<tr>");
			out.print("<td> Wind Speed: </td> <td>"+ data.getWindSpeed()+"</td>");
			out.print("<tr>");
			out.print("<td>Image </td> <td><img src='"+ data.getIconURL()+"'/></td>");
		}
	%>
</body>
</html>