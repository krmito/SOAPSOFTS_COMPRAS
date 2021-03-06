package Model;
// Generated Nov 23, 2017 10:28:39 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbOrdenCompra generated by hbm2java
 */
public class TbOrdenCompra  implements java.io.Serializable {


     private int id;
     private TbProveedor tbProveedor;
     private int creadorPor;
     private Date creadoEn;
     private String modificadoPor;
     private Date modificadoEn;
     private String observacion;
     private Set tbDetalleOrdenCompras = new HashSet(0);

    public TbOrdenCompra() {
    }

	
    public TbOrdenCompra(int id, TbProveedor tbProveedor, int creadorPor, Date creadoEn) {
        this.id = id;
        this.tbProveedor = tbProveedor;
        this.creadorPor = creadorPor;
        this.creadoEn = creadoEn;
    }
    public TbOrdenCompra(int id, TbProveedor tbProveedor, int creadorPor, Date creadoEn, String modificadoPor, Date modificadoEn, String observacion, Set tbDetalleOrdenCompras) {
       this.id = id;
       this.tbProveedor = tbProveedor;
       this.creadorPor = creadorPor;
       this.creadoEn = creadoEn;
       this.modificadoPor = modificadoPor;
       this.modificadoEn = modificadoEn;
       this.observacion = observacion;
       this.tbDetalleOrdenCompras = tbDetalleOrdenCompras;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public TbProveedor getTbProveedor() {
        return this.tbProveedor;
    }
    
    public void setTbProveedor(TbProveedor tbProveedor) {
        this.tbProveedor = tbProveedor;
    }
    public int getCreadorPor() {
        return this.creadorPor;
    }
    
    public void setCreadorPor(int creadorPor) {
        this.creadorPor = creadorPor;
    }
    public Date getCreadoEn() {
        return this.creadoEn;
    }
    
    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }
    public String getModificadoPor() {
        return this.modificadoPor;
    }
    
    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }
    public Date getModificadoEn() {
        return this.modificadoEn;
    }
    
    public void setModificadoEn(Date modificadoEn) {
        this.modificadoEn = modificadoEn;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Set getTbDetalleOrdenCompras() {
        return this.tbDetalleOrdenCompras;
    }
    
    public void setTbDetalleOrdenCompras(Set tbDetalleOrdenCompras) {
        this.tbDetalleOrdenCompras = tbDetalleOrdenCompras;
    }




}


