package businessLogic;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class FachadaModelo{
   private HttpServletRequest request;
   private HttpServletResponse response;
   
   public FachadaModelo(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
   }
   //////////////////////////////////// CARRITO ////////////////////////////////////
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
   //////////////////////////////////// REGISTRO ////////////////////////////////////
   public void ConfirmarRegistro(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.ConfirmarRegistro();
   }
   public void IniciarSesion(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.IniciarSesion();
   }
   public void CerrarSesion(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.CerrarSesion();
   }
   
   public void CrearCuenta(){
      GestorUsuarios gu = new GestorUsuarios(request, response);
      gu.CrearCuenta();
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
   //////////////////////////////////// PRODUCTOS ////////////////////////////////////
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

}
   