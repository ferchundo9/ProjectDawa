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
            sentencia = conexion.prepareStatement("INSERT INTO usuario VALUES('"+cliente.getNombre()+"', '"+cliente.getEmail() + "', MD5('"+cliente.getContrasena()+"'), '"+cliente.getDireccion()+"')");
            sentencia.executeUpdate();
            
            sentencia = conexion.prepareStatement("INSERT INTO tarjeta VALUES('"+cliente.getTarjeta().getNumero()+"', '"+cliente.getTarjeta().getVencimiento()+"')");
            sentencia.executeUpdate();
            
            sentencia = conexion.prepareStatement("INSERT INTO cliente(email,tarjeta) VALUES('"+cliente.getEmail() + "', '"+cliente.getTarjeta().getNumero()+"')");
            sentencia.executeUpdate();
            return true;
      }catch(Exception e ){return false;}
   }
   public void ObtenerUsuarios(){
   
   }
   public boolean ValidarInicioSesion(String email, String password){
      String contrasena;
      try{
         sentencia = conexion.prepareStatement("SELECT Contrasena FROM usuario WHERE Email=? AND Contrasena=MD5(?)");
         sentencia.setString(1, email);
         sentencia.setString(2, password);
         
         consulta = sentencia.executeQuery();
         if  (consulta.next()) {
            return true;
         }else{
            return false;
         }
  
      }catch(Exception e){}
      return false;
   }
   public void EliminarUsuario(String email){
   try{
      ResultSet consulta2;
      sentencia = conexion.prepareStatement("SELECT * FROM pedido where Email=?");
      sentencia.setString(1, email);
      consulta = sentencia.executeQuery();
      while(consulta.next()){
         sentencia=conexion.prepareStatement("DELETE FROM itemspedido where id=?");
         sentencia.setInt(1, consulta.getInt("id"));
         sentencia.executeUpdate();
      }
      sentencia = conexion.prepareStatement("DELETE FROM pedido where Email=?");
      sentencia.setString(1, email);
      sentencia.executeUpdate();
      sentencia = conexion.prepareStatement("DELETE FROM pedido where Email=?");
      sentencia.setString(1, email);
      sentencia.executeUpdate();
      sentencia = conexion.prepareStatement("DELETE FROM pedido where Email=?");
      sentencia.setString(1, email);
      sentencia.executeUpdate();
      }catch(Exception e){}




   }
   public void ActualizarContrasena(String email,String password){
      try{
         sentencia=conexion.prepareStatement("UPDATE usuario SET contrasena=? WHERE email=? ");
         sentencia.setString(1, password);
         sentencia.setString(2, email);
         consulta = sentencia.executeQuery();
      }catch(Exception e){}
   }
   
   public String ValidarClienteAdministrador(String email,String password){
      try{
         sentencia = conexion.prepareStatement("SELECT * FROM cliente WHERE Email=?");
         sentencia.setString(1, email);
         
         consulta = sentencia.executeQuery();
         if  (consulta.next()) {
            return "cliente";
         }else{   
            return "admin";
         }
  
      }catch(Exception e){}
      return null;
   }
}