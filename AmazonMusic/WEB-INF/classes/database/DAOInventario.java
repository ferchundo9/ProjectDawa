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


        //################################## OBTENER PRODUCTOS FILTRADOS ###########################################3
        public  HashMap<String, Item>  ObtenerProductosFiltrados(String precioMax,String autor,String ano){
                HashMap<String, Item> catalogo = new HashMap<>();
                 try{
                     if(precioMax==null || precioMax==""){
                        precioMax="9999999999999999";
                     }
                     if(autor=="" || autor==null){
                        autor="%";
                     }
                     if(ano==null || ano=="" ){
                        ano="%";
                     }
                     sentencia = conexion.prepareStatement("select * from  cd join item on cd.Referencia=item.Referencia where cd.ano like ? and cd.Autor like ? and item.precio < ?");
                     sentencia.setString(1,ano);
                     sentencia.setString(2,autor);
                     sentencia.setDouble(3,Double.valueOf(precioMax.replace(",",".")));
                     consulta=sentencia.executeQuery();

                     while (consulta.next()) {
                         Item item1;
                         Cd cd1 = new Cd();
                         cd1.setReferencia(consulta.getString("Referencia"));
                         cd1.setPrecio(consulta.getDouble("Precio"));
                         cd1.setUrlImagen(consulta.getString("imagen"));
                         cd1.setTitulo(consulta.getString("Titulo"));
                         cd1.setAutor(consulta.getString("Autor"));
                         cd1.setAno(consulta.getString("Ano"));
                         cd1.setValoracion(consulta.getInt("valoracion"));
                         item1=(Item) cd1;
                         catalogo.put(cd1.getReferencia(),item1);
                     }
                   }catch(Exception e){

                   }

                   return catalogo;
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




        public void IntroducirProducto(Double precio,String url,Integer valoracion,String titulo,String autor,Integer ano,Integer stock){
            int numero;
            try {
               sentencia = conexion.prepareStatement("SELECT max(Referencia) as Referencia FROM item");
               consulta = sentencia.executeQuery();
               consulta.next();
               numero=consulta.getInt("Referencia");
               sentencia = conexion.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
               sentencia.setInt(1, numero);
               sentencia.setDouble(2, precio);
               sentencia.setString(3, url);
               sentencia.setInt(4, valoracion);
               sentencia.executeQuery();
               sentencia = conexion.prepareStatement("INSERT INTO cd VALUES(?,?,?,?)");
               sentencia.setInt(1, numero);
               sentencia.setString(2, titulo);
               sentencia.setString(3, autor);
               sentencia.setInt(4, ano);
               sentencia.executeQuery();
               sentencia = conexion.prepareStatement("INSERT INTO inventario VALUES(?,?)");
               sentencia.setInt(1, numero);
               sentencia.setInt(2, stock);
               sentencia.executeQuery();
            }
            catch (SQLException e){
                System.out.println(e);
            }
            
        }
        public void ActualizarInventario(Integer referencia,Integer stock){
            try {
               sentencia = conexion.prepareStatement("update inventario set Stock=? where Referencia=?");
               sentencia.setInt(1, stock);
               sentencia.setInt(2, referencia);
               sentencia.executeQuery();
            }
            catch (SQLException e){
                System.out.println(e);
            }
        }
}
