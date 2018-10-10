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
@Table(name = "TBL_MATERIA")
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
    @Column(name = "MATERIA")
    private Integer materia;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idMateria")
    private List<TblProfesorAsignacion> tblProfesorAsignacionList;
    @OneToMany(mappedBy = "idMateria")
    private List<TblTarea> tblTareaList;

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
    public List<TblProfesorAsignacion> getTblProfesorAsignacionList() {
        return tblProfesorAsignacionList;
    }

    public void setTblProfesorAsignacionList(List<TblProfesorAsignacion> tblProfesorAsignacionList) {
        this.tblProfesorAsignacionList = tblProfesorAsignacionList;
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
        return "Entities.TblMateria[ materia=" + materia + " ]";
    }
    
}
