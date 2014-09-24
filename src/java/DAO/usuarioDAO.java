/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controladora.ModificarUser;
import Entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class usuarioDAO extends BASEDAO implements IDAO<Usuario> {

    public usuarioDAO() throws Exception {
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
        try {
           
            String sentencia = "Insert into usuarios (activo , administrador , apellido, nombre, dni, usuario, pass"
                    + ")values( " + dato.getActivo() + "," + dato.getActivo() + ",'"
                    + dato.getApellido() + "','" + dato.getNombre() + "'," + dato.getDni() + ",'" + dato.getUser() + "','" + dato.getContraseña() + "')";            
                int y;
                y = actualizar(crearSentencia(sentencia));
                
            } catch (Exception e) {
                String Error = e.getMessage();
                System.out.println(Error);
            }

    }

    @Override
    public void modificar(Usuario dato) {
        String query = "UPDATE usuarios SET nombre = '" + dato.getNombre() + "',apellido = '" + dato.getApellido() + "',administrador= " + 1+ ", dni=  " + dato.getDni() + ", activo = " + 1 + " where idUsuario= " + dato.getIdUsuario();
        try {
            conectar();
            actualizar(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(ModificarUser.class
                    .getName()).log(Level.SEVERE, null, ex);
        }finally{
            desconectar();
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
        Usuario us = new Usuario();
        String query = "SELECT * FROM USUARIOS WHERE idUsuario =" + id;
        try {
            conectar();
            ResultSet rs = consultar(crearSentencia(query));
            while (rs.next()) {
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
    public Hashtable traerTodos() {
        Hashtable hash = new Hashtable();
        String query = "SELECT * FROM Usuarios ";
        try {
            conectar();
            ResultSet rs = consultar(crearSentencia(query));
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setUser(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("pass"));
                usuario.setActivo(rs.getBoolean("Activo"));
                usuario.setAdministrador(rs.getBoolean("Administrador"));
                usuario.setDni(rs.getInt("dni"));

                hash.put(rs.getInt("idUsuario"), usuario);
            }

        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hash;
    }

    public Boolean validaLogIn(String usuario, String pass) {
        String query = "SELECT * FROM USUARIOS WHERE usuario like '" + usuario + "' and pass like '" + pass + "'";
        ResultSet rs;
        try {
            conectar();
            rs = consultar(crearSentencia(query));
            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            String error = ex.getMessage();
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, error);
        }
        return false;
    }
}
