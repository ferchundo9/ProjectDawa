package businessLogic;
import javax.servlet.*;
import javax.servlet.http.*;


public class FachadaModelo{
   private HttpServletRequest request;
   private HttpServletResponse response;
   
   public FachadaModelo(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
   }
   ////////////////////////////////////
   public void VerCarrito(){
      GestorCarrito gc = new GestorCarrito(request,response);
      gc.ObtenerCarrito();
   }
   public void AnadirAlCarrito(){
      GestorCarrito gc = new GestorCarrito(request,response);
      gc.AnadirAlCarrito();
   }
   public void EliminarDelCarrito(){
      GestorCarrito gc = new GestorCarrito(request,response);
      gc.EliminarDelCarrito();
   }
   public void ConfirmarCompra(){
      GestorCarrito gc = new GestorCarrito(request,response);
      gc.ConfirmarCompra();
   }
   ////////////////////////////////////
   public void ConfirmarRegistro(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.ConfirmarRegistro();
   }
   public void IniciarSesion(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.IniciarSesion();
   }
   public void MostrarUsuarios(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.MostrarUsuarios();
   }
   public void ActualizarContrasena(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.ActualizarContrasena();
   }
   public void EliminarUsuario(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.EliminarUsuario();
   }
   ////////////////////////////////////
   public void VerCatalogo(){
      GestorProductos gp = new GestorProductos(request,response);
      gp.VerCatalogo();
   }
   public void VerProducto(){
      GestorProductos gp = new GestorProductos(request,response);
      gp.VerProducto();
   }
   public void FiltrarProductos(){
      GestorProductos gp = new GestorProductos(request,response);
      gp.FiltrarProductos();
   }
   public void IntroducirProducto(){
      GestorProductos gp = new GestorProductos(request,response);
      gp.IntroducirProducto();
   }
   public void ActualizarInventario(){
      GestorProductos gp = new GestorProductos(request,response);
      gp.ActualizarInventario();
   }
}
   