  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Catalogo]</title>
		
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
		<script>
		$(document).ready(function(){
            /* Si se pulsa sobre el div "button" */
            $("#botonNotificacion").click(function(){
                $("#notificacionFondo").hide();
            });
        });
		</script>
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
	<!--....................................................................-->

	<!-------------------------   CUERPO -------------------------------------->
	<center class=items>
		<!-- Bucle que recorre el hash de elementos del catalgo --->
		<c:forEach items="${catalogo}" var="entry">
			<div class=item>
				<form method="POST" action="Controlador" class="Controlador">
					<img class=imagenItem src=./img/${entry.value.urlImagen}>
					<p class=titulo> ${entry.value.titulo} </p>
					<p class=autor> de ${entry.value.autor}(${entry.value.ano})</p>
					<!-- Valoracion del item -->
					<c:forEach begin="0" end="${entry.value.valoracion - 1}" var="i">
						<img class=estrella src="img/iconoEstrellaCompleta.png" />
					</c:forEach>
					<c:forEach begin="1" end="${5 - entry.value.valoracion}" var="i">
						<img class=estrella src="img/iconoEstrellaVacia.png" />
					</c:forEach>
					<p class=precio> ${entry.value.precio} € </p>
					<!-- Campos ocultos para enviar datos al servlet -->
					<input type="hidden" name="VerProducto" value=1></input>
					<input type="hidden" name="Referencia" value=${entry.value.referencia}></input>
					<!-- ............................................ -->
					
					<input type="submit" class=mas value="Ver CD"> </input>
				</form>
			</div>
		</c:forEach>
		<!-- ...................................................... -->
		<c:if test="${empty catalogo}">
			<p> No hemos encontrado ningún cd con esas características </p>
			<img src="./img/iconoTriste.png">
		</c:if>
	</center>
     
	<c:if test="${not empty itemAnadido && itemAnadido=='correcto'}">
		<div id=notificacionFondo class=notificacionFondo>
			<div class=cuadroNotificacion>
				<img src="./img/iconoExito.png">
				<p> El item se ha añadido con éxito al carrito </p>
				<button id="botonNotificacion"> Aceptar </button>
			</div>
		</div>
	</c:if>
    </body>
</html>