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
      if(request.getParameter("VolverHome") != null){
         this.VolverHome();
      }
      if(request.getParameter("FiltrarProductos") != null){
         this.FiltrarProductos();
      }
      if(request.getParameter("VerCarrito") != null){
         this.VerCarrito();
      }
      if(request.getParameter("AdministrarTienda") != null){
         this.AdministrarTienda();
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
      if(request.getParameter("ConfirmarRegistro") != null){
         this.ConfirmarRegistro();
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

      
     }

     //-----------------------------------------------------------------------------------------------//
     //----------------METODOS DE REDIRECCION DIRECTA (no pasan por los helpers)----------------------//
     //Este m�todo redirige directamente al index (para cuando el usuario clica en el icono de amazon)
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

     public void AnadirProducto(){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("anadirProducto.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }

     //.....................................................................................................//


     //--------------------------------------------------------------------------------//
     //-----------------METODOS DE GESTION DE PRODUCTOS -------------------------------//
     /*Este m�todo devuelve todos los items (cds) del catalogo sin filtrar*/
     public void VerCatalogo(){
         HelperUsuarios hu = new HelperUsuarios(request,response);
         if(hu.AdminCliente().equals("admin")){
            VerCatalogoAdmin();
         }else{
            HelperProductos hp = new HelperProductos(request, response);
            hp.VerCatalogo();
         }
     }
     /*Este m�todo devuelve la informacion de un producto (cuando el usuario clica en el
     desde el catalogo) en el atributo "producto" y tiene que devolver tambien un array
     list con las opiniones asociadas al mismo*/
     public void VerProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerProducto();
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("item.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }


     /*Este metodo devuelve un hashmap de productos filtrados de una busqueda de usuario
     los atributos que recibe del formulario son "nombreCD","autorCD","precioMaxCD",
     "anoCD" y pueden ser nulos*/
     public void FiltrarProductos(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.FiltrarProductos();
         try{
         RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
         vista.forward(request,response);
         }catch(Exception e){
         }
     }
     /*Este metodo a�ade un comentario y valoracion a un item; comprueba que el usuario
     haya comprado ese item. Actualiza la valoracion media del item.
     Devuelve un atributo "comentario" que puede tener valor "correcto" si se a�adio bien
     o "incorrecto" si el usuario no habia comprado ese producto*/
     public void AnadirComentario(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.AnadirComentario();
     }

     //..................................................................................//


      //---------------------------------------------------------------------------------//
     //-----------------METODOS DE GESTION DE USUARIOS- ---------------------------------//
     /*Metodo para comprobar email y contrase�a de un usuario devuelve un atributo de
     nombre "login" que puede tener de valor  "incorrecto" si el login se ha hecho con
     exito o no.
     Si se ha logueado correctamente crea una sesion con un atributo de sesion con nombre
     "usuarioSesion"*/
     public void IniciarSesion(){
         String email=request.getParameter("emailLogin");
         String password=request.getParameter("passwordLogin");
         HelperUsuarios hu = new HelperUsuarios(request, response);
         try{
            if(hu.IniciarSesion(email,password).equals("cliente")){
                  RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
                  vista.forward(request,response);
            }else if(hu.IniciarSesion(email,password).equals("admin")){
               RequestDispatcher  vista = request.getRequestDispatcher("CatalogoAdmin.jsp");
               vista.forward(request,response);
            }else if(hu.IniciarSesion(email,password).equals("false")){
               RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
               vista.forward(request,response);
            }
         }catch(Exception e){}
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

     //..................................................................................//


     //---------------------------------------------------------------------------------//
     //-----------------METODOS DE GESTION DEL CARRITO- --------------------------------//
     /*Metodo que a�ade el item seleccionado al carrito del usuario; tiene que comprobar
     si el usuario ha iniciado sesion; si lo ha hecho a�ade el item al carrito y lo
     redirige al catalogo; a�ade un atributo "itemAnadido" con valor "correcto" o "incorrecto"
     para mostrar un mensaje al usuario.*/
     public void AnadirAlCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.AnadirAlCarrito();
     }
      public void VerCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.VerCarrito();
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }
     public void EliminarDelCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.EliminarDelCarrito();
     }
     public void ConfirmarCompra(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.ConfirmarCompra();
     }

     public void ComprarYa(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.ComprarYa();
     }
     //.................................................................................//

     public void AdministrarTienda(){
         //LLEVA A LA VISTA DE ADMINISTRADOR
     }

     public void ConfirmarRegistro(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.ConfirmarRegistro();
     }

     public void IntroducirProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.IntroducirProducto();
         VerCatalogoAdmin();
     }
     
     public void EliminarProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.EliminarProducto();
         VerCatalogoAdmin();
     }

     public void MostrarUsuarios(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.MostrarUsuarios();
     }
     public void EliminarUsuario(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.EliminarUsuario();
     }
     public void ActualizarContrasena(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.ActualizarContrasena();
     }

     public void VerProductoAdmin(){ //Abre la ventaja de productos del administrador
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerProducto();
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("itemAdmin.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
     }
     public void VerCatalogoAdmin(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.FiltrarProductos();
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("CatalogoAdmin.jsp");
            vista.forward(request,response);
         }catch(Exception e){
            
         }

     }




 }
