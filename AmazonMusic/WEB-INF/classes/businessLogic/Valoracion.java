package businessLogic;
import java.util.*;

public class Valoracion{
   private Integer valoracion;
   private String comentario;
   public Valoracion(){
   }
   public Integer getValoracion(){
      return this.valoracion;
   }
   public String getComentario(){
      return this.comentario;
   }
   public void setValoracion(Integer valoracion){
      this.valoracion = valoracion;
   }
   public void setComentario(String comentario){
      this.comentario = comentario;
   }


}