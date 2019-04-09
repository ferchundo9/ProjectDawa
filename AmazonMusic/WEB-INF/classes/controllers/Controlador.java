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
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerCatalogo();
     }
     public void VerProducto(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerProducto();
     }
     public void FiltrarProductos(){
         HelperProductos hp = new HelperProductos(request, response);
         hp.FiltrarProductos();
     }
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
     public void IniciarSesion(){
         HelperUsuarios hu = new HelperUsuarios(request, response);
         hu.IniciarSesion();
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
