import javax.servlet.*;
import javax.servlet.http.*;


public class HelperUsuarios{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaModelo fm;
   public HelperUsuarios(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fm = new FachadaModelo(request,response);
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