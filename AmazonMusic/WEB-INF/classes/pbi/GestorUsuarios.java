import javax.servlet.*;
import javax.servlet.http.*;


public class GestorUsuarios{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaDAO fdao;
   public GestorUsuarios(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fdao = new FachadaDAO(request,response);
   }
   public void ConfirmarRegistro(){
   }
   public void IniciarSesion(){
   }
   public void MostrarUsuarios(){
   }
   public void ActualizarContrasena(){
   }
   public void EliminarUsuario(){
   }