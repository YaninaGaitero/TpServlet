/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Enumeration;
import Entidades.Producto;

/**
 *
 * @author alumno
 */
public class ProductosDAO extends daoBase implements IDAO<Producto>{

    @Override
    public void agregar(Producto dato) {
        try{
            conectar();
            String query="Insert into Producto(descripcion, precio,stock)values ('" + dato.getDescripcion()+","+dato.getPrecio()+","+ dato.getStock()+")";
            sentencia.execute(query);
        }catch(Exception e){
            System.out.println("Error al insertar el producto");
        }finally{
            desconectar();
        }
    }

    @Override
    public void modificar(Producto dato) {
        String query="Update Productos set descripcion ='"+dato.getDescripcion()+ "',precio =" +dato.getPrecio() + ",stock="+dato.getStock()+ "where idProducto= "+dato.getIdProducto();
        try{
            conectar();
            sentencia.executeUpdate(query);
        }catch(Exception e){
            System.out.println("Error al modificar el producto");
        }finally{
            desconectar();
        }
    }

    @Override
    public void eliminar(Producto dato) {
        String query= "DELETE PROM PRODUCTOS WHERE idProducto=" +dato.getIdProducto();
        try{
            conectar();
            sentencia.executeQuery(query);
        }catch(Exception ex){
            System.out.println("Error al eliminar el producto");
        }finally{
            desconectar();
        }
    }

    @Override
    public Producto buscarByID(int id) {
        String query= "SELECT * FROM USUARIOS WHERE idUsuario =" +id;
        Producto prod= new Producto();
    
        try {
            conectar();
            resultado= sentencia.executeQuery(query);
                while(resultado.next()){
                    prod.setIdProducto(resultado.getInt(1));
                    prod.setDescripcion(resultado.getString(2));
                    prod.setPrecio(resultado.getDouble(3));
                    prod.setStock(resultado.getInt(4));
            }
        } catch (Exception ex) {
            System.out.println("No se pudo obtener el Producto"+ ex.getMessage());
        }finally{
            desconectar();
        }
        return prod;

    }

    @Override
    public Enumeration<Producto> traerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
