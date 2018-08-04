/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteEntidad;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author debian
 */
@Entity
@Table(name = "tbl_estado")
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
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(mappedBy = "idEstado")
    private Collection<TblProfesor> tblProfesorCollection;
    @OneToMany(mappedBy = "idEstado")
    private Collection<TblAlumno> tblAlumnoCollection;

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
    public Collection<TblProfesor> getTblProfesorCollection() {
        return tblProfesorCollection;
    }

    public void setTblProfesorCollection(Collection<TblProfesor> tblProfesorCollection) {
        this.tblProfesorCollection = tblProfesorCollection;
    }

    @XmlTransient
    public Collection<TblAlumno> getTblAlumnoCollection() {
        return tblAlumnoCollection;
    }

    public void setTblAlumnoCollection(Collection<TblAlumno> tblAlumnoCollection) {
        this.tblAlumnoCollection = tblAlumnoCollection;
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
        return "PaqueteEntidad.TblEstado[ estado=" + estado + " ]";
    }
    
}
