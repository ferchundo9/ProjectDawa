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
   public String VerCatalogo(){
      HashMap<String, Item> catalogo = fdao.ObtenerProductos();
      request.setAttribute("catalogo", catalogo);
      HttpSession session = request.getSession(true);
      String email=(String)session.getAttribute("usuarioSesion");
      if(email==null){
         return "cliente";
      }
      return fdao.ValidarClienteAdministrador(email);
      
   }
   public void VerProducto(){
      Item producto = fdao.ObtenerProducto(request.getParameter("Referencia"));
      request.setAttribute("producto", producto);
      ArrayList<Valoracion> valoraciones = fdao.ObtenerValoraciones(request.getParameter("Referencia"));
      request.setAttribute("valoraciones", valoraciones);
      int stock = fdao.ObtenerStock(request.getParameter("Referencia"));
      request.setAttribute("stock", stock);
   }
   public void FiltrarProductos(){
      String precioMax=request.getParameter("precioMaxCD");
      String autor=request.getParameter("autorCD");
      String ano=request.getParameter("anoCD");
      String titulo=request.getParameter("nombreCD");
      HashMap<String, Item> catalogo = fdao.ObtenerProductosFiltrados(precioMax,autor,ano, titulo);
      request.setAttribute("catalogo", catalogo); 
   }
   
   public void IntroducirProducto(){
      Double precio=Double.parseDouble(request.getParameter("precioCdNuevo").replace(',','.'));
      String url=request.getParameter("imagenCdNuevo");
      String titulo=request.getParameter("tituloCdNuevo");
      String autor=request.getParameter("autorCdNuevo");
      Integer ano=Integer.parseInt(request.getParameter("anoCdNuevo"));
      Integer stock=Integer.parseInt(request.getParameter("stockCdNuevo"));
      fdao.IntroducirProducto(precio,url,titulo,autor,ano,stock);
   }
   
   public void AnadirComentario(){
      
      String usuario = (String)request.getSession().getAttribute("usuarioSesion");
      String referencia = request.getParameter("Referencia2");
      if(fdao.ComprobarPedidoUsuario(usuario, referencia)){
         String comentario = request.getParameter("opinion");
         int puntuacion = Integer.parseInt(request.getParameter("estrellas"));
         Valoracion valoracion  = new Valoracion(puntuacion, comentario, usuario);
         fdao.AnadirValoracion(referencia, valoracion);
         request.setAttribute("comentario", "correcto");
      }else{
         request.setAttribute("comentario", "incorrecto");
      }
      try{
         Item producto = fdao.ObtenerProducto(referencia);
         request.setAttribute("producto", producto);
         ArrayList<Valoracion> valoraciones = fdao.ObtenerValoraciones(referencia);
         request.setAttribute("valoraciones", valoraciones);
         int stock = fdao.ObtenerStock(referencia);
         request.setAttribute("stock", stock);
      }catch(Exception e){
      }
   }
   
   public void EliminarProducto(){
      String referencia = request.getParameter("Referencia");
      fdao.EliminarProducto(referencia);
   }
   
   

}