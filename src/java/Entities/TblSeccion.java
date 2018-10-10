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
@Table(name = "TBL_SECCION")
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
    @Column(name = "SECCION")
    private Integer seccion;
    @Column(name = "LITERAL")
    private String literal;
    @OneToMany(mappedBy = "idSeccion")
    private List<TblProfesorAsignacion> tblProfesorAsignacionList;
    @OneToMany(mappedBy = "idSeccion")
    private List<TblAlumnoAsignacion> tblAlumnoAsignacionList;
    @OneToMany(mappedBy = "idSeccion")
    private List<TblTarea> tblTareaList;

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
    public List<TblProfesorAsignacion> getTblProfesorAsignacionList() {
        return tblProfesorAsignacionList;
    }

    public void setTblProfesorAsignacionList(List<TblProfesorAsignacion> tblProfesorAsignacionList) {
        this.tblProfesorAsignacionList = tblProfesorAsignacionList;
    }

    @XmlTransient
    public List<TblAlumnoAsignacion> getTblAlumnoAsignacionList() {
        return tblAlumnoAsignacionList;
    }

    public void setTblAlumnoAsignacionList(List<TblAlumnoAsignacion> tblAlumnoAsignacionList) {
        this.tblAlumnoAsignacionList = tblAlumnoAsignacionList;
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
        return "Entities.TblSeccion[ seccion=" + seccion + " ]";
    }
    
}
