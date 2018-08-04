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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_grado_educativo")
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
    @Column(name = "grado_educativo")
    private Integer gradoEducativo;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_nivel_educativo", referencedColumnName = "nivel_educativo")
    @ManyToOne
    private TblNivelEducativo idNivelEducativo;
    @OneToMany(mappedBy = "idGrado")
    private Collection<TblTarea> tblTareaCollection;
    @OneToMany(mappedBy = "idGrado")
    private Collection<TblProfesorAsignacion> tblProfesorAsignacionCollection;
    @OneToMany(mappedBy = "idGrado")
    private Collection<TblAlumnoAsignacion> tblAlumnoAsignacionCollection;

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
        return "PaqueteEntidad.TblGradoEducativo[ gradoEducativo=" + gradoEducativo + " ]";
    }
    
}
