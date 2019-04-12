package businessLogic;
import java.util.*;
public class Carrito{
   private HashMap<String, ItemPedido> items;
   private Double precio;
   private int numItems;
   
   public Carrito(){
      items = new HashMap<>();
      precio=0.0;
      numItems=0;
   }
   public HashMap<String,ItemPedido> getItems(){
      return this.items;
   }
   public Double getPrecio(){
      return this.precio;
   }
   public int getNumItems(){
      return this.numItems;
   }
   public void setItems(HashMap<String, ItemPedido> items){
      this.items = items;
   }
   public void setPrecio(Double precio){
      this.precio = precio;
   }
   
   public void addItem(ItemPedido itemPedido){
      if(!items.containsKey(itemPedido.getItem().getReferencia())){
         items.put(itemPedido.getItem().getReferencia(), itemPedido);
         this.precio += itemPedido.getPrecio();
         this.numItems += itemPedido.getCantidad();
      }else{
         ItemPedido itemViejo = items.get(itemPedido.getItem().getReferencia());
         ItemPedido itemNuevo = new ItemPedido(itemViejo.getItem(), (itemViejo.getCantidad() + itemPedido.getCantidad()));
         items.remove(itemPedido.getItem().getReferencia());
         items.put(itemPedido.getItem().getReferencia(), itemNuevo);
      }
   }
   
   public void eliminarItem(String referencia){
      if(items.containsKey(referencia)){
         ItemPedido itemViejo = items.get(referencia);
         numItems-= itemViejo.getCantidad();
         precio -= itemViejo.getPrecio();
         items.remove(referencia);
      }
   }
}