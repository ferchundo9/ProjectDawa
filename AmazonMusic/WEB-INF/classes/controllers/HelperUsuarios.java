package controllers;
import businessLogic.FachadaModelo;
import javax.servlet.*;
import javax.servlet.http.*;
import businessLogic.*;

public class HelperUsuarios{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaModelo fm;
   public HelperUsuarios(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fm = new FachadaModelo(request,response);
   }
   public String IniciarSesion(String email,String password){
      return fm.IniciarSesion(email,password);
   }
   
   public void CrearCuenta(){
      fm.CrearCuenta();
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
   
   public String AdminCliente(){
      return fm.AdminCliente();
   }
   public void actualizarUsuario(){
      fm.actualizarUsuario();
   }
   public void borrarUsuario(){
      fm.borrarUsuario();
   }
   public void actualizarAdmin(){
      fm.actualizarAdmin();
   }
   public void borrarAdmin(){
      fm.borrarAdmin();
   }
   public void insertarAdmin(){
      fm.insertarAdmin();
   }



}