<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Train> list = (List<Train>) request.getAttribute("list");
	%>
	<table border="1">
		<tr>
			<th>train name</th>
			<th>train number</th>
			<th>seats available</th>
			<th>from station</th>
			<th>to station</th>
			
			<th>time of departure</th>
			<th>time of arrival</th>
			<th>available days</th>
			<th>book</th>

		</tr>
		<%
			for (Train train : list) {
		%>
		<tr>
			<th><%=train.getName()%></th>
			<th><%=train.getNumber()%></th>
			<th><%=train.getStations()[0]%></th>
			<th><%=train.getStations()[train.getStations().length - 1]%></th>

			<th><%=train.getTime()[0]%></th>
			<th><%=train.getTime()[train.getTime().length - 1]%></th>

			<th><%=Arrays.toString(train.getDays())%></th>
			<th><button>book</button></th>

		</tr>
		<%
			}
		%>



	</table>
</body>
</html>