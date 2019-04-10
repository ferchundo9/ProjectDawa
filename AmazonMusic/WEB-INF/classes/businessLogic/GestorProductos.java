package businessLogic;
import database.FachadaDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class GestorProductos{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaDAO fdao;
   public GestorProductos(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fdao = new FachadaDAO(request, response);
   }
   public void VerCatalogo(){
      HashMap<String, Item> catalogo = fdao.ObtenerProductos();
      request.setAttribute("catalogo", catalogo);
      try{
         RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
         vista.forward(request,response);
      }catch(Exception e){
      }
   }
   public void VerProducto(){
      Item producto = fdao.ObtenerProducto(request.getParameter("Referencia"));
      request.setAttribute("producto", producto);
      try{
         RequestDispatcher  vista = request.getRequestDispatcher("item.jsp");
         vista.forward(request,response);
      }catch(Exception e){
      }
   }
   public void FiltrarProductos(){
    HashMap<String, Item> catalogo = fdao.ObtenerProductosFiltrados();
      request.setAttribute("catalogo", catalogo);
      try{
         RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
         vista.forward(request,response);
      }catch(Exception e){
      }
   }
   
   public void IntroducirProducto(){
      fdao.IntroducirProducto();
   }
   public void ActualizarInventario(){
      fdao.ActualizarInventario();
   }
}