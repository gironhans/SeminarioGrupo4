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
@Table(name = "TBL_NOTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNota.findAll", query = "SELECT t FROM TblNota t")
    , @NamedQuery(name = "TblNota.findByNota", query = "SELECT t FROM TblNota t WHERE t.nota = :nota")
    , @NamedQuery(name = "TblNota.findByObservacion", query = "SELECT t FROM TblNota t WHERE t.observacion = :observacion")})
public class TblNota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NOTA")
    private Integer nota;
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "ID_YYYY", referencedColumnName = "YYYY")
    @ManyToOne(optional = false)
    private TblYyyy idYyyy;
    @JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ALUMNO")
    @ManyToOne
    private TblAlumno idAlumno;
    @JoinColumn(name = "ID_TAREA", referencedColumnName = "TAREA")
    @ManyToOne
    private TblTarea idTarea;

    public TblNota() {
    }

    public TblNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TblYyyy getIdYyyy() {
        return idYyyy;
    }

    public void setIdYyyy(TblYyyy idYyyy) {
        this.idYyyy = idYyyy;
    }

    public TblAlumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(TblAlumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public TblTarea getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(TblTarea idTarea) {
        this.idTarea = idTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nota != null ? nota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNota)) {
            return false;
        }
        TblNota other = (TblNota) object;
        if ((this.nota == null && other.nota != null) || (this.nota != null && !this.nota.equals(other.nota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblNota[ nota=" + nota + " ]";
    }
    
}
