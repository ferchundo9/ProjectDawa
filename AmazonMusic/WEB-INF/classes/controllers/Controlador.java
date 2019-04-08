package controllers;
import javax.servlet.*;
import javax.servlet.http.*;

public class Controlador extends HttpServlet{
 private ServletContext context;
 public void init(ServletConfig config) throws ServletException{
    super.init(config);
    this.context = getServletContext();
    }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
      if(request.getParameter("VerCatalogo") != null){
         this.VerCatalogo();
      }
      if(request.getParameter("VerProducto") != null){
         this.VerProducto();
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
      if(request.getParameter("IniciarSesion") != null){
         this.IniciarSesion();
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
     public void VerCatalogo(){
         HelperProductos hp = new HelperProductos(request, response, context);
         hp.VerCatalogo();
     }
     public void VerProducto(){
         HelperProductos hp = new HelperProductos(request, response, context);
         hp.VerProducto();
     }
     public void FiltrarProductos(){
         HelperProductos hp = new HelperProductos(request, response, context);
         hp.FiltrarProductos();
     }
     public void VerCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response, context);
         hc.VerCarrito();
     }
     public void AdministrarTienda(){
         //LLEVA A LA VISTA DE ADMINISTRADOR
     }
     public void AnadirAlCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response, context);
         hc.AnadirAlCarrito();
     }
     public void ConfirmarCompra(){
         HelperCarrito hc = new HelperCarrito(request, response, context);
         hc.ConfirmarCompra();
     }
     public void EliminarDelCarrito(){
         HelperCarrito hc = new HelperCarrito(request, response, context);
         hc.EliminarDelCarrito();
     }
     public void ConfirmarRegistro(){
         HelperUsuarios hu = new HelperUsuarios(request, response, context);
         hu.ConfirmarRegistro();
     }
     public void IniciarSesion(){
         HelperUsuarios hu = new HelperUsuarios(request, response, context);
         hu.IniciarSesion();
     }
     public void IntroducirProducto(){
         HelperProductos hp = new HelperProductos(request, response, context);
         hp.IntroducirProducto();
     }
     public void ActualizarInventario(){
         HelperProductos hp = new HelperProductos(request, response, context);
         hp.ActualizarInventario();
     }
     public void MostrarUsuarios(){
         HelperUsuarios hu = new HelperUsuarios(request, response, context);
         hu.MostrarUsuarios();
     }
     public void EliminarUsuario(){
         HelperUsuarios hu = new HelperUsuarios(request, response, context);
         hu.EliminarUsuario();
     }
     public void ActualizarContrasena(){
         HelperUsuarios hu = new HelperUsuarios(request, response, context);
         hu.ActualizarContrasena();
     }

 }
