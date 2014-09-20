/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author alumno
 */
public class CCompras {
    private int idFactura;
    private Usuario usuario;
    private Date fecha;
    private Hashtable detalle;
    

    /**
     * @return the idFactura
     */
    public int getIdFactura() {
        return idFactura;
    }

    /**
     * @param idFactura the idFactura to set
     */
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Hashtable getDetalle() {
        return detalle;
    }

    public void setDetalle(Hashtable detalle) {
        this.detalle = detalle;
    }
    public Double calcularTotal(){
        Double total=0d;
        Enumeration claves = detalle.keys();
        DCompras dCompras= new DCompras();
        while(claves.hasMoreElements()){
            int clave= (int)claves.nextElement();
            dCompras= (DCompras)detalle.get(clave);
            total= total+(dCompras.getImporte()* dCompras.getCantidad());
        }
        return total;
    }


       
}
