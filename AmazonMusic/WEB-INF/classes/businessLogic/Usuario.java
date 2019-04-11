package businessLogic;

public class Usuario{
   private String nombre;
   private String email;
   private String direccion;
   private String contrasena; 
   
   public Usuario(String nombre, String email, String direccion, String contrasena){
      this.nombre= nombre;
      this.email = email;
      this.direccion = direccion;
      this.contrasena = contrasena;
   }
   
   public Usuario(){}
   
   public void setNombre(String nombre){
      this.nombre = nombre;
   }
   
   public void setEmail(String email){
      this.email=email;
   }
   
   public void setDireccion(String direccion){
      this.direccion=direccion;
   }
   
   public void setContrasena(String contrasena){
      this.contrasena  = contrasena;
   }
   
   public String getNombre(){
      return this.nombre;
   }
   public String getEmail(){
      return this.email;
   }
   public String getDireccion(){
      return this.direccion;
   }
   
   public String getContrasena(){
      return this.contrasena;
   }
   
}



