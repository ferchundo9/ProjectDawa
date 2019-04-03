import javax.servlet.*;
import javax.servlet.http.*;


public class FachadoDAO{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private DAOUsuarios daoU;
   private DAOPedidos daoP;
   private DAOInventario daoI;
   public GestorCarrito(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.daoU = new DAOUsuarios(request,response);
      this.daoP = new DAOPedidos(request, response);
      this.daoI = new DAOInventario(request, response);
   }
   //////////////////////////////////////////
   public void ObtenerProductos(){
   }
   public void ObtenerProducto(){
   }
   public void ObtenerProductosFiltrados(){
   }
   public void IntroducirProducto(){
   }
   public void ActualizarInventario(){
   }
   //////////////////////////////////////////
   public void ConfirmarCompra(){
   }
   //////////////////////////////////////////
   public void RegistrarUsuario(){
   }
   public void ValidarInicioSesion(){
   }
   public void EliminarUsuario(){
   }
   public void ActualizarContrasena(){
   }