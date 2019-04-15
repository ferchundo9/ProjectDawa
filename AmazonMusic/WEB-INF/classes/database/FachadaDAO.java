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
   public void IntroducirProducto(Double precio,String url,String titulo,String autor,Integer ano,Integer stock){
      DAOInventario daoI = new DAOInventario(conexion);
      daoI.IntroducirProducto(precio,url,titulo,autor,ano,stock);
   }
   public void ActualizarInventario(String referencia, int cantidad){
      DAOInventario daoI = new DAOInventario(conexion);
      daoI.ActualizarInventario(referencia, cantidad);
   }
   public boolean RestarStock(String referencia, int cantidad){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.RestarStock(referencia, cantidad);
   }
   public boolean ComprobarPedidoUsuario(String usuario, String referencia){
      DAOInventario daoI = new DAOInventario(conexion);
      return daoI.ComprobarPedidoUsuario(usuario, referencia);
   }
   public void AnadirValoracion(String referencia, Valoracion valoracion){
      DAOInventario daoI  = new DAOInventario(conexion);
      daoI.AnadirValoracion(referencia, valoracion);
   }
   //////////////////////////////////////////
   public void ConfirmarCompra(Carrito carrito, String email, String fechaCompra){
      DAOPedidos daoP = new DAOPedidos(conexion);
      daoP.ConfirmarCompra(carrito, email, fechaCompra);
   }
   //////////////////////////////////////////
   public boolean RegistrarUsuario(Cliente cliente){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.RegistrarUsuario(cliente);
   }
   public HashMap<String,Usuario> ObtenerUsuarios(){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.ObtenerUsuarios();
   }
   public HashMap<String,Usuario> ObtenerAdmins(){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.ObtenerAdmins();
   }

   public boolean ValidarInicioSesion(String email, String password){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.ValidarInicioSesion(email, password);
   }
   public void EliminarUsuario(String correo){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.EliminarUsuario(correo);
   }
   public void ActualizarContrasena(String email,String password){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.ActualizarContrasena(email,password);
   }
   
   public String ValidarClienteAdministrador(String email){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      return daoU.ValidarClienteAdministrador(email);
   }
   
   public void EliminarProducto(String referencia){
      DAOInventario daoI = new DAOInventario(conexion);
      daoI.EliminarProducto(referencia);
   }
   public void actualizarUsuario(String nombre,String email,String contrasena,String direccion,String tarjeta,String fecha,String oldEmail){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.actualizarUsuario(nombre,email,contrasena,direccion,tarjeta,fecha,oldEmail);
   }
   public void actualizarAdmin(String nombre,String email,String contrasena,String direccion,String oldEmail){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.actualizarAdmin(nombre,email,contrasena,direccion,oldEmail);
   }

   public void insertarAdmin(String nombre,String email,String contrasena,String direccion){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.insertarAdmin(nombre,email,contrasena,direccion);
   }
   public void borrarAdmin(String email){
      DAOUsuarios daoU = new DAOUsuarios(conexion);
      daoU.borrarAdmin(email);
   }
}
