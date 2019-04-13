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
	<!-- AngularJS-->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8.min.js"></script>
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
						<input type="hidden" name="VerCarrito" value=1></input>
						<button class="botonInvisible derecha" ><span>Ver Carrito</span></button>
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
					<input type="hidden" name="FiltrarProductos" value=1></input>
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
		
			<!-- info del item en si -->
			<div class=columna1>
			
				<img class=imagenItemUd id="zoom" src=./img/${producto.urlImagen}>
				<p class=tituloItem> ${producto.titulo} </p>
				<c:forEach begin="0" end="${producto.valoracion - 1}" var="i">
						<img class=estrellaItem src="img/iconoEstrellaCompleta.png" />
				</c:forEach>
				<c:forEach begin="${producto.valoracion}" end="4" var="i">
						<img class=estrellaItem src="img/iconoEstrellaVacia.png" />
				</c:forEach>
				<p class=autorItem > de ${producto.autor} (${producto.ano})</p>
				<p class=etiquetaPrecio>Precio: <span class=precioItem> EUR ${producto.precio}€ </span></p> 
				<p class=StockItem > Stock disponible: ${stock} uds</p>
			</div>	
			<!--------------------------->
			<!-- cuadro de la derecha para añadir al carrito --------->
				<div class=cuadroCompra ng-app="" ng-init="cantidadCompra=1">
					<p class=precioItem> EUR ${producto.precio}€ </p>
					<img class=imagenEnvio src="./img/imagenEnvio.PNG" />
					<p class=enStock> En Stock </p>
					<!-- Formulario para añadir al carrito  -->
					<form method="POST" action="Controlador" class="Controlador">
						<input type=hidden name=Referencia value=${producto.referencia}></input>
						<input type="hidden" name="AnadirAlCarrito" value=1></input>
						<label> Cantidad : <input ng-model="cantidadCompra" class=cantidad name=Cantidad type=number required min=1 max=${stock} value=1/></label>
						<button type="submit" class=botonAnadir> <img src="./img/iconoCarrito.png" /> Añadir a la cesta</button>
					</form>
					<!-- Formulario para añadir al carrito y ir al carrito directamente --->
					<form method="POST" action="Controlador" class="Controlador">
						<p ng-bind="cantidadCompra"></p>
						<input type="hidden" name=Cantidad type=number value=1>
						<input type="hidden" name="ComprarYa" value=1></input>
						<button type="submit" class="botonAnadir botonComprar"> <img src="./img/iconoComprar.png" /> Comprar ya</button>
					</form>
				</div>
			</form>
			<!-------------------------->
			<p class=notaZoom > Pasa el ratón por encima de la imagen para ampliarla </p>
			
			
			<!---- SECCION DE COMENTARIOS Y VALORACIONES -------------->
			<div class=comentarios>
				<hr/>
				<h2> Opiniones de clientes</h2>
				<!----- Comentario Individual -------->
				<c:forEach items="${valoraciones}" var="val">
					<div class=opinion>
					
						<p > <img src="./img/iconoUsuario.png" /> <span class=usuario> ${val.cliente} </span></p>
						<p>
							<c:forEach begin="0" end="${val.valoracion - 1}" var="i">
								<img class=estrellaItem src="img/iconoEstrellaCompleta.png" />
							</c:forEach>
							<c:forEach begin="${val.valoracion}" end="4" var="i">
								<img class=estrellaItem src="img/iconoEstrellaVacia.png" />
							</c:forEach>
						</p>
					<p class=texto> ${val.comentario}  </p>	
					</div>
				</c:forEach>
				
				<c:if test="${empty valoraciones}">
				<div class=noComentarios>
					<img src="./img/iconoCorazon.png">
					<p> Nadie ha valorado aun este producto </p>
				</div>
				</c:if>

			</div>
			</div>
	</div>
	
	
    </body>
</html>