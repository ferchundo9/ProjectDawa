package businessLogic;

public class Tarjeta{
   private String numero;
   private String vencimiento;
   public Tarjeta(){
   }
   public String getNumero(){
      return this.numero;
   }
   public String getVencimiento(){
      return this.vencimiento;
   }
   public void setNumero(String numero){
      this.numero = numero;
   }
   public void setVencimiento(String vencimiento){
      this.vencimiento = vencimiento;
   }
   
}