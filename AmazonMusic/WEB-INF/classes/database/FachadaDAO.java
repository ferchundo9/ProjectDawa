package database;
import javax.servlet.*;
import javax.servlet.http.*;


public class FachadoDAO{
   public FachadaDAO(){

   }
   //////////////////////////////////////////
   public void ObtenerProductos(){
      DAOInventario daoI = new DAOInventario();
   }
   public void ObtenerProducto(){
      DAOInventario daoI = new DAOInventario();
   }
   public void ObtenerProductosFiltrados(){
      DAOInventario daoI = new DAOInventario();
   }
   public void IntroducirProducto(){
      DAOInventario daoI = new DAOInventario();
   }
   public void ActualizarInventario(){
      DAOInventario daoI = new DAOInventario();
   }
   //////////////////////////////////////////
   public void ConfirmarCompra(){
      DAOPedidos daoP = new DAOPedidos();
   }
   //////////////////////////////////////////
   public void RegistrarUsuario(){
      DAOUsuarios daoU = new DAOUsuarios();
   }
   public void ValidarInicioSesion(){
      DAOUsuarios daoU = new DAOUsuarios();
   }
   public void EliminarUsuario(){
      DAOUsuarios daoU = new DAOUsuarios();
   }
   public void ActualizarContrasena(){
      DAOUsuarios daoU = new DAOUsuarios();
   }