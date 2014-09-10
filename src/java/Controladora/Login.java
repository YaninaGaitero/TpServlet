
package Controladora;


import DAO.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet{
    
    usuarioDAO datosUsr;
    
    @Override
    public void init() throws ServletException
    {
        try
        {
            datosUsr = new usuarioDAO();
            datosUsr.conectar();
        } catch (Exception ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destroy()
    {
        datosUsr.desconectar();
    }
    
    
    
}
