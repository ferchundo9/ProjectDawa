package businessLogic;
import database.FachadaDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


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
      try{
         HttpSession sesion = request.getSession();
         if(sesion.getAttribute("usuarioSesion")!=null){
         
            request.setAttribute("itemAnadido", "correcto");
                  
            HashMap<String, Item> catalogo = fdao.ObtenerProductos();
            request.setAttribute("catalogo", catalogo);
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }else{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }
      }catch(Exception e){}
   }
   public void EliminarDelCarrito(){
      //IMPLEMENTACION
   }
   public void ConfirmarCompra(){
      fdao.ConfirmarCompra();
   }
}