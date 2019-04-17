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
   public boolean AnadirAlCarrito(){
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
            return true;
         }else{
            return false;
         }
      }catch(Exception e){}
      return false;
   }
   public boolean EliminarDelCarrito(){
      try{
          HttpSession sesion = request.getSession();
          if(sesion.getAttribute("carrito")!=null){
               HttpSession session = request.getSession(true);
               Carrito carrito = (Carrito) session.getAttribute("carrito");
               int cantidad = carrito.getItems().get(request.getParameter("Referencia")).getCantidad();
               carrito.eliminarItem(request.getParameter("Referencia"));
               fdao.ActualizarInventario(request.getParameter("Referencia"), cantidad);
               return true;
          }else{
               return false;
          }
      }catch(Exception e){}
      return false;
   }
   public boolean ConfirmarCompra(){
      //////FALTA MANDARLE EL CORREO AL USUARIO UNA VEZ SE HACE LA COMPRA BIEN//////////
      HttpSession sesion = request.getSession();
      Carrito carrito = (Carrito) sesion.getAttribute("carrito");
      String email = (String) sesion.getAttribute("usuarioSesion");
      Date fecha = new Date();
      String fechaCompra = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMMM 'de' yyyy (hh:mm)").format(fecha);
      if(carrito.getNumItems() > 0){
         fdao.ConfirmarCompra(carrito, email, fechaCompra);
         request.setAttribute("factura", carrito);
         request.setAttribute("fecha", fechaCompra);
         sesion.setAttribute("carrito", new Carrito());

         //ENVIAR CORREO
         try{
               Properties props = new Properties();
               props.setProperty("mail.smtp.host", "smtp.gmail.com");
               props.setProperty("mail.smtp.starttls.enable", "true");
               props.setProperty("mail.smtp.port", "587");
               props.setProperty("mail.smtp.user", "noreply.amazonmusic@gmail.com");
               props.put("mail.smtp.password", "amazonmusic1234");
               props.setProperty("mail.smtp.auth", "true");

               // Preparamos la sesion
               Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication("noreply.amazonmusic@gmail.com", "amazonmusic1234");
                  }
               });


              // Construimos el mensaje
               MimeMessage message = new MimeMessage(session);
               message.setFrom(new InternetAddress("noreply.amazonmusic@gmail.com"));
               message.addRecipient(Message.RecipientType.TO, new InternetAddress("carlos.rial.calvo@gmail.com"));
               message.setSubject("Factura compra");
               message.setText("Mensajito con Java Mail" + "de los buenos." + "poque si");

               // Lo enviamos.
               Transport t = session.getTransport("smtp");
               t.connect("noreply.amazonmusic@gmail.com", "amazonmusic1234");
               t.sendMessage(message, message.getAllRecipients());
               t.send(message);
               // Cierre.
               t.close();
            }catch(Exception e){
               return true;
            }
         return true;
      }else{
         return false;
      }
   }

   public String ComprarYa(){
      try{
         HttpSession sesion = request.getSession();
         if(sesion.getAttribute("usuarioSesion")!=null){
            if(fdao.RestarStock(request.getParameter("ReferenciaComprarYa"), Integer.parseInt(request.getParameter("CantidadComprarYa")))){
               HttpSession session = request.getSession(true);
               Carrito carrito = (Carrito) session.getAttribute("carrito");

               Item item = fdao.ObtenerProducto(request.getParameter("ReferenciaComprarYa"));
               ItemPedido itemPedido = new ItemPedido(item, Integer.parseInt(request.getParameter("CantidadComprarYa")));
               carrito.addItem(itemPedido);
               if(ConfirmarCompra()){
                  return "factura";
               }else return "carrito";
            }else{
               request.setAttribute("itemAnadido", "incorrecto");
               HashMap<String, Item> catalogo = fdao.ObtenerProductos();
               request.setAttribute("catalogo", catalogo);
               return "Catalogo";
            }

         }else{
            return "login";
         }
      }catch(Exception e){}
      return "Catalogo";
   }

}
