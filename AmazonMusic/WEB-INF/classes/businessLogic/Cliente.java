package businessLogic;

public class Cliente extends Usuario{
   private Tarjeta tarjeta;
   public Cliente(){
      
   }
   public Tarjeta getTarjeta(){
      return this.tarjeta;
   }
   public void setTarjeta(Tarjeta tarjeta){
      this.tarjeta = tarjeta;
   }
}