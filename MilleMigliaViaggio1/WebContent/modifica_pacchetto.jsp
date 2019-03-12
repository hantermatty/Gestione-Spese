<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSS/PaginaInizialeStyle.css" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
legend {
    padding: 3px 6px;
}

.output {
    font: 1rem 'Fira Sans', sans-serif;
}

label {
    margin-top: 1rem;
    display: block;
    font-size: .8rem;
}
</style>
<title>Modifica Pacchetto</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background:lightblue;">
<%@ include file="barra_nav.html" %>
<%@ include file="modifica_bar.jsp" %>
<script type="text/javascript" src="js/jquery3.js"></script>
<% String i = request.getParameter("modifica");
	if(i!=null && i.equals("si")){
		%> <h2> La modifica è avvenuta con Successo!</h2> 
		
<% } %>

<form enctype="multipart/form-data" action="ModificaPacchetto.html" method="post">
<div class='col s12 m7' style="background:lightblue;">
<div class='card horizontal' id='a'style="background:lightblue;box-shadow: inset 0 0 0px;">
<div style="width:50%;line-height: 32px;margin-left:25%;">
<input type="hidden" name="codm" value="<%= request.getParameter("codm") %>"/>

<fieldset style="border-style:solid;border-color:black;border-width: 5px;">
    <legend>Info pacchetto</legend>

    <div>
        <label for="descr_p">Descrizione pacchetto:</label>
        <textarea id="descr_p"  name="descr_p" required><%=request.getAttribute("descrizione_pacchetto")%></textarea>
    </div>
    <div>
        <label for="prezzo">Prezzo:</label>
        <input type="text" id="prezzo" value="<%=request.getAttribute("prezzo")%>"name="prezzo" onKeyUp="myFunction4.call(this)" required/>
    	<span id ="prezzo_span"></span>
    </div>
    <div>
        <label for="data_p">Data partenza:</label>
        <input type="date" id="data_p" value="<%=request.getAttribute("data_inizio")%>" name="data_p" value="AAAA/MM/GG" required>
    </div>
    <div>
        <label for="data_r">Data ritorno:</label>
        <input type="date" id="data_r" value="<%=request.getAttribute("data_fine")%>" name="data_r"  value="AAAA/MM/GG" required>
    </div>
    <div>
        <label for="descr_l">Descrizione luogo:</label>
        <textarea id="descr_l"  name="descr_l" required><%=request.getAttribute("descrizione_luogo")%></textarea>
    </div>
    <div>
        <label for="dest">Destinazione:</label>
        <input type="text" id="dest"  value="<%=request.getAttribute("destinazione")%>"name="dest" onKeyUp="myFunction3.call(this)" required/>
    	<span id ="dest_span"></span>
    </div>
    <div>
        <label for="naz">Nazione:</label>
        <select id="naz" name="naz" required> </select>
    </div>
    <div>
        <label for="file">Immagine:</label>
        <input type="file" id="file"  value="<%=request.getAttribute("immagine")%>" name="file" required>
    </div>
</fieldset>
</div>
<div style="width:50%;margin-left:25%;">
<fieldset style="border-style:solid;border-color:black;border-width: 5px;">
    <legend>Info struttura</legend>

    
    <div>
        <label for="indirizzo">Indirizzo:</label>
        <input type="text" id="indirizzo"  value="<%=request.getAttribute("indirizzo")%>" name="indirizzo" onKeyUp="myFunction5.call(this)" required>
    	<span id ="indirizzo_span"></span>
    </div>
    <div>
        <label for="tipo">Tipo:</label>
        <input type="text" id="tipo"  value="<%=request.getAttribute("tipo_a")%>" name="tipo" onKeyUp="myFunction3.call(this)" required/>
    	<span id ="tipo_span"></span>
    </div>
    <div>
        <label for="prezzo_s">Prezzo:</label>
        <input type="text" id="prezzo_s"  value="<%=request.getAttribute("prezzo_a")%>" name="prezzo_s" onKeyUp="myFunction4.call(this)" required/>
    	<span id ="prezzo_s_span"></span>
    </div>
    <div>
        <label for="servizio">Servizio:</label>
        <textarea id="servizio" name="servizio" required><%=request.getAttribute("servizi")%></textarea>
    	<span id ="servizio_span"></span>
    </div>
