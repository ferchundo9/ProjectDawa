package businessLogic;
import database.FachadaDAO;
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
      //IMPLEMENTACION
   }
   public void AnadirAlCarrito(){
      //IMPLEMENTACION
   }
   public void EliminarDelCarrito(){
      //IMPLEMENTACION
   }
   public void ConfirmarCompra(){
      fdao.ConfirmarCompra();
   }
}