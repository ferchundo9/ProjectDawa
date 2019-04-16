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
   public void ComprobarUsuarioVip(){
      fm.ComprobarUsuarioVip();
      try{
            RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
   }
   public void AnadirAlCarrito(){
      if(fm.AnadirAlCarrito()){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
          try{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }
   public void EliminarDelCarrito(){
      if(fm.EliminarDelCarrito()){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }
   public void ConfirmarCompra(){
      if(fm.ConfirmarCompra()){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("factura.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
          try{
            RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }

   public void ComprarYa(){
      String jsp = fm.ComprarYa();
      if(jsp.equals("factura")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("factura.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
      else if(jsp.equals("carrito")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
      else if(jsp.equals("Catalogo")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
      else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }
}
