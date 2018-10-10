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
@Table(name = "TBL_TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTarea.findAll", query = "SELECT t FROM TblTarea t")
    , @NamedQuery(name = "TblTarea.findByTarea", query = "SELECT t FROM TblTarea t WHERE t.tarea = :tarea")
    , @NamedQuery(name = "TblTarea.findByObservacion", query = "SELECT t FROM TblTarea t WHERE t.observacion = :observacion")})
public class TblTarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TAREA")
    private Integer tarea;
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(mappedBy = "idTarea")
    private List<TblNota> tblNotaList;
    @JoinColumn(name = "ID_GRADO_EDUCATIVO", referencedColumnName = "GRADO_EDUCATIVO")
    @ManyToOne
    private TblGradoEducativo idGradoEducativo;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "MATERIA")
    @ManyToOne
    private TblMateria idMateria;
    @JoinColumn(name = "ID_SECCION", referencedColumnName = "SECCION")
    @ManyToOne
    private TblSeccion idSeccion;
    @JoinColumn(name = "ID_TIPO_TAREA", referencedColumnName = "TAREA_TIPO")
    @ManyToOne
    private TblTareaTipo idTipoTarea;
    @JoinColumn(name = "ID_UNIDAD", referencedColumnName = "UNIDAD")
    @ManyToOne
    private TblUnidad idUnidad;

    public TblTarea() {
    }

    public TblTarea(Integer tarea) {
        this.tarea = tarea;
    }

    public Integer getTarea() {
        return tarea;
    }

    public void setTarea(Integer tarea) {
        this.tarea = tarea;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<TblNota> getTblNotaList() {
        return tblNotaList;
    }

    public void setTblNotaList(List<TblNota> tblNotaList) {
        this.tblNotaList = tblNotaList;
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

    public TblSeccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(TblSeccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    public TblTareaTipo getIdTipoTarea() {
        return idTipoTarea;
    }

    public void setIdTipoTarea(TblTareaTipo idTipoTarea) {
        this.idTipoTarea = idTipoTarea;
    }

    public TblUnidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(TblUnidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarea != null ? tarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTarea)) {
            return false;
        }
        TblTarea other = (TblTarea) object;
        if ((this.tarea == null && other.tarea != null) || (this.tarea != null && !this.tarea.equals(other.tarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblTarea[ tarea=" + tarea + " ]";
    }
    
}
