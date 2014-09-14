/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Entidades.DCompras;
import java.util.Enumeration;
/**
 *
 * @author Yanina
 */
public class DComprasDAO extends daoBase implements IDAO<DCompras> {
    ProductosDAO prodDao= new ProductosDAO();
    @Override
    public void agregar(DCompras dato) {
        throw new UnsupportedOperationException("No es posible insertar un dcompras sin idFactura");
    }

    public void agregar(DCompras dato, Integer idFactura){
    try{
            conectar();
            String query="INSERT INTO DCOMPRAS(facturaID, importe, cantidad, productoid) values ("+idFactura + ","+ dato.getImporte() +","+dato.getCantidad()+","+dato.getProducto().getIdProducto()+")";
            sentencia.execute(query);
        }catch(Exception e){
            System.out.println("Error al insertar DCompras");
        }finally{
            desconectar();
        }
    }
    @Override
    public void modificar(DCompras dato) {
       String query="Update DCompras set importe= "+ dato.getImporte() + ",cantidad=" + dato.getcCompras()+",productoid="+ dato.getProducto().getIdProducto()+ "where idDetalle=" +dato.getIdDetalle();
        try{
            conectar();
            sentencia.executeUpdate(query);
        }catch(Exception e){
            System.out.println("Error al modificar DCompras");
        }finally{
            desconectar();
        }
    }

    @Override
    public void eliminar(DCompras dato) {
        String query= "DELETE PROM DCompras WHERE idDetalle=" +dato.getIdDetalle();
        try{
            conectar();
            sentencia.executeQuery(query);
        }catch(Exception ex){
            System.out.println("Error al eliminar DCompras");
        }finally{
            desconectar();
        }
    }

    @Override
    public DCompras buscarByID(int id) {
        DCompras dcompras= new DCompras();
        int idUsuario;
        String query="SELECT * FROM DCOMPRAS WHERE IdDetalle=" +id;        
        try {
            conectar();
            resultado= sentencia.executeQuery(query);
                while(resultado.next()){
                   dcompras.setIdDetalle(resultado.getInt(1));
                   dcompras.setImporte(resultado.getDouble(2));
                   dcompras.setCantidad(resultado.getInt(3));
                   dcompras.setProducto(prodDao.buscarByID(resultado.getInt(4)));
            }
        } catch (Exception ex) {
            System.out.println("No se pudo obtener DCompras"+ ex.getMessage());
        }finally{
            desconectar();
        }
        
        return dcompras;
    }

    @Override
    public Enumeration<DCompras> traerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}