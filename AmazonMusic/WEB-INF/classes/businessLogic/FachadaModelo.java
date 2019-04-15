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
   public void ComprobarUsuarioVip(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.ComprobarUsuarioVip();
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

   public void ComprarYa(){
      GestorCarrito gc = new GestorCarrito(request,response);
      gc.ComprarYa();
   }
   //////////////////////////////////// USUARIOS ////////////////////////////////////
   public void ConfirmarRegistro(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.ConfirmarRegistro();
   }
   public String IniciarSesion(String email,String password){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      return gu.IniciarSesion(email,password);
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

   public String AdminCliente(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      return gu.AdminCliente();
   }
   public void actualizarUsuario(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.actualizarUsuario();
   }
   public void borrarUsuario(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.borrarUsuario();
   }
   public void actualizarAdmin(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.actualizarAdmin();
   }
   public void borrarAdmin(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.borrarAdmin();
   }
   public void insertarAdmin(){
      GestorUsuarios gu = new GestorUsuarios(request,response);
      gu.insertarAdmin();
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
   public void AnadirComentario(){
      GestorProductos gp = new GestorProductos(request, response);
      gp.AnadirComentario();
   }
   public void EliminarProducto(){
      GestorProductos gp = new GestorProductos(request, response);
      gp.EliminarProducto();
   }







}
