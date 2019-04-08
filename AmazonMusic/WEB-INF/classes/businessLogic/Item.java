package businessLogic;

public class Item{
   private String urlImagen;
   private Float precio;
   private String referencia;
   public Item(){
   }
   public String getUrlImagen(){
      return this.urlImagen;
   }
   public Float getPrecio(){
      return this.precio;
   }
   public String getReferencia(){
      return this.referencia;
   }
   public void setUrlImagen(String urlImagen){
      this.urlImagen = urlImagen;
   }
   public void setPrecio(Float precio){
      this.precio = precio;
   }
   public void setReferencia(String referencia){
      this.referencia = referencia;
   }
}