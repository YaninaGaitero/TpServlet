/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Entidades.CCompras;
import Entidades.Usuario;
import java.util.Enumeration;

/**
 *
 * @author Yanina
 */
public class CComprasDAO extends daoBase implements IDAO<CCompras> {
    usuarioDAO usuarioDao= new usuarioDAO();

    @Override
    public void agregar(CCompras dato) {
        try{
            conectar();
            Usuario usuario= usuarioDao.buscarByID(dato.getUsuario().getIdUsuario());
            String query="INSERT INTO CCOMPRAS(usuarioID, fecha) values("+dato.getUsuario().getIdUsuario() +","+dato.getFecha() +")";
            sentencia.execute(query);
        }catch(Exception e){
            System.out.println("Error al insertar CCompras");
        }finally{
            desconectar();
        }
    }

    @Override
    public void modificar(CCompras dato) {
       String query="Update CCompras set usuarioID= " +dato.getUsuario().getIdUsuario() + ", fecha= "+ dato.getFecha();
        try{
            conectar();
            sentencia.executeUpdate(query);
        }catch(Exception e){
            System.out.println("Error al modificar CCompras");
        }finally{
            desconectar();
        }
    }

    @Override
    public void eliminar(CCompras dato) {
        String query= "DELETE PROM CCompras WHERE idFactura=" +dato.getUsuario().getIdUsuario();
        try{
            conectar();
            sentencia.executeQuery(query);
        }catch(Exception ex){
            System.out.println("Error al eliminar CCompras");
        }finally{
            desconectar();
        }
    }

    @Override
    public CCompras buscarByID(int id) {
        return null;
    }

    @Override
    public Enumeration<CCompras> traerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
