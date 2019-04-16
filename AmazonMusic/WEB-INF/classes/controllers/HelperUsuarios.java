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
   public void IniciarSesion(){
      String jsp = fm.IniciarSesion();
      if(jsp.equals("cliente")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else if(jsp.equals("admin")){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("CatalogoAdmin.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }
   
   public void CrearCuenta(){
      if(fm.CrearCuenta()){
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("registro.jsp");
            vista.forward(request,response);
         }catch(Exception e){
            }
      }
   }
   
   public void CerrarSesion(){
      fm.CerrarSesion();
      try{
         RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
         vista.forward(request,response);
      }catch(Exception e){
      }
   }
   public void MostrarUsuarios(){
      fm.MostrarUsuarios();
      try{
         RequestDispatcher  vista = request.getRequestDispatcher("AdminUsuarios.jsp");
         vista.forward(request,response);
      }catch(Exception e){}

   }
   public void ActualizarContrasena(){
      fm.ActualizarContrasena();
   }
   public void EliminarUsuario(){
      fm.EliminarUsuario();
   }
   
   public void AdminCliente(){
      if(fm.AdminCliente().equals("admin")){
            fm.FiltrarProductos();
            try{
               RequestDispatcher  vista = request.getRequestDispatcher("CatalogoAdmin.jsp");
               vista.forward(request,response);
            }catch(Exception e){}
      }else{
         HelperProductos hp = new HelperProductos(request, response);
         fm.VerCatalogo();
      }
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