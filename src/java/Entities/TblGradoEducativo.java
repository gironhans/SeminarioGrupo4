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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_GRADO_EDUCATIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGradoEducativo.findAll", query = "SELECT t FROM TblGradoEducativo t")
    , @NamedQuery(name = "TblGradoEducativo.findByGradoEducativo", query = "SELECT t FROM TblGradoEducativo t WHERE t.gradoEducativo = :gradoEducativo")
    , @NamedQuery(name = "TblGradoEducativo.findByNombre", query = "SELECT t FROM TblGradoEducativo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblGradoEducativo.findByDescripcion", query = "SELECT t FROM TblGradoEducativo t WHERE t.descripcion = :descripcion")})
public class TblGradoEducativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRADO_EDUCATIVO")
    private Integer gradoEducativo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_NIVEL_EDUCATIVO", referencedColumnName = "NIVEL_EDUCATIVO")
    @ManyToOne
    private TblNivelEducativo idNivelEducativo;
    @OneToMany(mappedBy = "idGradoEducativo")
    private List<TblProfesorAsignacion> tblProfesorAsignacionList;
    @OneToMany(mappedBy = "idGradoEducativo")
    private List<TblAlumnoAsignacion> tblAlumnoAsignacionList;
    @OneToMany(mappedBy = "idGradoEducativo")
    private List<TblTarea> tblTareaList;

    public TblGradoEducativo() {
    }

    public TblGradoEducativo(Integer gradoEducativo) {
        this.gradoEducativo = gradoEducativo;
    }

    public Integer getGradoEducativo() {
        return gradoEducativo;
    }

    public void setGradoEducativo(Integer gradoEducativo) {
        this.gradoEducativo = gradoEducativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TblNivelEducativo getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(TblNivelEducativo idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
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
        hash += (gradoEducativo != null ? gradoEducativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGradoEducativo)) {
            return false;
        }
        TblGradoEducativo other = (TblGradoEducativo) object;
        if ((this.gradoEducativo == null && other.gradoEducativo != null) || (this.gradoEducativo != null && !this.gradoEducativo.equals(other.gradoEducativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblGradoEducativo[ gradoEducativo=" + gradoEducativo + " ]";
    }
    
}
