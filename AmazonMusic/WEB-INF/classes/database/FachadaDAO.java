package database;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FachadoDAO{
   private java.sql.Connection conexion;
   private HttpServletRequest request;
   private HttpServlerResponse response;
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

         credenciales.setProperty("usuario", context.getInitParameter("usuario"););
         credenciales.setProperty("password", context.getInitParameter("password"););
         this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" + servidor + ":" + puerto + "/" + baseDatos , credenciales);
   }
   //////////////////////////////////////////
   public void ObtenerProductos(){
      DAOInventario daoI = new DAOInventario();
      daoI.ObtenerProductos();
   }
   public void ObtenerProducto(){
      DAOInventario daoI = new DAOInventario();
      daoI.ObtenerProducto();
   }
   public void ObtenerProductosFiltrados(){
      DAOInventario daoI = new DAOInventario();
      daoI.ObtenerProductosFiltrados();
   }
   public void IntroducirProducto(){
      DAOInventario daoI = new DAOInventario();
   }
   public void ActualizarInventario(){
      DAOInventario daoI = new DAOInventario();
      daoI.IntroducirProducto();
   }
   //////////////////////////////////////////
   public void ConfirmarCompra(){
      DAOPedidos daoP = new DAOPedidos();
      daoP.ConfirmarCompra();
   }
   //////////////////////////////////////////
   public void RegistrarUsuario(){
      DAOUsuarios daoU = new DAOUsuarios();
      daoU.RegistrarUsuario();
   }
   public void ValidarInicioSesion(){
      DAOUsuarios daoU = new DAOUsuarios();
      daoU.ValidarInicioSesion();
   }
   public void EliminarUsuario(){
      DAOUsuarios daoU = new DAOUsuarios();
      daoU.EliminarUsuario();
   }
   public void ActualizarContrasena(){
      DAOUsuarios daoU = new DAOUsuarios();
      daoUActualizarContrasena();
   }