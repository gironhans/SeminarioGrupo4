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
@Table(name = "tbl_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSeccion.findAll", query = "SELECT t FROM TblSeccion t")
    , @NamedQuery(name = "TblSeccion.findBySeccion", query = "SELECT t FROM TblSeccion t WHERE t.seccion = :seccion")
    , @NamedQuery(name = "TblSeccion.findByLiteral", query = "SELECT t FROM TblSeccion t WHERE t.literal = :literal")})
public class TblSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seccion")
    private Integer seccion;
    @Size(max = 2)
    @Column(name = "literal")
    private String literal;
    @OneToMany(mappedBy = "idSeccion")
    private Collection<TblTarea> tblTareaCollection;
    @OneToMany(mappedBy = "idSeccion")
    private Collection<TblProfesorAsignacion> tblProfesorAsignacionCollection;
    @OneToMany(mappedBy = "idSeccion")
    private Collection<TblAlumnoAsignacion> tblAlumnoAsignacionCollection;

    public TblSeccion() {
    }

    public TblSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    public Integer getSeccion() {
        return seccion;
    }

    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    @XmlTransient
    public Collection<TblTarea> getTblTareaCollection() {
        return tblTareaCollection;
    }

    public void setTblTareaCollection(Collection<TblTarea> tblTareaCollection) {
        this.tblTareaCollection = tblTareaCollection;
    }

    @XmlTransient
    public Collection<TblProfesorAsignacion> getTblProfesorAsignacionCollection() {
        return tblProfesorAsignacionCollection;
    }

    public void setTblProfesorAsignacionCollection(Collection<TblProfesorAsignacion> tblProfesorAsignacionCollection) {
        this.tblProfesorAsignacionCollection = tblProfesorAsignacionCollection;
    }

    @XmlTransient
    public Collection<TblAlumnoAsignacion> getTblAlumnoAsignacionCollection() {
        return tblAlumnoAsignacionCollection;
    }

    public void setTblAlumnoAsignacionCollection(Collection<TblAlumnoAsignacion> tblAlumnoAsignacionCollection) {
        this.tblAlumnoAsignacionCollection = tblAlumnoAsignacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seccion != null ? seccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSeccion)) {
            return false;
        }
        TblSeccion other = (TblSeccion) object;
        if ((this.seccion == null && other.seccion != null) || (this.seccion != null && !this.seccion.equals(other.seccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaqueteEntidad.TblSeccion[ seccion=" + seccion + " ]";
    }
    
}
