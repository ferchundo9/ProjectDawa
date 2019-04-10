package database;
import java.sql.*;
import businessLogic.*;
import java.util.*;
public class DAOInventario{
   private java.sql.Connection conexion;
   private PreparedStatement sentencia;
   private ResultSet consulta;
   public DAOInventario(java.sql.Connection conexion){
      this.conexion = conexion;
      this.consulta = null;
      this.sentencia = null;
   }
   
   public HashMap<String, Item> ObtenerProductos(){
      HashMap<String, Item> catalogo = new HashMap<>();
      try {
            sentencia = conexion.prepareStatement("SELECT * FROM cd " + 
                                                  "LEFT JOIN item " +
                                                  "ON cd.Referencia = item.Referencia;");
            consulta = sentencia.executeQuery();
            while (consulta.next()) {
                Cd cd1 = new Cd();
                cd1.setReferencia(consulta.getString("Referencia"));
                cd1.setPrecio(consulta.getFloat("Precio"));
                cd1.setImagen(consulta.getString("imagen"));
                cd1.setTitulo(consulta.getString("Titulo"));
                cd1.setAutor(consulta.getString("Autor"));
                cd1.setAno(consulta.getString("Ano"));
                catalogo.put(cd1.getReferencia(),(Item) cd1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return catalogo;
        }
        
        public Item ObtenerProducto(String referencia){
            Item producto = new Item();
            producto.setReferencia(referencia);
            return producto;
        }
        public  HashMap<String, Item>  ObtenerProductosFiltrados(){
                Cd cd1 = new Cd();
                HashMap<String, Item> catalogo = new HashMap<>();
                 Item item1;
                 cd1.setTitulo("Queen greatest hits");cd1.setAutor("Queen");cd1.setAno("1999");cd1.setReferencia("item_0001");cd1.setPrecio(19.45);cd1.setUrlImagen("imagenes/queen.jpg");
                 item1 = (Item) cd1;
                 
                 Cd cd2 = new Cd();
                 Item item2;
                 cd2.setTitulo("Queen greatest hits2");cd2.setAutor("Queen2");cd2.setAno("1991");cd2.setReferencia("item_0002");cd2.setPrecio(14.45);cd2.setUrlImagen("imagenes/queen2.jpg");
                 item2 = (Item) cd2;
                 
                 Cd cd3 = new Cd();
                 Item item3;
                 cd3.setTitulo("Queen greatest hits3");cd3.setAutor("Queen3");cd3.setAno("1993");cd3.setReferencia("item_0003");cd3.setPrecio(11.45);cd3.setUrlImagen("imagenes/queen3.jpg");
                 item3 = (Item) cd3;
                 
                 catalogo.put(item1.getReferencia(), item1);
                 catalogo.put(item2.getReferencia(), item2);
                 catalogo.put(item3.getReferencia(), item3);
                 
                 return catalogo;   
        }
        
        public void IntroducirProducto(){
            
        }
        public void ActualizarInventario(){
            
        }
}