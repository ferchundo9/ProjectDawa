package controllers;
import businessLogic.FachadaModelo;
import javax.servlet.*;
import javax.servlet.http.*;


public class HelperCarrito{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaModelo fm;
   public HelperCarrito(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fm = new FachadaModelo(request,response);
   }
   public void VerCarrito(){
      fm.VerCarrito();
   }
   public void AnadirAlCarrito(){
      fm.AnadirAlCarrito();
   }
   public void EliminarDelCarrito(){
      fm.EliminarDelCarrito();
   }
   public void ConfirmarCompra(){
      fm.ConfirmarCompra();
   }
}