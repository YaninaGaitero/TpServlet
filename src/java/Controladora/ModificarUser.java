/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.usuarioDAO;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ezequiel
 */
@WebServlet(name = "ModificarUser", urlPatterns = {"/ModificarUser"})
public class ModificarUser extends HttpServlet {

    usuarioDAO usDao = usuarioDAO.DameInstancia();
    Hashtable Users = usDao.traerTodos();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String mensaje = "";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n"
<<<<<<< HEAD
             + "    <head>\n"
=======
            /* + "    <head>\n"
>>>>>>> origin/master
             + "        <meta charset=\"utf-8\">\n"
             + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
             + "        <title>BIENVENIDA A NUESTRA FERRETERIA</title>\n"
             + "        <!-- All Stylesheets -->\n"
             + "        <link rel=\"stylesheet\"  href=\"css/All-Stylesheets.css\">\n"
             + "        <!-- Add 2 Home -->\n"
             + "\n"
             + "        <script type=\"text/javascript\" src=\"js/add2home.js\" charset=\"utf-8\"></script>\n"
             + "        <!-- Javascript File -->\n"
             + "        <script src=\"js/jquery.js\"></script>\n"
             + "        <script type=\"text/javascript\" src=\"js/jquery-1.7.1.min.js\"></script>\n"
             + "        <!-- Donut Chart -->\n"
             + "        <script type=\"text/javascript\" src=\"js/jquery.donutchart.js\"></script>\n"
             + "        <!-- jQuery Mobile -->\n"
             + "        <script src=\"js/jquery.mobile-1.3.2.min.js\"></script>\n"
             + "        <!-- Glyphicons -->\n"
             + "        <script type=\"text/javascript\" async src=\"js/glyphicons/ga.js\"></script>\n"
<<<<<<< HEAD
             + "    </head>");
=======
             + "    </head>"*/);
>>>>>>> origin/master

            if (session.getAttribute("mensaje") != null) {
                mensaje = session.getAttribute("mensaje").toString();
                out.println("<br><br> <center>" + mensaje + "</center> <br><br>");
            }

            out.println("<body>\n"
                    + "<div class=\"container\">\n"
                    + "	<section id=\"content\">\n"
                    + "		<form action=\"ModificarUser\" name=\"ModificarUser\" method=\"POST\">\n"
                    + "            <div>\n"
                    + "	<table >\n"
                    + "                    <tr >\n"
                    + "                        <td >\n"
                    + "                            idUsuario\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            nombre\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            apellido\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            dni\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            Usuario\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            Administrador\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            activo\n"
                    + "                        </td>\n"
                    + "                       <td>"
                    + "                             MODIFICAR"
                    + "                       </td>"
                    + "                    </tr>   \n");
<<<<<<< HEAD

=======
<<<<<<< HEAD
>>>>>>> origin/master
            /*    Enumeration Datos = Users.elements();
             while (Datos.hasMoreElements()) {
             Usuario us = (Usuario) Datos.nextElement();
             out.println("<tr>");
             out.println("  <td>");
             out.println(us.getIdUsuario());
             out.println("   </td>");
             out.println("  <td>");
             out.println(us.getNombre());
             out.println("   </td>");
             out.println("  <td>");
             out.println(us.getApellido());
             out.println("   </td>");
             out.println("  <td>");
             out.println(us.getDni());
             out.println("   </td>");
             out.println("  <td>");
             out.println(us.getUser());
             out.println("   </td>");
             out.println("  <td>");
             if (us.getAdministrador()) {
             out.println("Si");
             } else {
             out.println("No");
             }
             out.println("   </td>");
             out.println("  <td>");
             if (us.getActivo()) {
             out.println("Si");
             } else {
             out.println("No");
             }
             out.println("   </td>");
             out.println("<td>");
             out.println("<input type =\"submit\" value = \"" + us.getIdUsuario() + "\" name=\"IdUsuario\"/>");
             out.println("</tr>");
             }*/
<<<<<<< HEAD

=======
=======
>>>>>>> origin/master
            Enumeration Datos = Users.elements();
            while (Datos.hasMoreElements()) {
                Usuario us = (Usuario) Datos.nextElement();
                out.println("<tr>");
                out.println("  <td>");
                out.println(us.getIdUsuario());
                out.println("   </td>");
                out.println("  <td>");
                out.println(us.getNombre());
                out.println("   </td>");
                out.println("  <td>");
                out.println(us.getApellido());
                out.println("   </td>");
                out.println("  <td>");
                out.println(us.getDni());
                out.println("   </td>");
                out.println("  <td>");
                out.println(us.getUser());
                out.println("   </td>");
                out.println("  <td>");
                if (us.getAdministrador()) {
                    out.println("Si");
                } else {
                    out.println("No");
                }
                out.println("   </td>");
                out.println("  <td>");
                if (us.getActivo()) {
                    out.println("Si");
                } else {
                    out.println("No");
                }
                out.println("   </td>");
                out.println("<td>");
                out.println("<input type =\"submit\" value = \"" + us.getIdUsuario() + "\" name=\"IdUsuario\"/>");
                out.println("</td>");
                out.println("</tr>");

            }
>>>>>>> origin/master
            out.println("              </table>\n"
                    + "            </div>\n"
                    + "            <center>\n"
                    + "                </div>\n"
                    + "    				\n"
                    + "                    <input value=\"ENVIAR DATOS\" name =\"enviardatos\" type=\"submit\">\n"
                    + "                        \n"
                    + "                    \n"
                    + "\n"
                    + "    			</div> \n"
                    + "            </center>  \n"
                    + "		</form><!-- form -->\n"
                    + "		<div class=\"button\">\n"
                    + "			\n"
                    + "		</div><!-- button -->\n"
                    + "	</section><!-- content -->\n"
                    + "</div><!-- container -->\n"
                    + "\n"
                    + "</body></html>");
        }finally{
            out.close();
        }
    }
//}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
<<<<<<< HEAD

 /*int Id = Integer.parseInt((String) request.getAttribute("IdUsuario"));
            HttpSession session = request.getSession();*/

            HttpSession session = request.getSession(true);
            String idd = (String)request.getParameter("IdUsuario");
            int Id = Integer.parseInt(idd);
            Usuario u= usDao.buscarByID(Id);
            session.setAttribute("UsuarioAmodificar", u);
            response.sendRedirect("ModificarUser2");
            session.setAttribute("UsuarioAmodificar", usDao.buscarByID(Id));
            response.sendRedirect("ModificarUser2");
=======
<<<<<<< HEAD
           /* int Id = Integer.parseInt((String) request.getAttribute("IdUsuario"));
            HttpSession session = request.getSession();
=======
            HttpSession session = request.getSession(true);
            String idd = (String)request.getParameter("IdUsuario");
            int Id = Integer.parseInt(idd);
            
>>>>>>> origin/master
            session.setAttribute("UsuarioAmodificar", usDao.buscarByID(Id));
            response.sendRedirect("ModificarUser2");*/
>>>>>>> origin/master

        } catch (Exception ex) {
            Logger.getLogger(ModificarUser.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
