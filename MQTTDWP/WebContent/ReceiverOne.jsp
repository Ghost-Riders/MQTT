<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Controller_Entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Receiver</title>
</head>
<body>

<div class="container">
  <h2>ReceiverOne:</h2>
 <br>
  <form action="ReceiverOne" method="get">
    <div class="form-group">
      <label for="msgarea">Old Messages:</label>
      <% 
      E_receiver e_receiver=new E_receiver();
		String receive =e_receiver.receives();
		System.out.println(receive+" psge");
      %>
     
      <input type="text" id="receivertext1" name="receivertext1" value="<%=receive %>"><br><br>
      <label>Insert message</label><br>
      <input type="text" id="receivertext" name="receivertext"><br><br>
      <button type="submit" class="btn btn-danger" >Receive</button>
      <!-- <button type="submit" class="btn btn-success" >Submit</button> -->
    </div>
  </form>
</div>

</body>
</html>