<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recupera Password</title>
<link rel="icon" href="img/logo.png" type="image/x-icon" />
<style type="text/css">
body, html {
    height: 100%;
    margin: 0;
}

#bg {
    /* The image used */
    background-image: url("IMG/man.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

.center-block {
	border: 3px solid #fffff0;
	background: rgba(100,100,100,0.4);
	border-radius: 20px;
	width: 500px;
}

@media screen and (max-width:1300px) {
  /* For mobile phones: */
   .center-block {
    margin-left:30%;
    margin-top:5%;
  }
}

@media screen and (max-width:1000px) {
  /* For mobile phones: */
   .center-block {
    margin-left:20%;
    margin-top:5%;
  }
}
@media screen and (max-width:700px) {
   .center-block {
    margin-left:10%;
    margin-top:5%;
  }
}
@media screen and (max-width:500px) {
   .center-block {
    margin-left:0%;
    margin-top:5%;
  }
}

@media screen and (max-height:500px) {
   .center-block {
	margin-top:0%;
  }
}

@media screen and (max-height:450px) {
   .center-block {
	width: 350px;
  }
}

@media screen and (max-height:400px) {
   .center-block {
	font-size:8px;
  }
}

.butt {
	color:orange;
	background-color: black;
	border: 2px solid #FCA800;
	font-weight: bold;
	padding: 0;
	height: 25px;
	width: 80px;
}
p{
text-align:center;
font-weight: bold;
margin-top:0px;
margin-bottom:0px;
color:white;
}
</style>
</head>
<body id="bg">

<div id="bar"></div>
	<script type="text/javascript" src="js/jquery3.js"></script>
	<script type="text/javascript"> 
		$(document).ready(function(){
			$("#bar").load("barra_nav.html"); 
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {myFunction1(this);}
			};
			xmlhttp.open("GET", "PacchettiJSON", true);
			xmlhttp.send();
		});


</script>

	<div class="center-block" style= "margin:auto;">
		<% 
			String errore = request.getParameter("errore");
			if(errore!=null && errore.equals("si")){
		%>  
				<h3 style="text-align:center; color:red"> L'email inserita non esiste!</h3><% 
			}	
		%>
		
		<form action = "RecuperaPasswordServlet" method = "post">
		<script>
			function myFunction1(xmlhttp) {
				var i;
				var data = JSON.parse(xmlhttp.responseText); //recupera i dati json su html
				var e = document.getElementById("e").value;
				document.getElementById("par2").innerHTML = "";
				var test = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/;
				document.getElementById("par2").innerHTML = "";
				if(document.getElementById("e").value != ""){
				if (document.getElementById("e").value.match(test))
				{
	
		
				}
				else
				{
					document.getElementById("par2").innerHTML = "E-mail non corisponde al formato adatto";
					button.invalidate=true;
				}
				}
			}
			</script>
			<p>INSERIRE E-MAIL</p>
			<input type = "email" style="margin-left:150px;" name = "email" id ="e" onKeyDown="myFunction1()"><p id="par2"></p>
			<input type="submit" value="Conferma" id="reg"  class="butt"  style="display: block; margin: 0 auto; width: 100px;"></input>
			<br/>
		</form>
	</div>
</body>
</html>