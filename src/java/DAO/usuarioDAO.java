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
    }/*

    @Override
    public void agregar(Usuario dato) {

        try {
            conectar();
          String sentencia= "Insert into usuarios (activo , administrador , apellido, nombre, dni, usuario, pass"
                    + ")values( " + dato.getActivo() + "," + dato.getAdministrador() + ",'"
                    + dato.getApellido() + "','" + dato.getNombre() + "','" + dato.getUser() + "','" + dato.getContraseña() + "')";
            PreparedStatement d = conexion.prepareStatement(sentencia);
            d.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al insertar el usuario ("+ex.getMessage()+")");
        } finally {
            desconectar();
        }
    }

    @Override
    public void modificar(Usuario dato) {
        String query = "UPDATE USUARIOS SET nombre = '" + dato.getNombre() + "',apellido = '" + dato.getApellido() + "',administrador= '" + dato.getAdministrador() + "', dni= '" + dato.getDni() + "', activo = '" + dato.getActivo() + "' where idUsuario= '" + dato.getIdUsuario() + "'";
        try {
            conectar();
            sentencia.executeUpdate(query);
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Usuario dato) {
        String query = "DELETE FROM USUARIOS WHERE IDUSUARIO =" + dato.getIdUsuario();
        try {
            sentencia.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario buscarByID(int id) {
        String query = "SELECT * FROM USUARIOS WHERE idUsuario =" + id;
        Usuario usuario = new Usuario();

        try {
            resultado = sentencia.executeQuery(query);
            while (resultado.next()) {
                usuario.setIdUsuario(id);
                usuario.setDni(resultado.getInt(2));
                usuario.setApellido(resultado.getString(3));
                usuario.setNombre(resultado.getString(4));
                usuario.setActivo(resultado.getBoolean(5));
                usuario.setAdministrador(resultado.getBoolean(6));

            }
        } catch (SQLException ex) {
            System.out.println("No se pudo obtener el usuario" + ex.getMessage());
        }
        return usuario;
    }

    @Override
    public Enumeration<Usuario> traerTodos() {
        //Enumerator 
        return null;
    }*/

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
        String query= "SELECT * FROM USUARIOS WHERE usuario = '" +usuario +"' and pass= '" + pass +"'" ;
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
