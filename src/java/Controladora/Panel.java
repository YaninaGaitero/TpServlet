/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yanina
 */
@WebServlet(name = "Panel", urlPatterns = {"/Panel"})
public class Panel extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(true);
        String mensaje = "";
        try {
                
                
               
            
            out.println("<html>\n"
                    + "    <head>\n"
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
                    + "    </head>");
            
            if (session.getAttribute("mensaje") != null) 
            {
                mensaje = session.getAttribute("mensaje").toString();
                out.println("<br><br> <center>" + mensaje + "</center> <br><br>");
            }
                   out.println("<body>\n"
                    + "        <!-- Page Contents Starts\n"
                    + "            ================================================== -->\n"
                    + "        <div data-role=\"page\" id=\"page\" data-theme=\"a\">\n"
                    + "            <!-- header Starts -->\n"
                    + "            <div data-role=\"header\" data-theme=\"f\" class=\"header\">\n"
                    + "                <h1><a href=\"index.html\" rel=\"external\">FERRETERIA ANTUNEZ</a></h1>\n"
                    + "                <a href=\"#left-panel\" data-shadow=\"false\" ><i class=\"fa fa-indent fa-2x\"></i></a>\n"
                    + "                <a href=\"#right-panel\" data-shadow=\"false\" ><i class=\"fa fa-bars fa-2x\"></i></a>\n"
                    + "            </div>\n"
                    + "            <!-- header Ends -->\n"
                    + "            <div data-role=\"content\">\n"
                    + "                <!-- Welcome Text Starts -->\n"
                    + "                <div class=\"welcome-text\">\n"
                    + "                    <h1><span class=\"normal\">Bievenido " + (String) session.getAttribute("usuario") + "</h1> \n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <div data-role=\"panel\" id=\"left-panel\" data-theme=\"g\">\n"
                    + "                <div id=\"accordion\">\n"
                    + "                    <ul id=\"items\">\n"
                    + "                        <li>\n"
                    + "                            <a href=\"index.html\" rel=\"external\" class=\"activated\"></i>INICIO</a>\n"
                    + "                        </li>\n"
                    + "                        <li>\n"
                    + "                            <a href=\"#\"></i>USUARIOS</a>\n"
                    + "                            <ul class=\"sub-items\">\n"
                    + "                                <li>\n"
                    + "                                    <a href=\"photo-gallery.html\" rel=\"external\">- ALTA</a>\n"
                    + "                                </li>\n"
                    + "                                <li>\n"
                    + "                                    <a href=\"video-gallery.html\" rel=\"external\">- BAJA</a>\n"
                    + "                                </li>\n"
                    + "                                <li>\n"
                    + "                                    <a href=\"2-columns-portfolio.html\" rel=\"external\">- MODIFICAR</a>\n"
                    + "                                </li>\n"
                    + "                            </ul>\n"
                    + "                        </li>\n"
                    + "                        <li>\n"
                    + "                            <a href=\"#\"></i>PRODUCTOS</a>\n"
                    + "                            <ul class=\"sub-items\">\n"
                    + "                                <li>\n"
                    + "                                    <a href=\"3-columns-portfolio.html\" rel=\"external\">-  HISTORIAL</a>\n"
                    + "                                </li>\n"
                    + "                                <li>\n"
                    + "                                    <a href=\"2-columns-portfolio.html\" rel=\"external\">- 2 COLUMNS</a>\n"
                    + "                                </li>\n"
                    + "                                <li>\n"
                    + "                                    <a href=\"1-columns-portfolio.html\" rel=\"external\">- 1 COLUMN</a>\n"
                    + "                                </li>\n"
                    + "                            </ul>\n"
                    + "            <div data-role=\"panel\" id=\"right-panel\" data-position=\"right\" data-theme=\"g\">\n"
                    + "        <script src=\"owl-carousel/owl-carousel/owl.carousel.js\"></script> \n"
                    + "        <!-- Custom JS File -->\n"
                    + "        <script src=\"js/custom.js\"></script> \n"
                    + "        <script src=\"menu/js/main.js\"></script>    \n"
                    + "        <!-- Twitter -->\n"
                    + "        <script src=\"js/tweets/twitlive-min.js\"></script>\n"
                    + "        <script>\n"
                    + "            $(document).ready(function() {\n"
                    + "            	$(\".customizeWindow\").click(function() {\n"
                    + "            		$(\".customizeMe\").css(\"display\", \"block\");\n"
                    + "            	});\n"
                    + "            	\n"
                    + "            	$(\"#close\").click(function() {\n"
                    + "            		$(\".customizeMe\").css(\"display\", \"none\");\n"
                    + "            	});\n"
                    + "            	\n"
                    + "            	$(\"#custSearch\").click(function() {\n"
                    + "            		$(\".customizeMe\").css(\"display\", \"none\");\n"
                    + "            		$(\"#tweet_container h1 em\").html($(\"#keyword\").val());\n"
                    + "            	});\n"
                    + "            	\n"
                    + "            	$(\".tweets\").liveTweets({operator: \"#google\", liveTweetsToken: \"R8l0mjc5sbfmSB1fRdKB15T19mGfI8mpnnfvWipmo\"});\n"
                    + "            });\n"
                    + "        </script>\n"
                    + "        <script>window.jQuery || document.write('<script src=\"flexslider/js/libs/jquery-1.7.min.js\">\\x3C/script>')</script> \n"
                    + "        <!-- FlexSlider --> \n"
                    + "        <script defer src=\"flexslider/jquery.flexslider.js\"></script> \n"
                    + "        <script type=\"text/javascript\">\n"
                    + "            $(function(){\n"
                    + "              SyntaxHighlighter.all();\n"
                    + "            });\n"
                    + "            $(window).load(function(){\n"
                    + "              $('#carousel').flexslider({\n"
                    + "                animation: \"slide\",\n"
                    + "                controlNav: false,\n"
                    + "                animationLoop: false,\n"
                    + "                slideshow: false,\n"
                    + "                itemWidth: 108,\n"
                    + "                itemMargin: 0,\n"
                    + "                asNavFor: '#slider'\n"
                    + "              });\n"
                    + "            \n"
                    + "              $('#slider').flexslider({\n"
                    + "                animation: \"slide\",\n"
                    + "                controlNav: false,\n"
                    + "                animationLoop: false,\n"
                    + "                slideshow: false,\n"
                    + "                sync: \"#carousel\",\n"
                    + "                start: function(slider){\n"
                    + "                  $('body').removeClass('loading');\n"
                    + "                }\n"
                    + "              });\n"
                    + "            });\n"
                    + "        </script> \n"
                    + "        <!-- Retina Display -->\n"
                    + "        <script src=\"js/Retina/retina.js\"></script>\n"
                    + "    </body>\n"
                    + "</html>");
        }
        
        
        finally
        {
            out.close();
        }   
    }

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
        processRequest(request, response);
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
