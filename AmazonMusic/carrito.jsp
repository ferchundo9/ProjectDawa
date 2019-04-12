  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Carrito]</title>
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estilo.css" >
		<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">
		<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function()   {
				$("#boton").on( "click", function() {	 
					$('#target').toggle("swing");
					});
			});
		</script>
    </head>
	<!-- ------------------------------------------------------------------ -->
	

	<!-- ---------------------   ENCABEZADO  ------------------------------ -->
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
						<input type="hidden" name="Registrarse" value=1></input>
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
	<!--....................................................................-->
	<!-------------------------   CUERPO -------------------------------------->
	<center class=fondoBlanco>
		<div class=block>
			<div class=tabla5Columnas >
					<h2 class="c1"> Carrito </h2>
			</div>
			<div class=cuadroDerecha>
				<h2> Subtotal ( ${sessionScope.carrito.numItems} productos): </h2>
				<p class=precio>   EUR ${sessionScope.carrito.precio} </p>
				<input type=hidden name=ConfirmarCompra value=1></input>
				<input class=botonLogin type=submit value="Proceder a la compra"></input>
			</div>
				<!----------- ITEM INDIVIDUAL DEL  CARRITO ---------->
			<c:forEach items="${sessionScope.carrito.items}" var="entry">
				<hr class=linea>
				<form class=tablaCarrito method="POST" action="Controlador" class="Controlador">
						<img class="c1 imagenCarrito" src="./img/${entry.value.item.urlImagen}">
						<p class="c2 tituloCarrito"> ${entry.value.item.titulo} </p>
						<p class="c3 cantidad" >x${entry.value.cantidad}uds </p>
						<p class="c4 precio"> EUR ${entry.value.item.precio} </p>
						<input type=hidden name=Referencia value=${entry.value.item.referencia}>
						<input type=hidden name=EliminarDelCarrito value=1></input>
						<button class=botonInvisible type=submit><img class="c5 botonEliminar" src="./img/iconoEliminar.png"/> </button>
				</form>
			</c:forEach>
			<c:if test="${empty sessionScope.carrito.items}">
			<div class=noComentarios>
				<hr class=linea>
				<img src="./img/iconoJake.png">
				<p> No tienes nada en el carrito </p>
			</div>
			</c:if>
			<c:if test="${not empty sessionScope.carrito.items}">
			<!-- Suma final de la compra -->
			<hr class=linea>
			<div class=tablaCarrito >
				<p class=derecha> Subtotal(${sessionScope.carrito.numItems} productos): <span class=precioDer> EUR ${sessionScope.carrito.precio} </span></p>
			</div>
			</c:if>
		</div>
	</center>
     
    </body>
</html>