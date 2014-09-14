/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class usuarioDAO extends daoBase implements IDAO<Usuario> {

    private usuarioDAO() {
    }
    static usuarioDAO usrDao;

      public static usuarioDAO DameInstancia() {
        if (usrDao == null) {
            usrDao = new usuarioDAO();
        }
        return usrDao;
    }

    @Override
    public void agregar(Usuario dato) {

        try {
            conectar();
            sentencia.execute("Insert into usuarios (activo , administrador , apellido, nombre, dni, usuario, contraseña"
                    + ")values( '" + dato.getActivo() + "','" + dato.getAdministrador() + "','"
                    + dato.getApellido() + "','" + dato.getNombre() + "','" + dato.getUser() + "','" + dato.getContraseña() + "')");

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
    }
}
