/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Entidades.CCompras;
import Entidades.DCompras;
import Entidades.Usuario;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yanina
 */
public class CComprasDAO extends BASEDAO implements IDAO<CCompras> {
    static CComprasDAO ccompDAO;
    usuarioDAO usuarioDao= usuarioDAO.DameInstancia();
    DComprasDAO dcomDAO= DComprasDAO.dameInstancia();
    DComprasDAO dcomprasDao= DComprasDAO.dameInstancia();
    
    
    public static CComprasDAO dameInstancia(){
        if(ccompDAO==null){
            try {
                ccompDAO= new CComprasDAO();
            } catch (Exception ex) {
                Logger.getLogger(CComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ccompDAO;
    }
    
    public CComprasDAO () throws Exception{
        super();
    }


    @Override
    public void agregar(CCompras dato) {
       String query="INSERT INTO CCOMPRAS(usuarioID, fecha) values("+dato.getUsuario().getIdUsuario() +","+dato.getFecha() +")";
        try {
            int filas= actualizar(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(CComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(CCompras dato) {
        String query="Update CCompras set usuarioID= " +dato.getUsuario().getIdUsuario() + ", fecha= "+ dato.getFecha();
        try {
            ejecutarQuery(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(CComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(CCompras dato) {
      String query= "DELETE PROM CCompras WHERE idFactura=" +dato.getUsuario().getIdUsuario();
        try {
            ejecutarQuery(crearSentencia(query));
            Enumeration claves= dato.getDetalle().keys();
            Hashtable detalle= dato.getDetalle();
            while(claves.hasMoreElements()){
                int clave=(int)claves.nextElement();
                dcomDAO.eliminar((DCompras)detalle.get(clave), dato);
            }
           /* for(DCompras d: dato.getDetalle()){
                dcomDAO.eliminar(d, dato.getIdFactura());
            }*/
        } catch (Exception ex) {
            Logger.getLogger(CComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CCompras buscarByID(int id) {
        CCompras comp= new CCompras();
        String query= "SELECT * FROM CCOMPRAS WHERE idFactura="+id;
                try {
            conectar();
            ResultSet rs= consultar(crearSentencia(query));
            while(rs.next()){
               comp.setIdFactura(rs.getInt("idFactura"));
               comp.setFecha(rs.getDate("fecha"));
               comp.setUsuario(usuarioDao.buscarByID(rs.getInt("usuarioID")));
               comp.setDetalle(null);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comp;
    }

    @Override
    public Hashtable traerTodos() {
        Hashtable hash = new Hashtable();
        String query = "SELECT * FROM CCOMPRAS ";
        try {
            conectar();
            ResultSet rs = consultar(crearSentencia(query));
            int idUsuario;
            while (rs.next()) {

                CCompras CC = new CCompras();
                CC.setIdFactura(rs.getInt("idFactura"));
                idUsuario= rs.getInt("UsuarioId");
                CC.setUsuario(usuarioDao.buscarByID(idUsuario));
                CC.setFecha(rs.getDate("Fecha"));
                CC.setDetalle(dcomprasDao.traeDetalleDeFactura(CC));
                
                hash.put(rs.getInt("IDDetalle"), CC);
            }

        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return hash;
    }
}    