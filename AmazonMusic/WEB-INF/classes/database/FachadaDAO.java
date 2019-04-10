package database;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import businessLogic.Item;
import businessLogic.Cd;

public class FachadaDAO{
   private java.sql.Connection conexion;
   private HttpServletRequest request;
   private HttpServletResponse response;
   private ServletContext context;
   public FachadaDAO(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.context = request.getServletContext();
      /*try {
         Properties credenciales = new Properties();
         String gestor = context.getInitParameter("gestor");
         String servidor = context.getInitParameter("servidor");
         String puerto = context.getInitParameter("puerto");
         String baseDatos = context.getInitParameter("baseDatos");

         credenciales.setProperty("user", context.getInitParameter("usuario"));
         credenciales.setProperty("password", context.getInitParameter("password"));

         this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" + servidor + ":" + puerto + "/" + baseDatos , credenciales);
      }catch(Exception e){
         RequestDispatcher  vista = request.getRequestDispatcher("index.html");
         try{ vista.forward(request,response);
         }catch(Exception er){}
      }
      */
      this.conexion = null;
   }
   //////////////////////////////////////////
   public HashMap<String, Item> ObtenerProductos(){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerProductos();
   }
   public Item ObtenerProducto(String referencia){
      DAOInventario daoI = new DAOInventario(conexion);
      //return daoI.ObtenerProducto(referencia);
         Cd cd =new Cd();
         cd.setTitulo("holiii");
         cd.setAutor("Carlitoosososoosos");
         cd.setAno("1999");
         
         Item it = (Item ) cd;
         it.setPrecio(12.56);
         it.setUrlImagen("cd1.jpg");
         it.setReferencia(referencia);
      return it;
   }
   public HashMap<String, Item> ObtenerProductosFiltrados(){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerProductosFiltrados();
   }
   public void IntroducirProducto(){
      DAOInventario daoI = new DAOInventario(conexion);
      daoI.IntroducirProducto();
   }
   public void ActualizarInventario(){
      DAOInventario daoI = new DAOInventario(conexion);
      daoI.ActualizarInventario();
   }
   //////////////////////////////////////////
   public void ConfirmarCompra(){
      DAOPedidos daoP = new DAOPedidos(conexion);
      daoP.ConfirmarCompra();
   }
   //////////////////////////////////////////
   public void RegistrarUsuario(){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.RegistrarUsuario();
   }
   public void ObtenerUsuarios(){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.ObtenerUsuarios();
   }
   public boolean ValidarInicioSesion(String email, String password){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.ValidarInicioSesion(email, password);
   }
   public void EliminarUsuario(){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.EliminarUsuario();
   }
   public void ActualizarContrasena(){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.ActualizarContrasena();
   }
}