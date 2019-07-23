<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Sender</title>
</head>
<body>

<div class="container">
  <h2>SenderOne:</h2>
 <br>
  <form action="SenderOne" method="post">
    <div class="form-group">
      <label for="msgarea">Old Messages:</label>
      <textarea class="form-control" rows="5" id="senderarea" name="senderarea"></textarea><br>
      <label>Insert message</label><br>
      <input type="text" name="sendertext" id="sendertext"><br><br>
      <button type="submit" class="btn btn-success" >Submit</button>
    </div>
  </form>
</div>

</body>
</html>