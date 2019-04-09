package database;
import java.sql.*;
import businessLogic.*;
import java.util.*;
public class DAOPedidos{
   private java.sql.Connection conexion;
   private PreparedStatement sentencia;
   private ResultSet consulta;
   public DAOPedidos(java.sql.Connection conexion){
      this.conexion = conexion;
      this.consulta = null;
      this.sentencia = null;
   }
   public void ConfirmarCompra(){

   }
}