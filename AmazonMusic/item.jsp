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
				
				 <!-- iniciar sesion que redirige a login.html -->
				<form method="POST" action="Controlador" class="Controlador">
					<input type="hidden" name="IniciarSesion" value=1></input>
					<button class="botonInvisible derecha" ><span>Iniciar Sesion</span></button>
				</form>
				<!-- ..................................... -->
				<form method="POST" action="Controlador" class="Controlador">
					<input type="hidden" name="Registrarse" value=1></input>
					<button class="botonInvisible derecha" ><span>Registrarse</span></button>
				</form>
				<!-- ..................................... -->
				
				<form class=form method="POST" action="Controlador" class="Controlador">
					<div id=boton class=opcionesBusqueda><img src="./img/iconoDesplegar.png" />Opciones busqueda </div>
					<input type="text" name="nombreCD">
					
					<button type="submit"> <img src="./img/iconoBuscar.png" /> </button>
					<div id=target class=otrasOpciones>
						<label><p>Precio Máximo</p><input type="number" name="precioMax"></label>
						<label><p>Autor</p><input type="text" name="autorCD"></label>
						<label><p>Año</p><input type="number" name="añoCD"></label>
					</div>
				</form>
			</nav>
		</header>
	<!-- ------------------------------------------------------------------ -->

	<!-------------------------   CUERPO -------------------------------------->
	<div class=itemGrid> <!--Div con el fondo blanco-->
		
			<!-- info del item en si -->
			<div class=columna1>
			
				<img class=imagenItemUd id="zoom" src="./img/cd1.jpg">
				<p class=tituloItem> ${producto.titulo} </p>
				<p>
					<img class=estrellaItem src="./img/iconoEstrellaCompleta.png" />
					<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
					<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
					<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
					<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
				</p>
				<p class=autorItem > de ${producto.autor} (${producto.ano})</p>
				<p class=etiquetaPrecio>Precio: <span class=precioItem> EUR ${producto.precio}€ </span></p> 
			</div>	
			<!--------------------------->
			<!-- cuadro de la derecha para añadir al carrito --------->
			<form method="POST" action="Controlador" class="Controlador">
				<div class=cuadroCompra >
					<!-- Aqui poner campos ocultos con los datos del cd para el formulario jeje -->
					<p class=precioItem> EUR ${producto.precio}€ </p>
					<img class=imagenEnvio src="./img/imagenEnvio.PNG" />
					<p class=enStock> En Stock </p>
					<label> Cantidad : <input class=cantidad type=number /></label>
					<button type="submit" class=botonAnadir> <img src="./img/iconoCarrito.png" /> Añadir a la cesta</button>
					<button type="submit" class="botonAnadir botonComprar"> <img src="./img/iconoComprar.png" /> Comprar ya</button>
				</div>
			</form>
			<!-------------------------->
			<p class=notaZoom > Pasa el ratón por encima de la imagen para ampliarla </p>
			
			
			<!---- SECCION DE COMENTARIOS Y VALORACIONES -------------->
			<div class=comentarios>
				<hr/>
				<h2> Opiniones de clientes</h2>
				<!----- Comentario Individual -------->
				<div class=opinion>
					
					<p > <img src="./img/iconoUsuario.png" /> <span class=usuario> Raquel Vilas </span></p>
					<p>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png" />
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
					</p>
					<p class=texto> Muy buen CD llego a tiempo jjejejejeje super contenta flipas y todo genial por aca queen lo mejor pero daddyyanke tambn esta guai que flipas </p>
				</div>
				
				<div class=opinion>
					
					<p > <img src="./img/iconoUsuario.png" /> <span class=usuario> Carlitos </span></p>
					<p>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png" />
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
						<img class=estrellaItem src="./img/iconoEstrellaCompleta.png"/>
					</p>
					<p class=texto> kva vaya miedrjahGshajgakjhwgedjhgqwhejdbjasbvhkgqewgfdmbjs,hkwjgewvdbnsahvebdnshvfnbac dsnvn </p>
				</div>
			</div>
	</div>
	
	
	
     
    </body>
</html>