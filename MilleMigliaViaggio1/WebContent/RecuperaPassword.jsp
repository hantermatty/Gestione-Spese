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
		<form action="AggiornaPasswordServlet" method ="post">
		
		<script>
		function passCtrl() {
			if(document.getElementById("pass").value != document.getElementById("pass2").value){
  				alert("Le password inserite sono diverse! \n La password non è stata modificata!");
				return false;
			}
			document.modulo.submit();
		}				
	</script>
	
	
	<script >
function myFunction() {
var test = /^.?[\s]+.?$/;
if (document.getElementById("pass").value.match(test)){document.getElementById("par").innerHTML = "La password non può contenere spazi";}
else {document.getElementById("par").innerHTML = "";}
var pass = document.getElementById("pass").value;
var pass2 = document.getElementById("pass2").value;
if(pass != pass2){document.getElementById("par").innerHTML = "password diverse";
if(pass == pass2 && pass!= ""){document.getElementById("par").innerHTML = "";if(em == ""){document.getElementById("reg").disabled = false;}}
}
}

	</script>
				<div id="pa">	
						<p>PASSWORD*</p>
						<input type = "password" style="margin-left:150px;" name = "pass" id="pass" onKeyUp="myFunction()" onKeyUp="myFunction()" required><p id="par"></p>
					</div>	
					<div id="pa2">
						<p>CONFERMA PASSWORD*</p>
						<input type = "password" style="margin-left:150px;" name = "pass2" id ="pass2" onKeyUp="myFunction()" required>
					</div>	
						<br/><br/>
						<input type="submit" onclick="passCtrl()" value="REGISTRA" id="reg"  class="butt"  style="display: block; margin: 0 auto; width: 100px;"></input>
						<br/>
		</form>
		
		</div>
</body>
</html>