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
   public HashMap<String, Usuario> ObtenerUsuarios(){
      HashMap<String, Usuario> usuarios=new HashMap<>();
      try {
         sentencia = conexion.prepareStatement("SELECT * FROM usuario natural join projectdawa.cliente left join tarjeta on tarjeta=numero");
         consulta = sentencia.executeQuery();
         while(consulta.next()){
            String nombre,email,direccion,contrasena,num,fecha;
            nombre=consulta.getString("Nombre");
            email=consulta.getString("Email");
            direccion=consulta.getString("Direccion");
            contrasena=consulta.getString("Contrasena");
            num=consulta.getString("Numero");
            fecha=consulta.getString("Vencimiento");
            Cliente cliente=new Cliente(nombre,email,direccion,contrasena,num,fecha);
            usuarios.put(cliente.getEmail(),cliente);
         } 
         
      }catch(Exception e ){
         System.out.println(e);
      }
      return usuarios;
   }
   public HashMap<String, Usuario> ObtenerAdmins(){
      HashMap<String, Usuario> admins=new HashMap<>();
      try {
         sentencia = conexion.prepareStatement("SELECT * FROM usuario where Email in (select * from administrador)");
         consulta = sentencia.executeQuery();
         while(consulta.next()){
            String nombre,email,direccion,contrasena;
            nombre=consulta.getString("Nombre");
            email=consulta.getString("Email");
            direccion=consulta.getString("Direccion");
            contrasena=consulta.getString("Contrasena");
            Usuario admin=new Usuario(nombre,email,direccion,contrasena);
            admins.put(admin.getEmail(),admin);
         } 
         
      }catch(Exception e ){
         System.out.println(e);
      }
      return admins;
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
         System.out.println("Estamos en eliminar");
         System.out.println("Email="+email);
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
         sentencia = conexion.prepareStatement("DELETE FROM cliente where Email=?");
         sentencia.setString(1, email);
         sentencia.executeUpdate();
         sentencia = conexion.prepareStatement("DELETE FROM usuario where Email=?");
         sentencia.setString(1, email);
         sentencia.executeUpdate();
      }catch(Exception e){
         System.out.println(e);
      }
   }
   public void borrarAdmin(String email){
      try{
         sentencia = conexion.prepareStatement("DELETE FROM usuario where Email=?");
         sentencia.setString(1, email);
         sentencia.executeUpdate();
      }catch(Exception e){
         System.out.println(e);
      }

   }
   public void ActualizarContrasena(String email,String password){
      try{
         sentencia=conexion.prepareStatement("UPDATE usuario SET contrasena=? WHERE email=? ");
         sentencia.setString(1, password);
         sentencia.setString(2, email);
         consulta = sentencia.executeQuery();
      }catch(Exception e){}
   }
   
   public String ValidarClienteAdministrador(String email){
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
   public void actualizarUsuario(String nombre,String email,String contrasena,String direccion,String tarjeta,String fecha,String oldEmail){
      try{
         if(contrasena!=null){
            sentencia = conexion.prepareStatement("UPDATE usuario set Nombre=?,Email=?,Contrasena=MD5(?),Direccion=? WHERE Email=?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, email);
            sentencia.setString(3, contrasena);
            sentencia.setString(4, direccion);
            sentencia.setString(5, oldEmail);
         }
         else{
            sentencia = conexion.prepareStatement("UPDATE usuario set Nombre=?,Email=?,Direccion=? WHERE Email=?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, email);
            sentencia.setString(3, direccion);
            sentencia.setString(4, email);
         }
         sentencia.executeUpdate();
         sentencia = conexion.prepareStatement("Select tarjeta from cliente where Email=?");
         sentencia.setString(1, email);
         consulta = sentencia.executeQuery();
         String tarjetaOriginal=null;
         if  (consulta.next()) {
            tarjetaOriginal=consulta.getString("tarjeta");
         }
         sentencia = conexion.prepareStatement("UPDATE tarjeta SET Numero=?, Vencimiento=? WHERE Numero=?");
         sentencia.setString(1, tarjeta);
         sentencia.setString(2, fecha);
         sentencia.setString(3, tarjetaOriginal);
         sentencia.executeUpdate();
         
      }catch(Exception e){
         System.out.println(e);
      }
   }
   public void actualizarAdmin(String nombre,String email,String contrasena,String direccion,String oldEmail){
      try{
         if(contrasena!=null){
            sentencia = conexion.prepareStatement("UPDATE usuario set Nombre=?,Email=?,Contrasena=MD5(?),Direccion=? WHERE Email=?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, email);
            sentencia.setString(3, contrasena);
            sentencia.setString(4, direccion);
            sentencia.setString(5, oldEmail);
         }
         else{
            sentencia = conexion.prepareStatement("UPDATE usuario set Nombre=?,Email=?,Direccion=? WHERE Email=?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, email);
            sentencia.setString(3, direccion);
            sentencia.setString(4, email);
         }
         sentencia.executeUpdate();
      }catch(Exception e){
         System.out.println(e);
      }

   }
   public void insertarAdmin(String nombre,String email,String contrasena,String direccion){
      try{
         sentencia = conexion.prepareStatement("INSERT INTO usuario VALUES(?,?,MD5(?),?)");
         sentencia.setString(1, nombre);
         sentencia.setString(2, email);
         sentencia.setString(3, contrasena);
         sentencia.setString(4, direccion);
         sentencia.executeUpdate();
         sentencia = conexion.prepareStatement("INSERT INTO administrador VALUES(?)");
         sentencia.setString(1, email);
         sentencia.executeUpdate();
      }catch(Exception e){
         System.out.println(e);
      }

   }

}