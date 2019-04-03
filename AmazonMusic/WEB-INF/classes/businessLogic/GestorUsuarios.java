package businessLogic;
import database.FachadaDAO;
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
      fdao.RegistrarUsuario();
   }
   public void IniciarSesion(){
      fdao.ValidarInicioSesion();
   }
   public void MostrarUsuarios(){
      fdao.ObtenerUsuarios();
   }
   public void ActualizarContrasena(){
      fdao.ActualizarContrasena();
   }
   public void EliminarUsuario(){
      fdao.EliminarUsuario();
   }