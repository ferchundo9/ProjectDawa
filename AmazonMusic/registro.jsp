 <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[registro]</title>
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estilo.css" >
		<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">
		<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		
    </head>
	<!-- ------------------------------------------------------------------ -->
	
	
	<!-- Codificacion en UTF-8 con Tomcat -->
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!--................................  -->
	
	<!-- Librerias para manejo de datos del servlet --------------------------->
	<%@ page language="java" import="java.util.*" %>
	<%@ page language="java" import="businessLogic.*" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@page isELIgnored="false" %>
	<!-- .....................................................................-->
	
    <body class=bodyLogin>
	<!-- Gif que se muestra mientras carga la pagina -->
	<script type="text/javascript">$(window).load(function() {$(".loader").fadeOut("slow");});</script>
	<div class="loader"></div>
	<!-- ---------------------   ENCABEZADO  ------------------------------ -->
		<header>
			<center>
			<form method="POST" action="Controlador" class="Controlador">
					<input type="hidden" name="VolverHome" value=1></input>
					<button class="botonInvisibleLogin" ><img class=logoLogin src="./img/logo.png" /></button>
			</form>
			</center>
		</header>
	<!-- ------------------------------------------------------------------ -->

	<!-------------------------   CUERPO -------------------------------------->
	<center >
		<form method="POST" action="Controlador" class="Controlador">
			<div class=iniciarSesion>
				<h2>Crear cuenta</h2>
				<p>Nombre</p>
				<input class="registro input" type=text name="nombreRegistro" required ></input>
				<p>Correo electrónico</p>
				<input class="input registro" type=email name="emailRegistro" required></input>
				<p>Dirección de envio</p>
				<input class="input registro" type=text  name="direccionRegistro" required></input>
				<p>Contraseña</p>
				<input class="input registro" type=password name="contrasenaRegistro" required></input>
				<fieldset>
					<legend>Información de tarjeta</legend>
					Numero: <input class="input registro"  name='numeroTarjeta' type='text' tabindex='1' required>
					Fecha vencimiento: <input class="input registro"  name='fechaTarjeta' type='date' tabindex='2' required>
				</fieldset>
				<input type="hidden" name="CrearCuenta" value=1></input>
				<c:if test="${registro == 'incorrecto'}">
						<p class=mensajeError > Ya existe una cuenta vinculada a ese email</p>
				</c:if>
				<input class=botonLogin type=submit value="Crea tu cuenta de Amazon Music"></input>
			</div>
		</form>
	</center>
    </body>
	<footer>
		<hr>
		<img src="./img/politica.PNG"/>
	</footer>
</html>