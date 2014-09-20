/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author alumno
 */
public interface IDAO <t>{
    public void agregar(t dato);
    public void modificar(t dato);
    public void eliminar(t dato);
    public t buscarByID(int id);
    public Hashtable traerTodos();
}
