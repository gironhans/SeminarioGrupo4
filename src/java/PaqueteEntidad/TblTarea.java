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
@Table(name = "tbl_tarea")
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
    @Column(name = "tarea")
    private Integer tarea;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_grado", referencedColumnName = "grado_educativo")
    @ManyToOne
    private TblGradoEducativo idGrado;
    @JoinColumn(name = "id_materia", referencedColumnName = "materia")
    @ManyToOne
    private TblMateria idMateria;
    @JoinColumn(name = "id_seccion", referencedColumnName = "seccion")
    @ManyToOne
    private TblSeccion idSeccion;
    @JoinColumn(name = "id_tipo_tarea", referencedColumnName = "tarea_tipo")
    @ManyToOne
    private TblTareaTipo idTipoTarea;
    @JoinColumn(name = "id_unidad", referencedColumnName = "unidad")
    @ManyToOne
    private TblUnidad idUnidad;
    @OneToMany(mappedBy = "idTarea")
    private Collection<TblNota> tblNotaCollection;

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

    public TblGradoEducativo getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(TblGradoEducativo idGrado) {
        this.idGrado = idGrado;
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

    @XmlTransient
    public Collection<TblNota> getTblNotaCollection() {
        return tblNotaCollection;
    }

    public void setTblNotaCollection(Collection<TblNota> tblNotaCollection) {
        this.tblNotaCollection = tblNotaCollection;
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
        return "PaqueteEntidad.TblTarea[ tarea=" + tarea + " ]";
    }
    
}
