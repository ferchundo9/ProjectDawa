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
<<<<<<< HEAD
=======
   public void ComprobarUsuarioVip(){
      fm.ComprobarUsuarioVip();
   }
>>>>>>> 91c8707228f7e374ebf19517644783aec112232a
   public void AnadirAlCarrito(){
      fm.AnadirAlCarrito();
   }
   public void EliminarDelCarrito(){
      fm.EliminarDelCarrito();
   }
   public void ConfirmarCompra(){
      fm.ConfirmarCompra();
   }
   
   public void ComprarYa(){
      fm.ComprarYa();
   }
}