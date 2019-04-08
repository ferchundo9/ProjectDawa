package businessLogic;

public class Cd extends Item{
   private String titulo;
   private String autor;
   private String ano;
   
   public Cd(){
      super();
   }
   public String getTitulo(){
      return this.titulo;
   }
   public String getAutor(){
      return this.autor;
   }
   public String getAno(){
      return this.ano;
   }
   public void setTitulo(String titulo){
      this.titulo = titulo;
   }
   public void setAutor(String autor){
      this.titulo = titulo;
   }
   public void setAno(String ano){
      this.ano = ano;
   }

}