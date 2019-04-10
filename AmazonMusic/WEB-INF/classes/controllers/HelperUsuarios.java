package controllers;
import businessLogic.FachadaModelo;
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
      fm.ConfirmarRegistro();
   }
   public void IniciarSesion(){
      fm.IniciarSesion();
   }
   
   public void CerrarSesion(){
      fm.CerrarSesion();
   }
   public void MostrarUsuarios(){
      fm.MostrarUsuarios();
   }
   public void ActualizarContrasena(){
      fm.ActualizarContrasena();
   }
   public void EliminarUsuario(){
      fm.EliminarUsuario();
   }
}