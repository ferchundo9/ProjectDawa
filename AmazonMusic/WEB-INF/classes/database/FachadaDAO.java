package database;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import businessLogic.*;


public class FachadaDAO{
   private java.sql.Connection conexion;
   private HttpServletRequest request;
   private HttpServletResponse response;
   private ServletContext context;
   public FachadaDAO(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.context = request.getServletContext();
      try {


         Properties credenciales = new Properties();
         String gestor = context.getInitParameter("gestor");
         String servidor = context.getInitParameter("servidor");
         String puerto = context.getInitParameter("puerto");
         String baseDatos = context.getInitParameter("baseDatos");

         credenciales.setProperty("user", context.getInitParameter("usuario"));
         credenciales.setProperty("password", context.getInitParameter("password"));

         Class.forName("com.mysql.jdbc.Driver");
         this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" + servidor + ":" + puerto + "/" + baseDatos , "AmazonMusic", "AmazonMusic");
      }catch(Exception e){
         RequestDispatcher  vista = request.getRequestDispatcher("index.html");
         try{ vista.forward(request,response);
         }catch(Exception er){}
      }
   }
   //////////////////////////////////////////
   public HashMap<String, Item> ObtenerProductos(){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerProductos();
   }
   public Item ObtenerProducto(String referencia){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerProducto(referencia);
   }
   public ArrayList<Valoracion> ObtenerValoraciones(String referencia){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerValoraciones(referencia);
   }
   public int ObtenerStock(String referencia){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerStock(referencia);
   }
   public HashMap<String, Item> ObtenerProductosFiltrados(String precioMax,String autor,String ano, String titulo){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ObtenerProductosFiltrados(precioMax,autor,ano, titulo);
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
   public boolean RegistrarUsuario(Cliente cliente){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.RegistrarUsuario(cliente);
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
