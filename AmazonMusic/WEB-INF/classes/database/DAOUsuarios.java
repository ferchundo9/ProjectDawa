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
   public void RegistrarUsuario(){
      
   }
   public void ObtenerUsuarios(){
   
   }
   public void ValidarInicioSesion(){
      
   }
   public void EliminarUsuario(){
      
   }
   public void ActualizarContrasena(){
      
   }
}