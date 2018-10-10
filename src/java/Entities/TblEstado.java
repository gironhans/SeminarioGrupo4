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
@Table(name = "TBL_ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstado.findAll", query = "SELECT t FROM TblEstado t")
    , @NamedQuery(name = "TblEstado.findByEstado", query = "SELECT t FROM TblEstado t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblEstado.findByDescripcion", query = "SELECT t FROM TblEstado t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblEstado.findByObservacion", query = "SELECT t FROM TblEstado t WHERE t.observacion = :observacion")})
public class TblEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private Integer estado;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(mappedBy = "idEstado")
    private List<TblAlumno> tblAlumnoList;
    @OneToMany(mappedBy = "idEstado")
    private List<TblProfesor> tblProfesorList;

    public TblEstado() {
    }

    public TblEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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
    public List<TblAlumno> getTblAlumnoList() {
        return tblAlumnoList;
    }

    public void setTblAlumnoList(List<TblAlumno> tblAlumnoList) {
        this.tblAlumnoList = tblAlumnoList;
    }

    @XmlTransient
    public List<TblProfesor> getTblProfesorList() {
        return tblProfesorList;
    }

    public void setTblProfesorList(List<TblProfesor> tblProfesorList) {
        this.tblProfesorList = tblProfesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estado != null ? estado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstado)) {
            return false;
        }
        TblEstado other = (TblEstado) object;
        if ((this.estado == null && other.estado != null) || (this.estado != null && !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblEstado[ estado=" + estado + " ]";
    }
    
}
