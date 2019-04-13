package businessLogic;
import java.util.*;

public class Valoracion{
   private Integer valoracion;
   private String comentario;
   private String cliente;
   public Valoracion(){
   }
   public Valoracion(Integer valoracion, String comentario, String cliente){  
      this.valoracion = valoracion;
      this.comentario = comentario;
      this.cliente = cliente;
   }
   public Integer getValoracion(){
      return this.valoracion;
   }
   public String getComentario(){
      return this.comentario;
   }
   public String getCliente(){
      return this.cliente;
   }
   public void setValoracion(Integer valoracion){
      this.valoracion = valoracion;
   }
   public void setComentario(String comentario){
      this.comentario = comentario;
   }
   public void setCliente(String cliente){
      this.cliente = cliente;
   }


}