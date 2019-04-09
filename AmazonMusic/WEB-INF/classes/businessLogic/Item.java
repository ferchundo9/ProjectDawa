package businessLogic;

public class Item{
   private String urlImagen;
   private Double precio;
   private String referencia;
   public Item(){
   }
   public String getUrlImagen(){
      return this.urlImagen;
   }
   public Double getPrecio(){
      return this.precio;
   }
   public String getReferencia(){
      return this.referencia;
   }
   public void setUrlImagen(String urlImagen){
      this.urlImagen = urlImagen;
   }
   public void setPrecio(Double precio){
      this.precio = precio;
   }
   public void setReferencia(String referencia){
      this.referencia = referencia;
   }
}