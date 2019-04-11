package database;
import java.sql.*;
import businessLogic.*;
import java.util.*;
public class DAOUsuarios{
   private java.sql.Connection conexion;
   private PreparedStatement sentencia;
   private ResultSet consulta;
   public DAOUsuarios(java.sql.Connection conexion){
      this.conexion = conexion;
      this.consulta = null;
      this.sentencia = null;
   }
   public boolean RegistrarUsuario(Cliente cliente){ 
      try {
            sentencia = conexion.prepareStatement("INSERT INTO usuario VALUES('"+cliente.getNombre()+"', '"+cliente.getEmail() + "', '"+cliente.getContrasena()+"', '"+cliente.getDireccion()+"')");
            sentencia.executeUpdate();
            
            sentencia = conexion.prepareStatement("INSERT INTO tarjeta VALUES('"+cliente.getTarjeta().getNumero()+"', '"+cliente.getTarjeta().getVencimiento()+"')");
            sentencia.executeUpdate();
            
            sentencia = conexion.prepareStatement("INSERT INTO cliente VALUES('"+cliente.getEmail() + "', '"+cliente.getTarjeta().getNumero()+"')");
            sentencia.executeUpdate();
            return true;
      }catch(Exception e ){return false;}
   }
   public void ObtenerUsuarios(){
   
   }
   public boolean ValidarInicioSesion(String email, String password){
      return (email.equals("carlitos@carlitos.com") && password.equals("carlitos"));
   }
   public void EliminarUsuario(){
      
   }
   public void ActualizarContrasena(){
      
   }
}