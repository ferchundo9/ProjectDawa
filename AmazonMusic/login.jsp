 <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[login]</title>
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estilo.css" >
		<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">
		<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		
    </head>
	<!-- .................................................................. -->

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
		<div class=iniciarSesion>
			<h2>Iniciar sesión</h2>
			<form method="POST" action="Controlador" class="Controlador">
				<p>Dirección de e-mail o número de teléfono móvil </p>
				<input class=input  type=email name="emailLogin" ></input>
				<p>Contraseña</p>
				<input class=input type=password name="passwordLogin" ></input>
				<input type="hidden" name="IniciarSesion" value=1></input>
				<c:if test="${login == 'incorrecto'}">
					<p class=mensajeError > No existe ninguna cuenta con esos datos</p>
				</c:if>
				<input class=botonLogin type=submit value="Iniciar sesión"></input>
			</form>
			<p class=nuevo>¿Eres nuevo en Amazon Music?</p>
			<form method=POST action=Controlador class=Controlador>
				<input type="hidden" name="Registrarse" value=1></input>
				<input class=botonCrear type=submit value="Crea tu cuenta de AmazonMusic"</p>
			</form>
		</div>
	</center>
    </body>
	<footer>
		<hr>
		<img src="./img/politica.PNG"/>
	</footer>
</html>