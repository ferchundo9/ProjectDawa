import javax.servlet.*;
import javax.servlet.http.*;


public class GestorProductos{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaDAO fdao;
   public GestorProductos(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fdao = new FachadaDAO(request,response);
   }
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