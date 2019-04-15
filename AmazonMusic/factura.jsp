  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Factura]</title>
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

				<form method="POST" action="Controlador" class="logoResponsive">
					<input type="hidden" name="VolverHome" value=1></input>
					<button class=botonInvisible ><img src="./img/logoBlanco.png" /></button>
				</form>
				<!-- ..................................... -->
				
				<!-- SI EL USUARIO NO SE HA LOGUEADO -->
				<c:if test="${empty sessionScope.usuarioSesion}">
					 <!-- iniciar sesion que redirige a login.html -->
					<form method="POST" action="Controlador" class="logoResponsive2">
						<input type="hidden" name="goIniciarSesion" value=1></input>
						<button class="botonInvisible derecha" ><span>Iniciar Sesion</span></button>
					</form>
					<!-- ..................................... -->
					<form method="POST" action="Controlador" class="logoResponsive2">
						<input type="hidden" name="Registrarse" value=1></input>
						<button class="botonInvisible derecha" ><span>Registrarse</span></button>
					</form>
					<!-- ..................................... -->
				</c:if> 
				<!-- SI EL USUARIO YA INICIO SESION -->
				<c:if test="${not empty sessionScope.usuarioSesion}">
					<c:if test="${sessionScope.tipoUsuario == 'VIP'}">
						<img class="vip derecha" src="./img/iconoVIP.png">
					</c:if>
					<form method="POST" action="Controlador" class="logoResponsive2">
						<input type="hidden" name="VerCarrito" value=1></input>
						<button class="botonInvisible derecha" ><span>Ver Carrito</span></button>
					</form>
					<form method="POST" action="Controlador" class="logoResponsive2">
						<input type="hidden" name="CerrarSesion" value=1></input>
						<button class="botonInvisible derecha" ><span>Cerrar Sesion</span></button>
					</form>
				</c:if>
				<!-- ..................................... -->
				
				<!-- Formuario para filtrar productos del catalogo -->
				<div class=barraBlock>
					<form  method="POST" action="Controlador" class="form barraBusquedaResponsive ">
						<div id=boton class=opcionesBusqueda><img src="./img/iconoDesplegar.png" />Opciones busqueda </div>
						<input class="barraBusqueda" type="text" name="nombreCD">
						<input type="hidden" name="FiltrarProductos" value=1></input>
						<button type="submit"> <img src="./img/iconoBuscar.png" /> </button>
						<div id=target class=otrasOpciones>
							<label><p>Precio Máximo</p><input type="number" name="precioMaxCD" min=0 max=999></label>
							<label><p>Autor</p><input type="text" name="autorCD"></label>
							<label><p>Año</p><input type="number" name="anoCD" min=1900 max=2020></label>
						</div>
					</form>
				</div>
				<!-- ............................................... -->
				
			</nav>
		</header>
	<!--....................................................................-->
	<!-------------------------   CUERPO -------------------------------------->
	<center class=fondoBlanco>
		<div class=block>
			<h2 class=tituloFactura> Gracias, has realizado tu pedido</h2>
			<div class=cuadroFactura>
				<div class=cabeceraFactura>
					<div class=ancho><p style="color:#4A4A4A;">PEDIDO REALIZADO</p><p>${fecha}</p></div>
					<div class=ancho><p style="color:#4A4A4A;">TOTAL</p><p>EUR ${factura.precio}</p></div>
					<div class=ancho><p style="color:#4A4A4A;">FACTURA ENVIADA A</p><p>${sessionScope.usuarioSesion}</p></div>
				</div>
					<!----------- ITEM INDIVIDUAL DEL  CARRITO ---------->
				<div class=block>
					<div class=listaProductos>
						<p> Detalles del pedido </p>
						<c:forEach items="${factura.items}" var="entry">
							<form class=tablaCarrito method="POST" action="Controlador" class="Controlador">
								<hr class=lineaFactura>
								<img class="c1 imagenCarrito" src="./img/${entry.value.item.urlImagen}">
								<p class="c2 tituloCarrito"> ${entry.value.item.titulo} </p>
								<p class="c3 cantidad" >x${entry.value.cantidad}uds </p>
								<p class="c4 precio"> EUR ${entry.value.item.precio} </p>
								<input type=hidden name=Referencia value=${entry.value.item.referencia}>
							</form>
						</c:forEach>
					</div>
					<div class=derechaFactura>
						<p class=c1>Total pedido:</p><p class=c2> ${factura.precio}</p>
						<p class=c1>Descuento aplicado: </p><p class=c2> 0%</p>
						<p class=c1>Precio final: </p><p class=c2> ${factura.precio}</p>
					</div>
				</div>
			</div>
		</div>
	</center>
     
    </body>
</html>