package businessLogic;

public class Cliente extends Usuario{
   private Tarjeta tarjeta;
   
   public Cliente(){
      super();
   }
   
   public Cliente(String nombre, String email, String direccion, String contrasena){
      super(nombre, email, direccion, contrasena);
   }
   
   public Cliente(String nombre, String email, String direccion,String contrasena, String num, String fecha){
      super(nombre, email, direccion, contrasena);
      this.tarjeta = new Tarjeta(num, fecha);
   }
   public Tarjeta getTarjeta(){
      return this.tarjeta;
   }
   public void setTarjeta(Tarjeta tarjeta){
      this.tarjeta = tarjeta;
   }
   
}