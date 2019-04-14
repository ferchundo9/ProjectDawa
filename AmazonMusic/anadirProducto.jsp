  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Item]</title>
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estilo.css" >
		<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">
		<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/gh/igorlino/elevatezoom-plus@1.2.3/src/jquery.ez-plus.js"></script>
		<script type="text/javascript">
			$(document).ready(function()   {
				$("#boton").on( "click", function() {	 
					$('#target').toggle("swing");
					});
			});
		</script>
	
		<!--- PLUGUIN PARA EL ZOOOM DE LA IMAGEN ---->
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/elevatezoom/3.0.8/jquery.elevatezoom.min.js"></script>
		<script>
		$(function(){  
			  $("#zoom").elevateZoom({
				
				scrollZoom: true,
				lensShape: "square",
				tint: true,
				tintColour: '#F90', tintOpacity: 0.2,
				 zoomWindowFadeIn: 500,
				zoomWindowFadeOut: 500,
				lensFadeIn: 500,
				lensFadeOut: 500,
				zoomWindowWidth: 680,
				zoomWindowHeight: 500
		  });
		});
		
		</script>
		<!---------------------------------------------->

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
	
    <body>
	<!-- Gif que se muestra mientras carga la pagina -->
	<script type="text/javascript">$(window).load(function() {$(".loader").fadeOut("slow");});</script>
	<div class="loader"></div>
	<!-- ---------------------   ENCABEZADO  ------------------------------ -->
		<header>
			<!-- Barra superior de navegacion -->
			<nav>
				<!-- logo de amazon que redirige al index -->
				<form method="POST" action="Controlador" class="Controlador">
					<input type="hidden" name="VolverHome" value=1></input>
					<button class=botonInvisible ><img src="./img/logoBlanco.png" /></button>
				</form>
				<!-- ..................................... -->
				
				<!-- SI EL USUARIO NO SE HA LOGUEADO -->
				<c:if test="${empty sessionScope.usuarioSesion}">
					 <!-- iniciar sesion que redirige a login.html -->
					<form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" name="goIniciarSesion" value=1></input>
						<button class="botonInvisible derecha" ><span>Iniciar Sesion</span></button>
					</form>
					<!-- ..................................... -->
					<form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" name="Registrarse" value=1></input>
						<button class="botonInvisible derecha" ><span>Registrarse</span></button>
					</form>
					<!-- ..................................... -->
				</c:if> 
				<!-- SI EL USUARIO YA INICIO SESION -->
				<c:if test="${not empty sessionScope.usuarioSesion}">
					<form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" name="AdminUsuarios" value=1></input>
						<button class="botonInvisible derecha" ><span>Administrar Usuarios</span></button>
					</form>
					<form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" name="CerrarSesion" value=1></input>
						<button class="botonInvisible derecha" ><span>Cerrar Sesion</span></button>
					</form>
				</c:if>
				<!-- ..................................... -->
				
				<!-- Formuario para filtrar productos del catalogo -->
				<form class=form method="POST" action="Controlador" class="Controlador">
					<div id=boton class=opcionesBusqueda><img src="./img/iconoDesplegar.png" />Opciones busqueda </div>
					<input class="barraBusqueda" type="text" name="nombreCD">
					<input type="hidden" name="FiltrarProductosAdmin" value=1></input>
					<button type="submit"> <img src="./img/iconoBuscar.png" /> </button>
					<div id=target class=otrasOpciones>
						<label><p>Precio Máximo</p><input type="number" name="precioMaxCD"></label>
						<label><p>Autor</p><input type="text" name="autorCD"></label>
						<label><p>Año</p><input type="number" name="anoCD"></label>
					</div>
				</form>
				<!-- ............................................... -->
				
			</nav>
		</header>
	<!-- ------------------------------------------------------------------ -->

	<!-------------------------   CUERPO -------------------------------------->
	<div class=itemGrid> <!--Div con el fondo blanco-->
		<form method="POST" action="Controlador" class="Controlador">
			<input type="hidden" name="IntroducirProducto" value=1 />
			<label><p>Titulo</p><input type="text" name="tituloCdNuevo"></label>
			<label><p>Autor</p><input type="text" name="autorCdNuevo"></label>
			<label><p>Precio</p><input type="number" step="0.01" name="precioCdNuevo"></label>
			<label><p>Año</p><input type="number" name="anoCdNuevo"></label>
			<label><p>Imagen</p><input type="text" name="imagenCdNuevo"></label>
			<label><p>Stock</p><input type="number" name="stockCdNuevo"></label>
			<input type="submit" value="Añadir Cd"/>
		</form>
	</div>
	
	
    </body>
</html>