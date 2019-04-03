import javax.servlet.*;
import javax.servlet.http.*;


public class GestorCarrito{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaDAO fdao;
   public GestorCarrito(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fdao = new FachadaDAO(request,response);
   }
   public void ObtenerCarrito(){
   }
   public void AnadirAlCarrito(){
   }
   public void EliminarDelCarrito(){
   }
   public void ConfirmarCompra(){
   }