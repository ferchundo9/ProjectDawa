package businessLogic;
import java.util.*;
public class Carrito{
   private HashMap<String, Item> items;
   private Double precio;
   public Carrito(){
   }
   public HashMap<String,Item> getItems(){
      return this.items;
   }
   public Double getPrecio(){
      return this.precio;
   }
   public void setItems(HashMap<String, Item> items){
      this.items = items;
   }
   public void setPrecio(Double precio){
      this.precio = precio;
   }
}