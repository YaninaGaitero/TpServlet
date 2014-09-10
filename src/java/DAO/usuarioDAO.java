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
public class usuarioDAO extends daoBase implements IDAO<Usuario>{

    @Override
    public void agregar(Usuario dato) {
    
        try {
            conectar();
            sentencia.execute("Insert into usuarios (activo , administrador , apellido, nombre, dni )values( '" + dato.getActivo()+ "','" + dato.getAdministrador() + "','" + dato.getApellido()+ "','" + dato.getNombre()+ "')");
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el usuario");
        }
            
    }
    

    @Override
    public void modificar(Usuario dato) {
       // sentencia.execute("UPDATE USUARIOS SET");
    }

    @Override
    public void eliminar(Usuario dato) {
    
    }

    @Override
    public void buscarByID(int id) {
    
    }

    @Override
    public Enumeration<Usuario> traerTodos() {
    return null;
    }
    
}
