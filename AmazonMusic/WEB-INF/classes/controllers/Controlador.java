package controllers;
import javax.servlet.*;
import javax.servlet.http.*;

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
      
      if(request.getParameter("IntroducirProducto") != null){
         this.IntroducirProducto();
      }
      if(request.getParameter("ActualizarInventario") != null){
         this.ActualizarInventario();
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
            RequestDispatcher  vista = request.getRequestDispatcher("registro.html");
            vista.forward(request,response);
         }catch(Exception e){
         }  
     }
     //.....................................................................................................//
     
     
     //--------------------------------------------------------------------------------//
     //-----------------METODOS DE GESTION DE PRODUCTOS -------------------------------//
     /*Este m�todo devuelve todos los items (cds) del catalogo sin filtrar*/
     public void VerCatalogo(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerCatalogo();
     }
     /*Este m�todo devuelve la informacion de un producto (cuando el usuario clica en el 
     desde el catalogo) en el atributo "producto" y tiene que devolver tambien un array
     list con las opiniones asociadas al mismo (FALTA POR IMPLEMENTAR OPINIONES)*/
     public void VerProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerProducto();
     }
     /*Este metodo devuelve un hashmap de productos filtrados de una busqueda de usuario
     los atributos que recibe del formulario son "nombreCD","autorCD","precioMaxCD", 
     "anoCD" y pueden ser nulos*/
     public void FiltrarProductos(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.FiltrarProductos();
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
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.IniciarSesion();
     }
     
     //..................................................................................//
     
     public void VerCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.VerCarrito();
     }
     public void AdministrarTienda(){
         //LLEVA A LA VISTA DE ADMINISTRADOR
     }
     public void AnadirAlCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.AnadirAlCarrito();
     }
     public void ConfirmarCompra(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.ConfirmarCompra();
     }
     public void EliminarDelCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response);
         hc.EliminarDelCarrito();
     }
     public void ConfirmarRegistro(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.ConfirmarRegistro();
     }
     
     public void IntroducirProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.IntroducirProducto();
     }
     public void ActualizarInventario(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.ActualizarInventario();
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
     


 }
