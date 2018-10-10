/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Seminario
 */
@Entity
@Table(name = "TBL_PROFESOR_ASIGNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProfesorAsignacion.findAll", query = "SELECT t FROM TblProfesorAsignacion t")
    , @NamedQuery(name = "TblProfesorAsignacion.findByIdPAsignacion", query = "SELECT t FROM TblProfesorAsignacion t WHERE t.idPAsignacion = :idPAsignacion")})
public class TblProfesorAsignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_P_ASIGNACION")
    private Integer idPAsignacion;
    @JoinColumn(name = "ID_GRADO_EDUCATIVO", referencedColumnName = "GRADO_EDUCATIVO")
    @ManyToOne
    private TblGradoEducativo idGradoEducativo;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "MATERIA")
    @ManyToOne
    private TblMateria idMateria;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "PROFESOR")
    @ManyToOne
    private TblProfesor idProfesor;
    @JoinColumn(name = "ID_SECCION", referencedColumnName = "SECCION")
    @ManyToOne
    private TblSeccion idSeccion;

    public TblProfesorAsignacion() {
    }

    public TblProfesorAsignacion(Integer idPAsignacion) {
        this.idPAsignacion = idPAsignacion;
    }

    public Integer getIdPAsignacion() {
        return idPAsignacion;
    }

    public void setIdPAsignacion(Integer idPAsignacion) {
        this.idPAsignacion = idPAsignacion;
    }

    public TblGradoEducativo getIdGradoEducativo() {
        return idGradoEducativo;
    }

    public void setIdGradoEducativo(TblGradoEducativo idGradoEducativo) {
        this.idGradoEducativo = idGradoEducativo;
    }

    public TblMateria getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(TblMateria idMateria) {
        this.idMateria = idMateria;
    }

    public TblProfesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(TblProfesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public TblSeccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(TblSeccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPAsignacion != null ? idPAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProfesorAsignacion)) {
            return false;
        }
        TblProfesorAsignacion other = (TblProfesorAsignacion) object;
        if ((this.idPAsignacion == null && other.idPAsignacion != null) || (this.idPAsignacion != null && !this.idPAsignacion.equals(other.idPAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblProfesorAsignacion[ idPAsignacion=" + idPAsignacion + " ]";
    }
    
}
