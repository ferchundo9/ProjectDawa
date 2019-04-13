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
   }
   public String IniciarSesion(String email,String password){
      try{
         if(fdao.ValidarInicioSesion(email,password)){
            if(fdao.ValidarClienteAdministrador(email,password).equals("cliente")){ //Comprobamos si el usuario que se registra es un cliente o un administrador
               HttpSession session = request.getSession(true);//usa la sesion si existe o ccrea una nueva sesion si no existe
               session.setAttribute("usuarioSesion", email);
   
               session.setAttribute("carrito", new Carrito());
           
               //obtencion de datos del catalogo 
               HashMap<String, Item> catalogo = fdao.ObtenerProductos();
               request.setAttribute("catalogo", catalogo);

               return "cliente";
            }else if(fdao.ValidarClienteAdministrador(email,password).equals("admin")){ //Comprobamos si el usuario que se registra es un cliente o un administrador
               HttpSession session = request.getSession(true);//usa la sesion si existe o ccrea una nueva sesion si no existe
               session.setAttribute("usuarioSesion", email);
   
               session.setAttribute("carrito", new Carrito());
           
               //obtencion de datos del catalogo 
               HashMap<String, Item> catalogo = fdao.ObtenerProductos();
               request.setAttribute("catalogo", catalogo);

               return "admin";
            }
         }else{
            
            request.setAttribute("login", "incorrecto");
            return "false";

         }
        }catch(Exception e){}
        return "false";
   }
   
   public void CerrarSesion(){
      try{
          HttpSession session = request.getSession(true);
          session.invalidate();
          
          //obtencion de datos del catalogo 
           HashMap<String, Item> catalogo = fdao.ObtenerProductos();
           request.setAttribute("catalogo", catalogo);
            
           RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
           vista.forward(request,response);
          
      }catch(Exception e){}
   }
   
   public void CrearCuenta(){
      try{
         String nombreUsuario = request.getParameter("nombreRegistro");
         String email = request.getParameter("emailRegistro");
         String direccion = request.getParameter("direccionRegistro");
         String contrasena = request.getParameter("contrasenaRegistro");
         String numTarjeta = request.getParameter("numeroTarjeta");
         String fechaVencimiento = request.getParameter("fechaTarjeta");
         Cliente nuevoCliente = new Cliente(nombreUsuario, email, direccion, contrasena, numTarjeta, fechaVencimiento);
         if(fdao.RegistrarUsuario(nuevoCliente)){
            //Iniciar sesion con la nueva cuenta
            HttpSession session = request.getSession(true);//usa la sesion si existe o ccrea una nueva sesion si no existe
            session.setAttribute("usuarioSesion", email);
            HashMap<String, Item> carrito = new HashMap<>();
            session.setAttribute("carrito", carrito);
            //obtencion de datos del catalogo 
            HashMap<String, Item> catalogo = fdao.ObtenerProductos();
            request.setAttribute("catalogo", catalogo);
            
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
            
         }else{
            request.setAttribute("registro", "incorrecto");
            
            RequestDispatcher  vista = request.getRequestDispatcher("registro.jsp");
            vista.forward(request,response);
         }
      }catch(Exception e){}
   }
   public void MostrarUsuarios(){
      fdao.ObtenerUsuarios();
   }
   public void ActualizarContrasena(){
      String email=request.getParameter("email");
      String password=request.getParameter("password");
      fdao.ActualizarContrasena(email,password);
   }
   public void EliminarUsuario(){
      String correo=request.getParameter("email");
      fdao.EliminarUsuario(correo);
   }
}