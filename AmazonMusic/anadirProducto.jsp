  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Item]</title>
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estiloAdmin.css" >
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
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
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
						<input type="hidden" name="MostrarUsuarios" value=1></input>
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
					<input type="hidden" name="FiltrarAdmin" value=1></input>
					<button type="submit"> <img src="./img/iconoBuscar.png" /> </button>
					<div id=target class=otrasOpciones>
						<label><p>Precio Máximo</p><input type="number" name="precioMaxCD" min=0 max=999></label>
						<label><p>Autor</p><input type="text" name="autorCD"></label>
						<label><p>Año</p><input type="number" name="anoCD" min=1900 max=2020></label>
					</div>
				</form>
				<!-- ............................................... -->
				
			</nav>
		</header>
	<!-- ------------------------------------------------------------------ -->

	<!-------------------------   CUERPO -------------------------------------->
	<div class=itemGrid ng-app="" ng-init="modelTitulo=''" > <!--Div con el fondo blanco-->
		
			<!-- info del item en si -->
			<div class=columna1>
			
				<img class=imagenItemUd id="zoom" ng-src="{{modelImagen}}">
				<p class=tituloItem ng-bind="modelTitulo"> </p>
				<c:forEach begin="0" end="4" var="i">
						<img class=estrellaItem src="img/iconoEstrellaVacia.png" />
				</c:forEach>
				<p class=autorItem > de {{modelAutor}} ({{modelAno}})</pre></p>
				<p class=etiquetaPrecio>Precio: <span class=precioItem> EUR {{modelPrecio}}€</span></p> 
				<p class=StockItem> Stock disponible: {{modelStock}}</span> uds</p>
			</div>	
			<!--------------------------->
			<!-- cuadro de la derecha para añadir al carrito --------->
				<div class=cuadroCompra>
					<p class=etiquetaPrecio>Precio: <span class=precioItem> EUR {{modelPrecio}}€</span></p>
					<img class=imagenEnvio src="./img/imagenEnvio.PNG" />
					<p class=enStock> En Stock </p>
					<!-- Formulario para añadir al carrito  -->
					<form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" name="IntroducirProducto" value=1 />
						<label><p style="text-align: right;">Titulo: <input type="text" name="tituloCdNuevo" ng-model="modelTitulo" required></label> </p>
						<label><p style="text-align: right;">Autor: <input type="text" name="autorCdNuevo" ng-model="modelAutor" required></label> </p>
						<label><p style="text-align: right;">Precio: <input type="number" step="0.01" name="precioCdNuevo min=0 max=999" ng-model="modelPrecio" required></label> </p>
						<label><p style="text-align: right;">Año: <input type="number" name="anoCdNuevo" ng-model="modelAno" min=1900 max=2020 required></label> </p>
						<label><p style="text-align: right;">Imagen: <input type="text" name="imagenCdNuevo" ng-model="modelImagen" required></label> </p>
						<label><p style="text-align: right;">Stock: <input type="number" name="stockCdNuevo min=1 max=999" ng-model="modelStock" required></label> </p>
						<button type="submit" class=botonAnadir> Introducir CD</button>
					</form>
				</div>
	</div>
	
	
    </body>
</html>