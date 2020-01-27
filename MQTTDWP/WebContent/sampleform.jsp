<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Name Val</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function vali(){
                var name=document.getElementById('txt').value;
                var pattern=/^[a-zA-Z]+$/;
                if(name==''){
                    alert("pL dont empty");
                }
                else if(!name.match(pattern)){
                	alert("pL dont empty char only");
                }
                else{
                    
                }
            }
        </script>
    </head>
    <body>
        
        
        
        <form>
            <input type="text" id="txt">
            <input type="button" id="btn1" value="submit" onclick="vali()">
            
        </form>
    </body>
</html>