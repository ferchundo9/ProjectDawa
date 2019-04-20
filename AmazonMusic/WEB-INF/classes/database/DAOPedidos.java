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
   public void ConfirmarCompra(Carrito carrito, String email, String fechaCompra){
        try{
               conexion.setAutoCommit(false);
               
               sentencia = conexion.prepareStatement("SELECT vip FROM cliente WHERE email=?");
               sentencia.setString(1, email);
               consulta = sentencia.executeQuery();
               Double precio = carrito.getPrecio();
               if(consulta.next() && consulta.getInt("vip")==1){precio = precio*0.8;}
               sentencia = conexion.prepareStatement("INSERT INTO pedido(Precio, Fecha, Email) VALUES(?,?,?)");
               sentencia.setDouble(1, precio);
               sentencia.setString(2, fechaCompra);
               sentencia.setString(3, email);
               sentencia.executeUpdate();
               
               sentencia = conexion.prepareStatement("SELECT COUNT(*) as idPedido FROM pedido");
               consulta = sentencia.executeQuery();
               int idPedido=0;
               if(consulta.next()){
                  idPedido = consulta.getInt("idPedido");
               }
               conexion.commit();
               conexion.setAutoCommit(true);
               for(Map.Entry<String, ItemPedido> entry : carrito.getItems().entrySet()){
                  sentencia = conexion.prepareStatement("INSERT INTO itemspedido(id, Referencia, Cantidad) VALUES(?,?,?)");
                  sentencia.setInt(1, idPedido);
                  sentencia.setInt(2, Integer.parseInt(entry.getValue().getItem().getReferencia()));
                  sentencia.setInt(3, entry.getValue().getCantidad());
                  sentencia.executeUpdate();
               }
               sentencia = conexion.prepareStatement("SELECT SUM(Precio) as acumulado FROM pedido WHERE Email=?");  
               sentencia.setString(1, email);
               consulta = sentencia.executeQuery();
               Double acumulado = 0.0;
               if(consulta.next()){
                  acumulado = consulta.getDouble("acumulado");
               }
               if(acumulado>100){
                  sentencia = conexion.prepareStatement("UPDATE cliente set vip=1 WHERE email=?");  
                  sentencia.setString(1, email);
                  sentencia.executeUpdate();
               }

            }catch(Exception e){}
   }
}