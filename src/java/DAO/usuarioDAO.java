/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class usuarioDAO extends BASEDAO implements IDAO<Usuario> {

    public usuarioDAO()throws Exception{
        super();
    }
   static usuarioDAO usrDao;

      public static usuarioDAO DameInstancia() {
        if (usrDao == null) {
            try {
                usrDao = new usuarioDAO();
            } catch (Exception ex) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usrDao;
    }
      
    @Override
    public void agregar(Usuario dato) {
        String sentencia= "Insert into usuarios (activo , administrador , apellido, nombre, dni, usuario, pass"
                    + ")values( " +dato.getActivo() +","+ dato.getActivo() +",'"
                    + dato.getApellido() + "','" + dato.getNombre() + "',"+dato.getDni()+",'" + dato.getUser() + "','" + dato.getContraseña() + "')";
        try{
        
        int y=actualizar(crearSentencia(sentencia));
        
        }catch(Exception e){
            
        }
    }

    @Override
    public void modificar(Usuario dato) {
        String query = "UPDATE USUARIOS SET nombre = '" + dato.getNombre() + "',apellido = '" + dato.getApellido() + "',administrador= " + dato.getAdministrador() + ", dni= '" + dato.getDni() + ", activo = " + dato.getActivo() + " where idUsuario= " + dato.getIdUsuario();
        try{
            ejecutarQuery(crearSentencia(query));
        }catch(Exception e){
        
        }
    
    }

    @Override
    public void eliminar(Usuario dato) {
        String query = "DELETE FROM USUARIOS WHERE IDUSUARIO =" + dato.getIdUsuario();
        try {
            ejecutarQuery(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario buscarByID(int id) {
       Usuario us= new Usuario();
       String query = "SELECT * FROM USUARIOS WHERE idUsuario =" + id;
        try {
            conectar();
            ResultSet rs= consultar(crearSentencia(query));
            while(rs.next()){
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setUser(rs.getString("usuario"));
                us.setContraseña(rs.getString("pass"));
                us.setDni(rs.getInt("dni"));
                us.setActivo(rs.getBoolean("activo"));
                us.setAdministrador(rs.getBoolean("administrador"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

    @Override
    public Enumeration<Usuario> traerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Boolean validaLogIn(String usuario , String pass){
        String query= "SELECT * FROM USUARIOS WHERE usuario like '" +usuario +"' and pass like '" + pass +"'" ;
        ResultSet rs;
        try {
            conectar();
            rs=consultar(crearSentencia(query));
            if(rs.next()){
                return true;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