</fieldset>
<fieldset style="border-style:solid;border-color:black;border-width: 5px;">
    <legend>Info Volo</legend>

    <div>
        <label for="compagnia">Compagnia:</label>
        <input type="text" id="compagnia"  value="<%=request.getAttribute("compagnia_v")%>" name="compagnia" onKeyUp="myFunction3.call(this)" required>
        <span id ="compagnia_span"></span>
    </div>
    <div>
        <label for="prezzo_v">Prezzo:</label>
        <input type="text" id="prezzo_v" value="<%=request.getAttribute("prezzo_v")%>" name="prezzo_v" onKeyUp="myFunction4.call(this)" required/>
        <span id ="prezzo_v_span"></span>
    </div>
    <div>
        <label for="ora_p">Ora partenza:</label>
        <input type="time" id="ora_p" value="<%=request.getAttribute("ora_partenza")%>"  name="ora_p" value="99:99" required/>
    </div>
    <div>
        <label for="ora_r">Ora ritorno:</label>
        <input type="time" id="ora_r"  value="<%=request.getAttribute("ora_ritorno")%>" name="ora_r" value ="99:99" required/>
    </div>
</fieldset>
</div>
</div>
<hr style="border:0px solid #00bfff;">
<input type ="submit" value="Modifica pacchetto" style="background-color:black;width:200px;border-radius: 0px;font-size: 16px;margin-left:40%;">
<br>
<p></p>
</form>



<script type="text/javascript" src="js/jquery3.js"></script>
	<script type="text/javascript">
	
	if(a=="ok"){$("#alert").show();}
	window.setTimeout("scompari()", 3000);
	function scompari(){
		$("#alert").fadeOut();
	}
		$(document).ready(function() 
		{	// serve per selezionare i paesi nel campo nazione che sono contenuti in paesi.xml
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {if (this.readyState == 4 && this.status == 200) {myFunction2(this);}};
			xmlhttp.open("GET", "XML/paesi.xml");
			xmlhttp.send();
		});
		function myFunction2(xml) {
			document.getElementById("naz").innerHTML = "<option></option>";
			var xmlDoc = xml.responseXML;
			var x = xmlDoc.getElementsByTagName("continente");
			for(i=0;i<x.length;i++){
				var p = x[i].getElementsByTagName("paese");
				for(j=1;j<p.length;j++){
					document.getElementById("naz").innerHTML += "<option>"+p[j].childNodes[0].nodeValue+"</option>";
				}	
		}
	}
		// validazione del codice
	function myFunction5() {
			var codice = this.id;
			var test = /^[0-9a-zA-Z]+$/;
			if (document.getElementById(codice).value.match(test)){document.getElementById(codice + "_span").innerHTML = "";}
			else {document.getElementById(codice + "_span").innerHTML = "Formato non corretto";}
	}
		// validazione del prezzo
	function myFunction4() {
		var prezzo = this.id;
		var test = /^[0-9]+$/;
		if (document.getElementById(prezzo).value.match(test)){document.getElementById(prezzo + "_span").innerHTML = "";}
		else {document.getElementById(prezzo + "_span").innerHTML = "Formato non corretto!";}
	}
	function myFunction3() {
		var prezzo = this.id;
		var test = /^[a-zA-Z]+$/;
		if (document.getElementById(prezzo).value.match(test)){document.getElementById(prezzo + "_span").innerHTML = "";}
		else {document.getElementById(prezzo + "_span").innerHTML = "Formato non corretto";}
	}
	
	
	</script>
</body>
</html>