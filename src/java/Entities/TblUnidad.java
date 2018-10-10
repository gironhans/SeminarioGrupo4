/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Seminario
 */
@Entity
@Table(name = "TBL_UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUnidad.findAll", query = "SELECT t FROM TblUnidad t")
    , @NamedQuery(name = "TblUnidad.findByUnidad", query = "SELECT t FROM TblUnidad t WHERE t.unidad = :unidad")
    , @NamedQuery(name = "TblUnidad.findByNombre", query = "SELECT t FROM TblUnidad t WHERE t.nombre = :nombre")})
public class TblUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UNIDAD")
    private Integer unidad;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idUnidad")
    private List<TblTarea> tblTareaList;

    public TblUnidad() {
    }

    public TblUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<TblTarea> getTblTareaList() {
        return tblTareaList;
    }

    public void setTblTareaList(List<TblTarea> tblTareaList) {
        this.tblTareaList = tblTareaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidad != null ? unidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUnidad)) {
            return false;
        }
        TblUnidad other = (TblUnidad) object;
        if ((this.unidad == null && other.unidad != null) || (this.unidad != null && !this.unidad.equals(other.unidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblUnidad[ unidad=" + unidad + " ]";
    }
    
}
