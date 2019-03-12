<%@ page import="ClassiComuni.Utente"%>
<html>
	<head>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css"> <!-- problema di contrasto con la finestra -->
		<link rel="stylesheet" href="CSS/PaginaInizialeStyle.css" type="text/css">
		
		<style>
		#bg {
    /* The image used */
    background-image: url("IMG/mongolfiere.jpg");

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
    margin-top:10%;
  }
}
@media screen and (max-width:500px) {
   .center-block {
    margin-left:0%;
    margin-top:10%;
  }
}

@media screen and (max-height:500px) {
   .center-block {
	margin-top:10%;
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
margin-top:2px;
margin-bottom:0px;
color:white;
}
		</style>
		
		
		
		
		
		
		
		<script type = "text/javascript" src="js/jquery3.js"></script>
		<script>
				function myFunction() {
					var test = /^.?[\s]+.?$/;
					if (document.getElementById("pass").value.match(test)){
						document.getElementById("par").innerHTML = "La password non può contenere spazi";
					}
					else {
						document.getElementById("par").innerHTML = "";
					}
					var pass = document.getElementById("pass").value;
					var pass2 = document.getElementById("pass2").value;
					var em = document.getElementById("par2").innerHTML;
					var f3 = document.getElementById("par3").innerHTML;
					var f4 = document.getElementById("par4").innerHTML;
					var f5 = document.getElementById("par5").innerHTML;
					var f6 = document.getElementById("par6").innerHTML;
					var e = document.getElementById("e").value;
					if(document.getElementById("par").innerHTML == ""){
						if(pass != pass2){
							document.getElementById("par").innerHTML = "password diverse";
						}
						if(pass == pass2 && pass!= ""){
							document.getElementById("par").innerHTML = "";
							if(em == "" && e!="" && f3 =="" && f4 =="" && f5 =="" && f6==""){
								document.getElementById("reg").disabled = false;
							}
						}
					}
				}
		</script>
	</head>
	<body onload="VisualizzaDati" id="bg">
		<%@ include file="barra_nav.html" %>
		<%@ include file="modifica_bar.jsp" %>
		<% String i = request.getParameter("modifica");
	if(i!=null && i.equals("si")){
		%> <h3 style="text-align:center; color:orange"> Il profilo è stato modificato correttamente!</h3> 
		
<% } %>
		<div class="container" id="demo"></div>
		<div class="container" id="b"></div>
		<script type = "text/javascript" src="js/jquery3.js"></script>
		
		
		<form action = "ServletModificaProfilo" method = "post">
			<div class="center-block" style= "margin:auto;">
				<script>				
					function loadJSONDoc() {
						var xmlhttp = new XMLHttpRequest();
						xmlhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {myFunction1(this);}};
						xmlhttp.open("GET", "JSONContacts?name=email", true); // recupera tutte le e-mail sul database
						xmlhttp.send();
					}
					function myFunction1(xmlhttp) {
						var i;
						var data = JSON.parse(xmlhttp.responseText); //recupera i dati json su html
						var e = document.getElementById("e").value;
						document.getElementById("par2").innerHTML = "";
						var test = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/;
						document.getElementById("par2").innerHTML = "";
						if(document.getElementById("e").value != ""){
							document.getElementById("par2").innerHTML = "E-mail non corisponde al formato adatto";
							button.invalidate=true;
						}
					}
					function myFunction2() {
						var i;
						var test = /^[0-9]+\S?$/;
						document.getElementById("par3").innerHTML = "";
						if(document.getElementById("cel").value != ""){
						if (document.getElementById("cel").value.match(test)){document.getElementById("par3").innerHTML = "";}
						else {document.getElementById("par3").innerHTML = "Numero di telefono non adatto al formato";}
						}
					}
					function myFunction3() {
						var i;
						var test = /^[a-zA-Z]+$/;
						document.getElementById("par5").innerHTML = "";
						if(document.getElementById("n").value != ""){
						if (document.getElementById("n").value.match(test)){document.getElementById("par5").innerHTML = "";}
						else {document.getElementById("par5").innerHTML = "Nome deve contenere solo caratteri";}
						}
					}
					function myFunction4() {
						var i;
						var test = /^[a-zA-Z]+$/;
						document.getElementById("par6").innerHTML = "";
						if(document.getElementById("c").value != ""){
						if (document.getElementById("c").value.match(test)){document.getElementById("par6").innerHTML = "";}
						else {document.getElementById("par6").innerHTML = "Cognome deve contenere solo caratteri";}
						}
					}
					function myFunction5() {
						var i;
						var test = /^[a-zA-Z]+$/;
						document.getElementById("par4").innerHTML = "";
						if(document.getElementById("naz").value != ""){
						if (document.getElementById("naz").value.match(test)){document.getElementById("par4").innerHTML = "";}
						else {document.getElementById("par4").innerHTML = "Nazione deve contenere solo caratteri";}
						}
					}
					function myFunction6() {
						var i;
						var test = /^[a-zA-Z]+$/;
						document.getElementById("par7").innerHTML = "";
						if(document.getElementById("ind").value != ""){
						if (document.getElementById("ind").value.match(test)){document.getElementById("par4").innerHTML = "";}
						else {document.getElementById("par7").innerHTML = "Indirizzo deve contenere solo caratteri";}
						}
					}
					</script>
					
				<div id="blocco">
				<%if(session.getAttribute("tipo").equals("a")){%>
					<div id="nome">
						<p>NOME</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("nome")%>" name = "nome" id="n" onKeyUp="myFunction3()" onKeyDown="myFunction()" required><p id="par5"></p>
					</div>
					<div id="cogn">	
						<p>COGNOME</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("cognome") %>" name = "cognome" id="c" onKeyUp="myFunction4()" onKeyDown="myFunction()"><p id="par6"></p>
					</div>
					<div id="em">	
						<p>E-MAIL*</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("email")%>" name = "email" id ="e" onKeyUp="loadJSONDoc()" onKeyDown="myFunction()" required><p id="par2"></p>
					</div>
					<div id="nazione">	
						<p>NAZIONALITA'</p>
						<input type = "text"  style="margin-left:150px;" value="<%=request.getAttribute("nazione")%>" name = "nazione" id="naz" onKeyUp="myFunction5()" onKeyDown="myFunction()"><p id="par4"></p>
					</div>
					<div id="nascita">	
						<p>DATA NASCITA</p>
						<input type = "date" style="margin-left:160px;" value ="<%=request.getAttribute("nascita") %>" name = "data" id="data">
					</div>
					<div id="num">	
						<p>NUMERO DI TELEFONO</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("cell") %>"  name = "cell" id="cel" onKeyUp="myFunction2()" onKeyDown="myFunction()"><p id="par3"></p>
					</div>
					<div id="indirizzo">
					<p> INDIRIZZO</p>
					<input type ="text" style ="margin-left:150px;" value="<%=request.getAttribute("indirizzo") %>" name ="indirizzo" id ="ind" onKeyUp="myFunction6()" onKeyDown="myFunction()"><p id="par7"></p>
					</div>
					<div id="pa">	
						<p>PASSWORD*</p>
						<input type = "password" style="margin-left:150px;" name = "pass" id="pass" onKeyUp="myFunction()" onKeyUp="myFunction()" required><p id="par"></p>
					</div>	
					<div id="pa2">
						<p>CONFERMA PASSWORD*</p>
						<input type = "password" style="margin-left:150px;" name = "pass2" id ="pass2" onKeyUp="myFunction()" required>
					</div>	
						<br/><br/>
						<input type="submit" value="MODIFICA" id="reg"  class="butt"  style="display: block; margin: 0 auto; width: 100px;"></input>
						<br/>
				</div>
				<%}else{%>
				<div id="nome">
						<p>NOME AZIENDA</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("nome")%>" name = "nome" id="n" onKeyUp="myFunction3()" onKeyDown="myFunction()" required><p id="par5"></p>
					</div>
					<div id="em">	
						<p>E-MAIL*</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("email")%>" name = "email" id ="e" onKeyUp="loadJSONDoc()" onKeyDown="myFunction()" required><p id="par2"></p>
					</div>
					<div id="nazione">	
						<p>NAZIONALITA'</p>
						<input type = "text"  style="margin-left:150px;" value="<%=request.getAttribute("nazione")%>" name = "nazione" id="naz" onKeyUp="myFunction5()" onKeyDown="myFunction()"><p id="par4"></p>
					</div>
					<div id="num">	
						<p>NUMERO DI TELEFONO</p>
						<input type = "text" style="margin-left:150px;" value="<%=request.getAttribute("cell") %>"  name = "cell" id="cel" onKeyUp="myFunction2()" onKeyDown="myFunction()"><p id="par3"></p>
					</div>
					<div id="indirizzo">
					<p> INDIRIZZO</p>
					<input type ="text" style ="margin-left:150px;" value="<%=request.getAttribute("indirizzo") %>" name ="indirizzo" id ="ind" onKeyUp="myFunction6()" onKeyDown="myFunction()"><p id="par7"></p>
					</div>
					<div id="pa">	
						<p>PASSWORD*</p>
						<input type = "password" style="margin-left:150px;" name = "pass" id="pass" onKeyUp="myFunction()" onKeyUp="myFunction()" required><p id="par"></p>
					</div>	
					<div id="pa2">
						<p>CONFERMA PASSWORD*</p>
						<input type = "password" style="margin-left:150px;" name = "pass2" id ="pass2" onKeyUp="myFunction()" required>
					</div>	
						<br/><br/>
						<input type="submit" value="MODIFICA" id="reg"  class="butt"  style="display: block; margin: 0 auto; width: 100px;"></input>
						<br/>
				</div>
				
				
				<%}%>
			</div>
	</form>
	<script>
		function displayN2(){
			document.getElementById("blocco").style.display = "block";
			document.getElementById("nome").style.display = "block";
			document.getElementById("cogn").style.display = "block";
			document.getElementById("em").style.display = "block";
			document.getElementById("nazione").style.display = "block";
			document.getElementById("nascita").style.display = "block";
			document.getElementById("num").style.display = "block";
			document.getElementById("pa").style.display = "block";
			document.getElementById("pa2").style.display = "block";
		}
		function displayN1(){
			document.getElementById("blocco").style.display = "block";
			document.getElementById("nome").style.display = "block";
			document.getElementById("cogn").style.display = "none";
			document.getElementById("em").style.display = "block";
			document.getElementById("nazione").style.display = "block";
			document.getElementById("nascita").style.display = "none";
			document.getElementById("num").style.display = "block";
			document.getElementById("pa").style.display = "block";
			document.getElementById("pa2").style.display = "block";
		}
	</script>	
	</body>
</html>