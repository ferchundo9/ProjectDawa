package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import businessLogic.*;

public class Controlador extends HttpServlet{
 private HttpServletRequest request;
 private HttpServletResponse response;
 public void init(ServletConfig config) throws ServletException{
    super.init(config);
    }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      this.request = request;
      this.response = response;

      if(request.getParameter("VerCatalogo") != null){
         this.VerCatalogo();
      }
      if(request.getParameter("VerProducto") != null){
         this.VerProducto();
      }
      if(request.getParameter("VerProductoAdmin") != null){
         this.VerProductoAdmin();
      }
      if(request.getParameter("VolverHome") != null){
         this.VolverHome();
      }
      if(request.getParameter("FiltrarProductos") != null){
         this.FiltrarProductos();
      }
      if(request.getParameter("VerCarrito") != null){
         this.VerCarrito();
      }
      if(request.getParameter("AnadirAlCarrito") != null){
         this.AnadirAlCarrito();
      }
      if(request.getParameter("ConfirmarCompra") != null){
         this.ConfirmarCompra();
      }
      if(request.getParameter("EliminarDelCarrito") != null){
         this.EliminarDelCarrito();
      }
      if(request.getParameter("goIniciarSesion") != null){
         this.goIniciarSesion();
      }
      if(request.getParameter("IniciarSesion") != null){
         this.IniciarSesion();
      }
      if(request.getParameter("Registrarse") != null){
         this.Registrarse();
      }
      if(request.getParameter("CrearCuenta") != null){
         this.CrearCuenta();
      }
      if(request.getParameter("CerrarSesion") != null){
         this.CerrarSesion();
      }
      if(request.getParameter("IntroducirProducto") != null){
         this.IntroducirProducto();
      }
      if(request.getParameter("ComprarYa") != null){
         this.ComprarYa();
      }
      if(request.getParameter("MostrarUsuarios") != null){
         this.MostrarUsuarios();
      }
      if(request.getParameter("EliminarUsuario") != null){
         this.EliminarUsuario();
      }
      if(request.getParameter("ActualizarContrasena") != null){
         this.ActualizarContrasena();
      }
      if(request.getParameter("AnadirProducto") != null){
         this.AnadirProducto();
      }
      if(request.getParameter("AnadirComentario") != null){
         this.AnadirComentario();
      }
      if(request.getParameter("FiltrarAdmin") != null){
         this.VerCatalogoAdmin();
      }
      if(request.getParameter("EliminarProducto") != null){
         this.EliminarProducto();
      }
      if(request.getParameter("actualizarUsuario") != null){
         this.actualizarUsuario();
      }
      if(request.getParameter("borrarUsuario") != null){
         this.borrarUsuario();
      }
      if(request.getParameter("actualizarAdmin") != null){
         this.actualizarAdmin();
      }
      if(request.getParameter("borrarAdmin") != null){
         this.borrarAdmin();
      }
      if(request.getParameter("insertarAdmin") != null){
         this.insertarAdmin();
      }
      if(request.getParameter("AnadirStock") != null){
         this.AnadirStock();
      }
     }
     //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
     
     //----------------------------------------------------------------------------------------//
     //--------------------METODOS DE GESTION DE REDIRECCION DIRECTA- -------------------------//
     //----------------------------------------------------------------------------------------//
     
     //Este metodo redirige directamente al index (para cuando el usuario clica en el icono de amazon)
     public void VolverHome(){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("index.html");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }
     //Este metodo redirige directamente a la vista para iniciar sesion (no hace falta envio de ningun dato)
     public void goIniciarSesion(){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }
     //idem para el registro (no hace falta enviarle ningun dato)
     public void Registrarse(){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("registro.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }
     //lleva directamente a la vista que permite a un administrador añadir un producto a la tienda
     public void AnadirProducto(){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("anadirProducto.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }
     //----------------------------------------------------------------------------------------//

     //----------------------------------------------------------------------------------------//
     //-----------------------METODOS DE GESTION DE PRODUCTOS----------------------------------//
     //----------------------------------------------------------------------------------------//
     /*Este metodo devuelve todos los items (cds) del catalogo sin filtrar*/
     public void VerCatalogo(){
         HelperProductos hp = new HelperProductos(request,response);
         hp.VerCatalogo();
     }
     /*Este metodo devuelve la informacion de un producto (cuando el usuario clica en el
     desde el catalogo) en el atributo "producto" y tiene que devolver tambien un array
     list con las opiniones asociadas al mismo*/
     public void VerProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerProducto("cliente");
     }
     /*Este metodo devuelve un hashmap de productos filtrados de una busqueda de usuario
     los atributos que recibe del formulario son "nombreCD","autorCD","precioMaxCD",
     "anoCD" y pueden ser nulos*/
     public void FiltrarProductos(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.FiltrarProductos("cliente");    
     }
     /*Este metodo aï¿½ade un comentario y valoracion a un item; comprueba que el usuario
     haya comprado ese item. Actualiza la valoracion media del item.
     Devuelve un atributo "comentario" que puede tener valor "correcto" si se aï¿½adio bien
     o "incorrecto" si el usuario no habia comprado ese producto*/
     public void AnadirComentario(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.AnadirComentario();
     }
     //----------------------------------------------------------------------------------------//


     //----------------------------------------------------------------------------------------//
     //-------------------------METODOS DE GESTION DE USUARIOS---------------------------------//
     //----------------------------------------------------------------------------------------//
     
     /*Metodo para comprobar email y contraseï¿½a de un usuario devuelve un atributo de
     nombre "login" que puede tener de valor  "incorrecto" si el login se ha hecho con
     exito o no.
     Si se ha logueado correctamente crea una sesion con un atributo de sesion con nombre
     "usuarioSesion"*/
     public void IniciarSesion(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.IniciarSesion();
     }
     /*Metodo para eliminar la sesion actual que se creo cuando el usuario se logueo*/
     public void CerrarSesion(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.CerrarSesion();
     }
     /*Metodo que inserta los datos del usuario en la BD. Comprueba que el email no este ya
     registrado y redirige al catalogo si crea la cuenta con exito (con la sesion ya iniciada)
     o vuelve al registro si no se pudo registrar.
     Entradas: "nombreRegistro","emailRegistro","direccionRegistro","numeroTarjeta","fechaTarjeta"
     Salidas: "registro" que puede ser "correcto" o "incorrecto" si se ha creado bien la cuenta.*/
     public void CrearCuenta(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.CrearCuenta();
     }
     //----------------------------------------------------------------------------------//


     //---------------------------------------------------------------------------------//
     //--------------------METODOS DE GESTION DEL CARRITO-------------------------------//
     //---------------------------------------------------------------------------------//
     /*Metodo que aï¿½ade el item seleccionado al carrito del usuario; tiene que comprobar
     si el usuario ha iniciado sesion; si lo ha hecho aï¿½ade el item al carrito y lo
     redirige al catalogo; aï¿½ade un atributo "itemAnadido" con valor "correcto" o "incorrecto"
     para mostrar un mensaje al usuario.*/
     public void AnadirAlCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.AnadirAlCarrito();
     }
     public void VerCarrito(){ //Muestra el carrito del cliente
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.ComprobarUsuarioVip();
     }
     public void EliminarDelCarrito(){ //Elimina un producto almacenado en carrito
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.EliminarDelCarrito();
     }
     public void ConfirmarCompra(){ //Realiza el pago de los productos del carrito y muestra la factura
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.ConfirmarCompra();
     }
     public void ComprarYa(){ //Envia directamente a la factura
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.ComprarYa();
     }
     //---------------------------------------------------------------------------------------//
     
     //---------------------------------------------------------------------------------------//
     //-----------------------------METODOS DEL ADMINISTRADOR---------------------------------//
     //---------------------------------------------------------------------------------------//

     public void IntroducirProducto(){ //Permite añadir un producto a la base de datos
         HelperProductos hp = new HelperProductos(request, response);
         hp.IntroducirProducto();
         VerCatalogoAdmin();
     }
     public void EliminarProducto(){ //Elimina un producto de la base de datos
         HelperProductos hp = new HelperProductos(request, response);
         hp.EliminarProducto();
         VerCatalogoAdmin();
     }
     public void MostrarUsuarios(){ //Realiza una consula y muestra los usuarios de la aplicacion (clientes y admins)
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.MostrarUsuarios();
     }
     public void EliminarUsuario(){ //Elimina a un cliente de la aplicacion
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.EliminarUsuario();
     }
     public void ActualizarContrasena(){ //Modifica los datos de la contraseá del cliente
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.ActualizarContrasena();
     }
     public void VerProductoAdmin(){ //Abre la ventaja de productos del administrador
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerProducto("admin");
     }
     public void VerCatalogoAdmin(){ //Muestra el catalogo desde el punto de vista de un administrador
         HelperProductos hp = new HelperProductos(request, response);
         hp.FiltrarProductos("admin");
     }
     public void actualizarUsuario(){ //Actualiza los datos almacenados en la BD del cliente
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.actualizarUsuario();
         this.MostrarUsuarios();
     }
     public void borrarUsuario(){ //Similar a Eliminar Usuario, y posteriormente mostrar los restantes
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.borrarUsuario();
         this.MostrarUsuarios();
     }
     public void actualizarAdmin(){ //Actualiza los datos de algun admin
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.actualizarAdmin();
         this.MostrarUsuarios();
     }
     public void borrarAdmin(){ //Permite borrar administradores de la base de datos
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.borrarAdmin();
     }
     public void insertarAdmin(){ //Permite introducir un administrador en la base de datos
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.insertarAdmin();
         this.MostrarUsuarios();
     }

     public void AnadirStock(){
         HelperProductos hp = new HelperProductos(request,response);
         hp.AnadirStock();
     }





 }
