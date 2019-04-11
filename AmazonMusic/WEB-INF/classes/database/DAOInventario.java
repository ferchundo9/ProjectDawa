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

      this.sentencia = null;
   }
   
   public HashMap<String, Item> ObtenerProductos(){
      HashMap<String, Item> catalogo = new HashMap<>();
      try {
            sentencia = conexion.prepareStatement("SELECT * FROM cd LEFT JOIN item ON cd.Referencia = item.Referencia");
            consulta = sentencia.executeQuery();
            while (consulta.next()) {
                Cd cd1 = new Cd();
                cd1.setReferencia(consulta.getString("Referencia"));
                cd1.setPrecio(consulta.getDouble("Precio"));
                cd1.setUrlImagen(consulta.getString("imagen"));
                cd1.setTitulo(consulta.getString("Titulo"));
                cd1.setAutor(consulta.getString("Autor"));
                cd1.setAno(consulta.getString("Ano"));
                cd1.setValoracion(consulta.getInt("valoracion"));
                catalogo.put(cd1.getReferencia(),(Item) cd1);
            }
            

        } catch (SQLException e) {
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return catalogo;
        }
        
        public Item ObtenerProducto(String referencia){
            try {
            sentencia = conexion.prepareStatement("SELECT * FROM cd LEFT JOIN item ON cd.Referencia = item.Referencia WHERE cd.Referencia=?");
            sentencia.setInt(1, Integer.parseInt(referencia));
            consulta = sentencia.executeQuery();
            while (consulta.next()) {
                Cd cd1 = new Cd();
                cd1.setReferencia(consulta.getString("Referencia"));
                cd1.setPrecio(consulta.getDouble("Precio"));
                cd1.setUrlImagen(consulta.getString("imagen"));
                cd1.setTitulo(consulta.getString("Titulo"));
                cd1.setAutor(consulta.getString("Autor"));
                cd1.setAno(consulta.getString("Ano"));
                cd1.setValoracion(consulta.getInt("valoracion"));
                return (Item) cd1;
            }
           } catch (SQLException e) {
           } finally {
               try {
                   sentencia.close();
               } catch (SQLException e) {
                   System.out.println("Imposible cerrar cursores");
               }
           }
           return null;
        }
        
        public ArrayList<Valoracion> ObtenerValoraciones(String referencia){
         ArrayList<Valoracion> valoraciones = new ArrayList<>();
         try {
            sentencia = conexion.prepareStatement("SELECT u.Nombre, v.valoracion, v.comentario FROM valoracion as v LEFT JOIN usuario as u ON v.email = u.email WHERE referencia=?");
            sentencia.setInt(1, Integer.parseInt(referencia));
            consulta = sentencia.executeQuery();
            while (consulta.next()) {
                Valoracion valoracion = new Valoracion();
                valoracion.setCliente(consulta.getString("Nombre"));
                valoracion.setComentario(consulta.getString("comentario"));
                valoracion.setValoracion(consulta.getInt("valoracion"));
                valoraciones.add(valoracion);
            }
           } catch (SQLException e) {
           } finally {
               try {
                   sentencia.close();
               } catch (SQLException e) {
                   System.out.println("Imposible cerrar cursores");
               }
           }
           return valoraciones;
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