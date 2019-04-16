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
   /*Este metodo comprueba si el usuario que ha iniciado sesion es VIP o no
   si lo es a�ade el atributo "tipoUsuario" el valor "VIP"; si no es VIP
   el valor sera "normal"*/
   public void ComprobarUsuarioVip(){
      HttpSession session = request.getSession(true);
      if(fdao.ComprobarUsuarioVip((String)session.getAttribute("usuarioSesion"))){
         request.setAttribute("tipoUsuario", "VIP");
      }else{
         request.setAttribute("tipoUsuario", "normal");
      }
   }

   public String IniciarSesion(){
      String email=request.getParameter("emailLogin");
      String password=request.getParameter("passwordLogin");
      try{
         if(fdao.ValidarInicioSesion(email,password)){
            if(fdao.ValidarClienteAdministrador(email).equals("cliente")){ //Comprobamos si el usuario que se registra es un cliente o un administrador
               HttpSession session = request.getSession(true);//usa la sesion si existe o ccrea una nueva sesion si no existe
               session.setAttribute("usuarioSesion", email);
               if(fdao.ComprobarUsuarioVip(email)){
                  session.setAttribute("tipoUsuario", "VIP");
               }else{
                  session.setAttribute("tipoUsuario", "normal");
               }
               session.setAttribute("carrito", new Carrito());

               //obtencion de datos del catalogo
               HashMap<String, Item> catalogo = fdao.ObtenerProductos();
               request.setAttribute("catalogo", catalogo);

               return "cliente";
            }else if(fdao.ValidarClienteAdministrador(email).equals("admin")){ //Comprobamos si el usuario que se registra es un cliente o un administrador
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
           HashMap<String, Item> catalogo = fdao.ObtenerProductos();
           request.setAttribute("catalogo", catalogo);
      }catch(Exception e){}
   }

   public boolean CrearCuenta(){
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
            return true;
         }else{
            request.setAttribute("registro", "incorrecto");
            return false;
         }
      }catch(Exception e){}
      return false;
   }
   public void MostrarUsuarios(){
      try{
         HashMap<String, Usuario> usuarios=fdao.ObtenerUsuarios();
         request.setAttribute("usuarios", usuarios);
         HashMap<String, Usuario> admins=fdao.ObtenerAdmins();
         request.setAttribute("admins", admins);
      }catch(Exception e){
         System.out.println(e);
      }
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

   public String AdminCliente(){
      HttpSession session = request.getSession(true);
      String email=(String)session.getAttribute("usuarioSesion");
      if(email==null){
         return "cliente";
      }
      return fdao.ValidarClienteAdministrador(email);
   }
   public void actualizarUsuario(){
      String nombre=request.getParameter("nombreCliente");
      String email=request.getParameter("emailCliente");
      String contrasena=request.getParameter("contrasenaCliente");
      String direccion=request.getParameter("direccionCliente");
      String tarjeta=request.getParameter("numeroCliente");
      String fecha=request.getParameter("vencimientoCliente");
      String oldEmail=request.getParameter("oldEmail");
      fdao.actualizarUsuario(nombre,email,contrasena,direccion,tarjeta,fecha,oldEmail);

   }
   public void borrarUsuario(){
      String email=request.getParameter("correoUsuario");
      fdao.EliminarUsuario(email);
   }
   public void actualizarAdmin(){
      String nombre=request.getParameter("nombreAdmin");
      String email=request.getParameter("emailAdmin");
      String contrasena=request.getParameter("contrasenaAdmin");
      String direccion=request.getParameter("direccionAdmin");
      String oldEmail=request.getParameter("oldEmailAdmin");
      fdao.actualizarAdmin(nombre,email,contrasena,direccion,oldEmail);

   }
   public void borrarAdmin(){
      String email=request.getParameter("correoAdmin");
      fdao.borrarAdmin(email);
      HttpSession session = request.getSession(true);
      String emailSesion=(String)session.getAttribute("usuarioSesion");
      if(emailSesion.equals(email)){
         this.CerrarSesion();
      }else{
         this.MostrarUsuarios();
      }

   }
   public void insertarAdmin(){
      String nombre=request.getParameter("nombreAdmin");
      String email=request.getParameter("emailAdmin");
      String contrasena=request.getParameter("contrasenaAdmin");
      String direccion=request.getParameter("direccionAdmin");
      fdao.insertarAdmin(nombre,email,contrasena,direccion);
   }

}
