

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
        }catch(Exception e){
            System.out.println("No se pudo cargar el driver");
        }
    }
    
    public  void conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin/tpServlets", "", "");
            sentencia= conexion.createStatement();
            System.out.println("Conexion exitosa con la bbdd");
        }catch (Exception e){
            System.out.println("No es posible establecer conexion con la bbdd");
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
