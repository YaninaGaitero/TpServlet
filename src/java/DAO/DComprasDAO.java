/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.CCompras;
import Entidades.DCompras;
import Entidades.Producto;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yanina
 */
public class DComprasDAO extends BASEDAO {

    ProductosDAO prodDao = ProductosDAO.dameInstancia();
    static DComprasDAO dComdao = DComprasDAO.dameInstancia();

    public static DComprasDAO dameInstancia() {
        if (dComdao == null) {
            try {
                dComdao = new DComprasDAO();
            } catch (Exception ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dComdao;
    }

    public DComprasDAO() throws Exception {
        super();
    }

    public void agregar(DCompras dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void agregar(DCompras dato, int idFactura) {
        String query = "INSERT INTO DCOMPRAS(facturaID, importe, cantidad, productoid) values (" + idFactura + "," + dato.getImporte() + "," + dato.getCantidad() + "," + dato.getProducto().getIdProducto() + ")";
        try {
            conectar();
            int filas = actualizar(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(DComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(DCompras dato, int idFactura) {
        String query = "Update DCompras set importe= " + dato.getImporte() + ",cantidad=" + dato.getCantidad() + "where productoid=" + dato.getProducto().getIdProducto() + "and facturaId = " + idFactura;
        try {
            ejecutarQuery(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(DComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(DCompras dato, CCompras factura) {
        try {
            String query = "DELETE PROM DCompras WHERE productoid=" + dato.getProducto().getIdProducto() + "and facturaid=" + factura.getIdFactura();
            ejecutarQuery(crearSentencia(query));
        } catch (Exception ex) {
            Logger.getLogger(DComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DCompras buscarByID(int idProducto, int idFactura) {
        String query = "SELECT * FROM DCOMPRAS WHERE productoid=" + idProducto + "and facturaid=" + idFactura;
        DCompras detalle = new DCompras();
        int idProd = 0;
        try {
            conectar();
            ResultSet rs = consultar(crearSentencia(query));
            while (rs.next()) {
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setImporte(rs.getDouble("precio"));
                idProd = rs.getInt("productoid");
                detalle.setProducto(prodDao.buscarByID(idProd));
            }

        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detalle;
    }

    public Hashtable traeDetalleDeFactura(CCompras cCom) {
        Hashtable hash = new Hashtable();
        String query = "SELECT * FROM DCOMPRAS WHERE facturaid= " + cCom.getIdFactura();
        try {
            conectar();
            ResultSet rs = consultar(crearSentencia(query));
            while (rs.next()) {

                DCompras DC = new DCompras();
                DC.setCantidad(rs.getInt("Cantidad"));
                DC.setImporte(rs.getDouble("importe"));
                int idProducto = rs.getInt("ProductoID");
                Producto p = prodDao.buscarByID(idProducto);
                DC.setProducto(p);
                hash.put(rs.getInt("IDDetalle"), DC);
            }

        } catch (Exception ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return hash;
    }

}


