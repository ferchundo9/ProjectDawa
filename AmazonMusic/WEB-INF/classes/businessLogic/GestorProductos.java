package businessLogic;
import database.FachadaDAO;
import javax.servlet.*;
import javax.servlet.http.*;


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
      fdao.ObtenerProductos();
   }
   public void VerProducto(){
      fdao.ObtenerProducto();
   }
   public void FiltrarProductos(){
      fdao.ObtenerProductosFiltrados();
   }
   public void IntroducirProducto(){
      fdao.IntroducirProducto();
   }
   public void ActualizarInventario(){
      fdao.ActualizarInventario();
   }