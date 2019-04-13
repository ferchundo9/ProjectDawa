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
      fm.VerCatalogo();
   }
   public void VerProducto(){
      fm.VerProducto();
   }
   public void FiltrarProductos(){
      fm.FiltrarProductos();
   }
   public void IntroducirProducto(){
      fm.IntroducirProducto();
   }

}