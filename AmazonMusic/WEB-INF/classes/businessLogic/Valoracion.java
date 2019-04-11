package businessLogic;
import java.util.*;

public class Valoracion{
   private Integer valoracion;
   private String comentario;
   private String cliente;
   public Valoracion(){
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