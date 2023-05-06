<%@page import="java.util.Arrays"%>
<%@page import="dao.TrainDao"%>
<%@page import="dto.Train"%>
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
		TrainDao dao = new TrainDao();
		Train train = dao.fetch(Integer.parseInt(request.getParameter("number")));
	%>
	<form action="updatetrain" method="post">
		train no:<input type="number" name="tnumber"
			value="<%=train.getNumber()%>" readonly="readonly"><br>
		train name:<input type="text" name="tname"
			value="<%=train.getName()%>"><br> no of seats:<input
			type="number" name="tseat" value="<%=train.getSeat()%>"><br>


		station:
		<textarea rows="5" cols="30" name="tstation">
		<%
			for (String station : train.getStations()) {
				out.print(station + ",");
			}
		%>
	
		</textarea>
		<br> ticket price:
		<textarea rows="5" cols="30" name="tprice">
		<%
			for (String price : train.getPrice()) {
				out.print(price + ",");
			}
		%>
		</textarea>
		<br> time:
		<textarea rows="5" cols="30" name="ttime">
		<%
			for (String time : train.getTime()) {
				out.print(time + ",");
			}
		%>
		
		
		
		</textarea>
		<br> days:
		<textarea rows="5" cols="30" name="tdays">
		
		<%
					for (String days : train.getDays()) {
						out.print(days + ",");
					}
				%>
		
		
		
		</textarea>
		<br>
      <button type="reset">cancel</button>
		<button>Update</button>

	</form>
	<br>

</body>
</html>