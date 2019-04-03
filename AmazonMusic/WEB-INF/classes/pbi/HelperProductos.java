import javax.servlet.*;
import javax.servlet.http.*;


public class HelperProductos{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaModelo fm;
   public HelperProductos(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fm = new FachadaModelo(request,response);
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