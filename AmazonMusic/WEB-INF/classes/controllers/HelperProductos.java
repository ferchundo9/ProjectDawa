package controllers;
import businessLogic.FachadaModelo;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import businessLogic.*;


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
      String jsp = fm.VerCatalogo();
      if(jsp.equals("cliente")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("CatalogoAdmin.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }
   public void VerProducto(String tipo){
      fm.VerProducto();
      if(tipo.equals("admin")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("itemAdmin.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
      else{
         try{
               RequestDispatcher  vista = request.getRequestDispatcher("item.jsp");
               vista.forward(request,response);
         }catch(Exception e){}
      }
   }
   public void FiltrarProductos(String tipo){
      fm.FiltrarProductos();
      if(tipo.equals("admin")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("CatalogoAdmin.jsp");
            vista.forward(request,response);
         }catch(Exception e){

         }
      }else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
            }catch(Exception e){
            }
      }
   }
   public void IntroducirProducto(){
      fm.IntroducirProducto();
   }
   public void AnadirComentario(){
      fm.AnadirComentario();
      try{
         RequestDispatcher  vista = request.getRequestDispatcher("item.jsp");
         vista.forward(request,response);
      }catch(Exception e){
      }
   }
   
   public void EliminarProducto(){
      fm.EliminarProducto();
   }

}
