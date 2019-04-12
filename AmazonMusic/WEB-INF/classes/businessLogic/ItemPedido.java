package businessLogic;

public class ItemPedido{
   private Item item;
   private int cantidad;
   
   public ItemPedido(){}
   
   public ItemPedido(Item item, int cantidad){
      this.item= item;
      this.cantidad=cantidad;
   }
   
   public void setItem(Item item){
      this.item = item;
   }
   
   public void setCantidad(int cantidad){
      this.cantidad = cantidad;
   }
   
   public int getCantidad(){
      return this.cantidad;
   }
   
   public Item getItem(){
      return this.item;
   }
   
   public double getPrecio(){
      return (this.item.getPrecio()* this.cantidad);
   }

   
}