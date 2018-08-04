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
@Table(name = "tbl_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMateria.findAll", query = "SELECT t FROM TblMateria t")
    , @NamedQuery(name = "TblMateria.findByMateria", query = "SELECT t FROM TblMateria t WHERE t.materia = :materia")
    , @NamedQuery(name = "TblMateria.findByNombre", query = "SELECT t FROM TblMateria t WHERE t.nombre = :nombre")})
public class TblMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "materia")
    private Integer materia;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idMateria")
    private Collection<TblTarea> tblTareaCollection;
    @OneToMany(mappedBy = "idMateria")
    private Collection<TblProfesorAsignacion> tblProfesorAsignacionCollection;

    public TblMateria() {
    }

    public TblMateria(Integer materia) {
        this.materia = materia;
    }

    public Integer getMateria() {
        return materia;
    }

    public void setMateria(Integer materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materia != null ? materia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMateria)) {
            return false;
        }
        TblMateria other = (TblMateria) object;
        if ((this.materia == null && other.materia != null) || (this.materia != null && !this.materia.equals(other.materia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaqueteEntidad.TblMateria[ materia=" + materia + " ]";
    }
    
}
