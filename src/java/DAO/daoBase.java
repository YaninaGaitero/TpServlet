

package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class daoBase {
    Connection conexion;
    Statement sentencia;
    ResultSet resultado;
    public static void cargarDriver(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e)
        {   
            
            System.out.println("No se pudo cargar el driver " + e.getMessage());
        }
    }
    
    public  void conectar(){
        try{
            String url = "jdbc:mysql://127.0.0.1/tpservlets";
            conexion = DriverManager.getConnection(url, "root", "");
            sentencia= conexion.createStatement();
            System.out.println("Conexion exitosa con la bbdd");
        }catch (Exception e){
            String mensaje = e.getMessage();
            System.out.println("No es posible establecer conexion con la bbdd " + e.getMessage());
        }
    }
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
