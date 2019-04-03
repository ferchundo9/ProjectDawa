import javax.servlet.*;
import javax.servlet.http.*;


public class FachadaModelo{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private GestorUsuarios gu;
   private GestorCarrito gc;
   private GestorProductos gp;
   
   public HelperUsuarios(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.gu = new GestorUsuarios(request,response);
      this.gc = new GestorCarrito(request,response);
      this.gp = new GestorProductos(request,response);
   }
   ////////////////////////////////////
   public void VerCarrito(){
   }
   public void AnadirAlCarrito(){
   }
   public void EliminarDelCarrito(){
   }
   public void ConfirmarCompra(){
   }
   ////////////////////////////////////
   public void ConfirmarRegistro(){
   }
   public void IniciarSesion(){
   }
   public void MostrarUsuarios(){
   }
   public void ActualizarContrasena(){
   }
   public void EliminarUsuario(){
   }
   ////////////////////////////////////
   public void VerCatalogo(){
   }
   public void VerProducto(){
   }
   public void FiltrarProductos(){
   }
   public void IntroducirProducto(){
   }
   public void ActualizarInventario(){
   }
   