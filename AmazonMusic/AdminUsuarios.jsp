  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Catalogo]</title>
		
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estiloAdmin.css" >
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
						<input type="hidden" name="FiltrarAdmin" value=1></input>
						<button class="botonInvisible derecha" ><span>Gestionar productos</span></button>
					</form>
					<form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" name="CerrarSesion" value=1></input>
						<button class="botonInvisible derecha" ><span>Cerrar Sesion</span></button>
					</form>
				</c:if>
				<!-- ..................................... -->
				
			</nav>
		</header>
	<!--....................................................................-->

	<!-------------------------   CUERPO -------------------------------------->
	<h1 class="tituloTabla">Clientes</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nombre</th>
				<th scope="col">Email</th>
				<th scope="col">Contraseña</th>
				<th scope="col">Dirección</th>
				<th scope="col">Nºtarjeta</th>
				<th scope="col">Fecha tarjeta</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="indice" value="${1}"/>
			<c:forEach items="${usuarios}" var="entry">
				<tr>
					<th scope="row">${indice}</th>
					<form class=form method="POST" action="Controlador" class="Controlador">
						<div class="form-group">
							<input type="hidden" value=1 name="actualizarUsuario">
							<input type="hidden" value=${entry.value.email} name="oldEmail">
							<td><input type="text" value=${entry.value.nombre} name="nombreCliente"> </td>
							<td><input type="email" value=${entry.value.email} name="emailCliente"></td>
							<td><input type="password" name="contrasenaCliente"></td>
							<td><input type="text" value=${entry.value.direccion} name="direccionCliente"></td>
							<td><input type="numeric" value=${entry.value.tarjeta.numero} name="numeroCliente"></td>
							<td><input type="date" value=${entry.value.tarjeta.vencimiento} name="vencimientoCliente"></td>
							<td><button type="submit" class="btn btn-default">Actualizar</button></td>
						</div>
					</form>
					<form class=form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" value=1 name="borrarUsuario">
						<input type="hidden" value=${entry.value.email} name="correoUsuario">
						<td><button type="submit" class="btn btn-default">Borrar</button></td>
					</form>
				</tr>
				<c:set var="indice" value="${indice+1}"/>
			</c:forEach>
		</tbody>
	</table>
	<h1 class="tituloTabla">Administradores</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nombre</th>
				<th scope="col">Email</th>
				<th scope="col">Contraseña</th>
				<th scope="col">Dirección</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="indice2" value="${1}"/>
			<c:forEach items="${admins}" var="entry2">
				<tr>
					<th scope="row">${indice2}</th>
					<form class=form method="POST" action="Controlador" class="Controlador">
						<div class="form-group">
							<input type="hidden" value=1 name="actualizarAdmin">
							<input type="hidden" value=${entry2.value.email} name="oldEmailAdmin">
							<td><input type="text" value=${entry2.value.nombre} name="nombreAdmin"> </td>
							<td><input type="email" value=${entry2.value.email} name="emailAdmin"></td>
							<td><input type="password" name="contrasenaAdmin"></td>
							<td><input type="text" value=${entry2.value.direccion} name="direccionAdmin"></td>
							<td><button type="submit" class="btn btn-default">Actualizar</button></td>
						</div>
					</form>
					<form class=form method="POST" action="Controlador" class="Controlador">
						<input type="hidden" value=1 name="borrarAdmin">
						<input type="hidden" value=${entry2.value.email} name="correoAdmin">
						<td><button type="submit" class="btn btn-default">Borrar</button></td>
					</form>
				</tr>
				<c:set var="indice2" value="${indice2+1}"/>
			</c:forEach>
				<tr>
					<th scope="row">Nuevo</th>
					<form class=form method="POST" action="Controlador" class="Controlador">
						<div class="form-group">
							<input type="hidden" value=1 name="insertarAdmin">
							<td><input type="text"  name="nombreAdmin"> </td>
							<td><input type="email"  name="emailAdmin"></td>
							<td><input type="password" name="contrasenaAdmin"></td>
							<td><input type="text"  name="direccionAdmin"></td>
							<td><button type="submit" class="btn btn-default">Añadir</button></td>
						</div>
					</form>
					
				</tr>
		</tbody>
	</table>
    </body>
</html>