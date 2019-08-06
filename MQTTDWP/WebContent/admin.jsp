<%@page import="java.util.*"%>
<%@page import="com.Controller_Entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Controller_Entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Admin</title>
</head>
<body>
	<%
		E_Queue_list eque = new E_Queue_list();
		List<String> r = eque.qlist();
		ListIterator lr = r.listIterator();

		E_Topic_list topic = new E_Topic_list();
		List<String> t = topic.tlist();
		ListIterator lt = t.listIterator();
	%>
	<div class="container">
		<h2>USERS</h2>
	<!-- 	<p>Sender <a href="SenderOne.jsp">Click here</a></p>
		<p>Receiver <a href="ReceiverOne.jsp">Click here</a></p> -->
		<h2>Active MQ Details</h2>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Queues List</th>
				</tr>
			</thead>

			<tbody>

				<%
					int i = 0;
					while (lr.hasNext()) {
						i++;
						
				%>
				<tr>
					<td><%=i%></td>
					<td><%=lr.next()%></td>
				</tr>
				<%
					
					}
				%>

			</tbody>
		</table>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Topics List</th>
				</tr>
			</thead>

			<tbody>

				<%
					int j = 0;
					while (lt.hasNext()) {
						j++;
						
				%>
				<tr>
					<td><%=j%></td>
					<td><%=lt.next()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
</body>
</html>