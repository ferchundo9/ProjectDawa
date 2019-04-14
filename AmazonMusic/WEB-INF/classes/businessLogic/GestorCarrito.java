package businessLogic;
import database.FachadaDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class GestorCarrito{
   private HttpServletRequest request;
   private HttpServletResponse response;
   private FachadaDAO fdao;
   public GestorCarrito(HttpServletRequest request, HttpServletResponse response){
      this.request = request;
      this.response = response;
      this.fdao = new FachadaDAO(request,response);
   }
   public void ObtenerCarrito(){
      //IMPLEMENTACION
   }
   public void AnadirAlCarrito(){
      try{
         HttpSession sesion = request.getSession();
         if(sesion.getAttribute("usuarioSesion")!=null){
            if(fdao.RestarStock(request.getParameter("Referencia"), Integer.parseInt(request.getParameter("Cantidad")))){
               request.setAttribute("itemAnadido", "correcto");
               HttpSession session = request.getSession(true); 
               Carrito carrito = (Carrito) session.getAttribute("carrito");
               
               Item item = fdao.ObtenerProducto(request.getParameter("Referencia"));
               ItemPedido itemPedido = new ItemPedido(item, Integer.parseInt(request.getParameter("Cantidad")));
               carrito.addItem(itemPedido);
            }else{
               request.setAttribute("itemAnadido", "incorrecto");
            }
            HashMap<String, Item> catalogo = fdao.ObtenerProductos();
            request.setAttribute("catalogo", catalogo);
            RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
            vista.forward(request,response);
         }else{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }
      }catch(Exception e){}
   }
   public void EliminarDelCarrito(){
      try{
          HttpSession sesion = request.getSession();
          if(sesion.getAttribute("carrito")!=null){
               HttpSession session = request.getSession(true); 
               Carrito carrito = (Carrito) session.getAttribute("carrito");
               int cantidad = carrito.getItems().get(request.getParameter("Referencia")).getCantidad();
               carrito.eliminarItem(request.getParameter("Referencia"));
               RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
               vista.forward(request,response);
               fdao.ActualizarInventario(request.getParameter("Referencia"), cantidad);
          }else{
               RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
               vista.forward(request,response);
          }
      }catch(Exception e){}
   }
   public void ConfirmarCompra(){
      //////FALTA MANDARLE EL CORREO AL USUARIO UNA VEZ SE HACE LA COMPRA BIEN//////////
      HttpSession sesion = request.getSession();
      Carrito carrito = (Carrito) sesion.getAttribute("carrito");
      String email = (String) sesion.getAttribute("usuarioSesion");
      Date fecha = new Date();
      //String fechaCompra = new SimpleDateFormat("dd-MM-yyyy - hh:mm").format(fecha);
      String fechaCompra = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMMM 'de' yyyy (hh:mm)").format(fecha);
      if(carrito.getNumItems() > 0){
         fdao.ConfirmarCompra(carrito, email, fechaCompra);
         request.setAttribute("factura", carrito);
         request.setAttribute("fecha", fechaCompra);
         sesion.setAttribute("carrito", new Carrito());
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("factura.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }else{
         try{
            RequestDispatcher  vista = request.getRequestDispatcher("carrito.jsp");
            vista.forward(request,response);
         }catch(Exception e){
         }
      }
   }
   
   public void ComprarYa(){
      try{
         HttpSession sesion = request.getSession();
         if(sesion.getAttribute("usuarioSesion")!=null){
            if(fdao.RestarStock(request.getParameter("ReferenciaComprarYa"), Integer.parseInt(request.getParameter("CantidadComprarYa")))){
               HttpSession session = request.getSession(true); 
               Carrito carrito = (Carrito) session.getAttribute("carrito");
               
               Item item = fdao.ObtenerProducto(request.getParameter("ReferenciaComprarYa"));
               ItemPedido itemPedido = new ItemPedido(item, Integer.parseInt(request.getParameter("CantidadComprarYa")));
               carrito.addItem(itemPedido);
               ConfirmarCompra();
            }else{
               request.setAttribute("itemAnadido", "incorrecto");
               HashMap<String, Item> catalogo = fdao.ObtenerProductos();
               request.setAttribute("catalogo", catalogo);
               RequestDispatcher  vista = request.getRequestDispatcher("Catalogo.jsp");
               vista.forward(request,response);
            }
            
         }else{
            RequestDispatcher  vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request,response);
         }
      }catch(Exception e){}
   }
   
}