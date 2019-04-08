  <html>
	<!-- ---------------------   METADATOS  ------------------------------ -->
    <head>
		<title>AmazonMusic[Catalogo]</title>
		<meta charset="utf-8"> 
		<meta name="description" content="Página de venta de productos">
		<meta name="keywords" content="CD, musica, comprar, tienda">
		<meta name="author" content="Raquel Vilas, Fernando Rodríguez, Miguel Martinez, Carlos Rial">
		<link type="text/css" rel="stylesheet" href="./estilo.css" >
    </head>
	<!-- ------------------------------------------------------------------ -->
	
	
    <body>
	<!-- ---------------------   ENCABEZADO  ------------------------------ -->
		<header>
			<img class=logo src="img/logoBlanco.png" />
		</header>
	<!-- ------------------------------------------------------------------ -->

	<!-------------------------   CUERPO -------------------------------------->
	<center>
		<div>
			<p> Bienvenido al mayor portal de venta de CDs online </p>
			<form  method="POST" action="Controlador" class="Controlador" >
				<input type="hidden" name="verCatalogo" value="1"><!-- campo hiden para que el controlador vea el atributo verCatalogo != null !-->
				<input class=boton type="submit" value="Ver catalogo">
			</form>
		</div>
	</center>
     
    </body>
</html>