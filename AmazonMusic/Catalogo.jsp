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
	<!--....................................................................-->

	<!-------------------------   CUERPO -------------------------------------->
	<center class=items>
		<!-- Bucle que recorre el hash de elementos del catalgo --->
		<c:forEach items="${catalogo}" var="entry">
			<div class=item>
				<form method="POST" action="Controlador" class="Controlador">
					<img class=imagenItem src="./img/cd1.jpg">
					<p class=titulo> ${entry.value.titulo} </p>
					<p class=autor> de ${entry.value.autor}(${entry.value.ano})</p>
					<!-- Falta asociar una valoracion al item -->
					<img class=estrella src="img/iconoEstrellaCompleta.png" />
					<img class=estrella src="./img/iconoEstrellaCompleta.png"/>
					<img class=estrella src="./img/iconoEstrellaCompleta.png"/>
					<img class=estrella src="./img/iconoEstrellaCompleta.png"/>
					<img class=estrella src="./img/iconoEstrellaCompleta.png"/>
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
	</center>
     
    </body>
</html>