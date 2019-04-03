import javax.servlet.*;
import javax.servlet.http.*;

public class Controlador extends HttpServlet{
 public void init(ServletConfig config) throws ServletException{
    super.init(config);
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
         HelperProductos hp = new HelperProductos(request, response);
         hp.VerCatalogo();
     }
 }
