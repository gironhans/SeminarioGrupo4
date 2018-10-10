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
@Table(name = "TBL_TAREA_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTareaTipo.findAll", query = "SELECT t FROM TblTareaTipo t")
    , @NamedQuery(name = "TblTareaTipo.findByTareaTipo", query = "SELECT t FROM TblTareaTipo t WHERE t.tareaTipo = :tareaTipo")
    , @NamedQuery(name = "TblTareaTipo.findByDescripcion", query = "SELECT t FROM TblTareaTipo t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblTareaTipo.findByObservacion", query = "SELECT t FROM TblTareaTipo t WHERE t.observacion = :observacion")})
public class TblTareaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TAREA_TIPO")
    private Integer tareaTipo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(mappedBy = "idTipoTarea")
    private List<TblTarea> tblTareaList;

    public TblTareaTipo() {
    }

    public TblTareaTipo(Integer tareaTipo) {
        this.tareaTipo = tareaTipo;
    }

    public Integer getTareaTipo() {
        return tareaTipo;
    }

    public void setTareaTipo(Integer tareaTipo) {
        this.tareaTipo = tareaTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        hash += (tareaTipo != null ? tareaTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTareaTipo)) {
            return false;
        }
        TblTareaTipo other = (TblTareaTipo) object;
        if ((this.tareaTipo == null && other.tareaTipo != null) || (this.tareaTipo != null && !this.tareaTipo.equals(other.tareaTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblTareaTipo[ tareaTipo=" + tareaTipo + " ]";
    }
    
}
