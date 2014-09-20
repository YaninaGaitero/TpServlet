/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Enumeration;
import Entidades.Producto;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ProductosDAO extends BASEDAO implements IDAO<Producto>{
    
    static ProductosDAO prodDao;
    public static ProductosDAO dameInstancia(){
        if(prodDao==null){
            try {
                prodDao= new ProductosDAO();
            } catch (Exception ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prodDao;
    }
    
    public ProductosDAO () throws Exception{
        super();
    }

    @Override
    public void agregar(Producto dato) {
        String query= "INSERT INTO PRODUCTOS (DESCRIPCION, PRECIO, STOCK) VALUES ('" +dato.getDescripcion() +"'," + dato.getPrecio() + "," +dato.getStock()+")";
        try {
            int filas= actualizar(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Producto dato) {
        String query="Update Productos set descripcion ='"+dato.getDescripcion()+ "',precio =" +dato.getPrecio() + ",stock="+dato.getStock()+ "where idProducto= "+dato.getIdProducto();
        try {
            ejecutarQuery(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Producto dato) {
       String query = "DELETE FROM productos WHERE idproducto =" + dato.getIdProducto();
        try {
            ejecutarQuery(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Producto buscarByID(int id) {
        String query= "SELECT * FROM USUARIOS WHERE idUsuario =" +id;
        Producto prod= new Producto();
        try {
            conectar();
            ResultSet rs= consultar(crearSentencia(query));
            while(rs.next()){
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod;
    }

    @Override
    public Hashtable traerTodos() {
      Hashtable hash = new Hashtable();
        String query = "SELECT * FROM PRODUCTOS";
        try {
            conectar();
            ResultSet rs = consultar(crearSentencia(query));
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setDescripcion(rs.getString("Descripcion"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setStock(rs.getInt("Stock"));
                hash.put(rs.getInt("idProducto"), prod);
            }

        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return hash;
    }

 
    
}
