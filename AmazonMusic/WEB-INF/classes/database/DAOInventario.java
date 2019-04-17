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
        public  HashMap<String, Item>  ObtenerProductosFiltrados(String precioMax,String autor,String ano, String titulo){
                HashMap<String, Item> catalogo = new HashMap<>();
                 try{
                     if(precioMax==null || precioMax==""){
                        precioMax="9999999999999999";
                     }
                     if(autor=="" || autor==null){
                        autor="%";
                     }
                     if(autor=="" || autor==null){
                        titulo="%";
                     }
                     if(ano==null || ano=="" ){
                        ano="%";
                     }
                     if(titulo==null || titulo==""){
                        titulo="%";
                     }
                     titulo = "%" + titulo + "%";
                     sentencia = conexion.prepareStatement("select * from  cd join item on cd.Referencia=item.Referencia where cd.ano like ? and cd.Autor like ? and item.precio < ? and cd.Titulo like ?");
                     sentencia.setString(1,ano);
                     sentencia.setString(2,autor);
                     sentencia.setDouble(3,Double.valueOf(precioMax.replace(",",".")));
                     sentencia.setString(4,titulo);
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

       public int ObtenerStock(String referencia){
            int stock =0;
            try{
               sentencia = conexion.prepareStatement("SELECT Stock FROM inventario WHERE Referencia=?");
               sentencia.setInt(1, Integer.parseInt(referencia));
               consulta = sentencia.executeQuery();
               while(consulta.next()){
                  stock = consulta.getInt("Stock");
               }
            }catch(Exception e){}
            return stock;
       }
       
       public synchronized boolean RestarStock(String referencia, int cantidad){
            boolean stockSuficiente = false;
            try{
               sentencia = conexion.prepareStatement("SELECT Stock FROM inventario WHERE Referencia=?");
               sentencia.setInt(1, Integer.parseInt(referencia));
               consulta = sentencia.executeQuery();
               if(consulta.next()){
                  int StockOriginal = consulta.getInt("Stock");
                  if(StockOriginal >=cantidad){//Si hay stock suficiente
                     int StockActualizado = StockOriginal - cantidad;
                     sentencia = conexion.prepareStatement("UPDATE inventario SET Stock=? WHERE Referencia=?");
                     sentencia.setInt(1, StockActualizado);
                     sentencia.setInt(2, Integer.parseInt(referencia));
                     sentencia.executeUpdate();
                     return true;
                  }
               }
            }catch(Exception e){}
            return stockSuficiente;
       }
       
       public boolean ComprobarPedidoUsuario(String usuario, String referencia){
            try{
               sentencia = conexion.prepareStatement("SELECT * FROM itemspedido JOIN  pedido ON itemspedido.id=pedido.id WHERE Referencia=? AND Email=?");
               sentencia.setInt(1, Integer.parseInt(referencia));
               sentencia.setString(2, usuario);
               consulta = sentencia.executeQuery();
               return (consulta.next());
            }catch(Exception e){return false;}
       }
       
       public void AnadirValoracion(String referencia, Valoracion valoracion){
            try{
               //Anade el comentario a la BD
               sentencia = conexion.prepareStatement("INSERT INTO valoracion VALUES(?, ?, ?, ?)");
               sentencia.setString(1, valoracion.getCliente());
               sentencia.setString(2, referencia);
               sentencia.setInt(3, valoracion.getValoracion());
               sentencia.setString(4, valoracion.getComentario());
               sentencia.executeUpdate();
               //Actualiza la puntuacion media del item
               sentencia = conexion.prepareStatement("UPDATE item SET valoracion=(SELECT AVG(valoracion) FROM valoracion WHERE referencia=?) WHERE Referencia=?");
               sentencia.setString(1,referencia);
               sentencia.setString(2,referencia);
               sentencia.executeUpdate();
            }catch(Exception e){
               System.out.println("Falla añadir valoracion " + e.getMessage());
            }
       }
       


        public void IntroducirProducto(Double precio,String url,String titulo,String autor,Integer ano,Integer stock){
            int numero;
            try {
               sentencia = conexion.prepareStatement("SELECT max(Referencia) as Referencia FROM item");
               consulta = sentencia.executeQuery();
               consulta.next();
               numero=consulta.getInt("Referencia");
               numero=numero+1;
               sentencia = conexion.prepareStatement("INSERT INTO item(Referencia,Precio,imagen,valoracion) VALUES(?,?,?,1)");
               sentencia.setInt(1, numero);
               sentencia.setDouble(2, precio);
               sentencia.setString(3, url);
               sentencia.executeUpdate();
               sentencia = conexion.prepareStatement("INSERT INTO cd VALUES(?,?,?,?)");
               sentencia.setInt(1, numero);
               sentencia.setString(2, titulo);
               sentencia.setString(3, autor);
               sentencia.setInt(4, ano);
               sentencia.executeUpdate();
               sentencia = conexion.prepareStatement("INSERT INTO inventario VALUES(?,?)");
               sentencia.setInt(1, numero);
               sentencia.setInt(2, stock);
               sentencia.executeUpdate();
            }
            catch (SQLException e){
                System.out.println(e);
            }
            
        }

        
        public void ActualizarInventario(String referencia, int cantidad){
            try{
               sentencia = conexion.prepareStatement("SELECT Stock FROM inventario WHERE Referencia=?");
               sentencia.setInt(1, Integer.parseInt(referencia));
               consulta = sentencia.executeQuery();
               if(consulta.next()){
                  int stockOriginal = consulta.getInt("Stock");
                  int stockActualizado = stockOriginal+cantidad;
                  sentencia = conexion.prepareStatement("UPDATE inventario SET Stock=? WHERE Referencia=?");
                  sentencia.setInt(1, stockActualizado);
                  sentencia.setInt(2, Integer.parseInt(referencia));
                  sentencia.executeUpdate();
               }
            }catch(Exception e){}
        }
        
        public void EliminarProducto(String referencia){
            try{

               sentencia = conexion.prepareStatement("DELETE FROM itemspedido WHERE Referencia = ?");
               sentencia.setString(1,referencia);
               sentencia.executeUpdate();
               sentencia = conexion.prepareStatement("DELETE FROM valoracion WHERE referencia = ?");
               sentencia.setInt(1, Integer.parseInt(referencia));
               sentencia.executeUpdate();
               sentencia = conexion.prepareStatement("DELETE FROM item WHERE referencia = ?");
               sentencia.setInt(1, Integer.parseInt(referencia));
               sentencia.executeUpdate();
            }catch(Exception e){
               System.out.println("Falla la consulta de eliminarCD " + e.getMessage());
            }
        }
        
        public void AnadirStock(String referencia, Integer cantidad){
            try{
               sentencia = conexion.prepareStatement("UPDATE inventario SET Stock=? WHERE Referencia = ?");
               sentencia.setInt(1,cantidad);
               sentencia.setString(2,referencia);
               sentencia.executeUpdate();
               
               
            }catch(Exception e){
               System.out.println("Fallo al añadir cantidades" + e.getMessage());
            }
        }
}
