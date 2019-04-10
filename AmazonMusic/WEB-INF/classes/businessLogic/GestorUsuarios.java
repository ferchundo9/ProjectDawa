package businessLogic;
import database.FachadaDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class GestorUsuarios{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaDAO fdao;
   public GestorUsuarios(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fdao = new FachadaDAO(request, response);
   }
   public void ConfirmarRegistro(){
      fdao.RegistrarUsuario();
   }
   public void IniciarSesion(){
      try{
         String email=request.getParameter("emailLogin");
         String password=request.getParameter("passwordLogin");
         if(fdao.ValidarInicioSesion(email,password)){
            HttpSession session = request.getSession(true);//usa la sesion si existe o ccrea una nueva sesion si no existe
            session.setAttribute("usuarioSesion", "Carlitos");
            
            //obtencion de datos del catalogo 
            HashMap<String, Item> catalogo = fdao.ObtenerProductos();
            request.setAttribute("catalogo", catalogo);
            
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }else{
            request.setAttribute("login", "incorrecto");
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }
        }catch(Exception e){}
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
}