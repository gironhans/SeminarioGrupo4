/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Seminario
 */
@Entity
@Table(name = "TBL_ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAlumno.findAll", query = "SELECT t FROM TblAlumno t")
    , @NamedQuery(name = "TblAlumno.findByAlumno", query = "SELECT t FROM TblAlumno t WHERE t.alumno = :alumno")
    , @NamedQuery(name = "TblAlumno.findByNombre", query = "SELECT t FROM TblAlumno t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblAlumno.findByApellido", query = "SELECT t FROM TblAlumno t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "TblAlumno.findByFechaNacimiento", query = "SELECT t FROM TblAlumno t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblAlumno.findByNombreEncargado", query = "SELECT t FROM TblAlumno t WHERE t.nombreEncargado = :nombreEncargado")
    , @NamedQuery(name = "TblAlumno.findByTelefonoEncargado", query = "SELECT t FROM TblAlumno t WHERE t.telefonoEncargado = :telefonoEncargado")})
public class TblAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALUMNO")
    private Integer alumno;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "NOMBRE_ENCARGADO")
    private String nombreEncargado;
    @Column(name = "TELEFONO_ENCARGADO")
    private String telefonoEncargado;
    @OneToMany(mappedBy = "idAlumno")
    private List<TblNota> tblNotaList;
    @JoinColumn(name = "ID_CENTRO_EDUCATIVO", referencedColumnName = "CENTRO_EDUCATIVO")
    @ManyToOne
    private TblCentroEducativo idCentroEducativo;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ESTADO")
    @ManyToOne
    private TblEstado idEstado;
    @OneToMany(mappedBy = "idAlumno")
    private List<TblAlumnoAsignacion> tblAlumnoAsignacionList;

    public TblAlumno() {
    }

    public TblAlumno(Integer alumno) {
        this.alumno = alumno;
    }

    public Integer getAlumno() {
        return alumno;
    }

    public void setAlumno(Integer alumno) {
        this.alumno = alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    @XmlTransient
    public List<TblNota> getTblNotaList() {
        return tblNotaList;
    }

    public void setTblNotaList(List<TblNota> tblNotaList) {
        this.tblNotaList = tblNotaList;
    }

    public TblCentroEducativo getIdCentroEducativo() {
        return idCentroEducativo;
    }

    public void setIdCentroEducativo(TblCentroEducativo idCentroEducativo) {
        this.idCentroEducativo = idCentroEducativo;
    }

    public TblEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<TblAlumnoAsignacion> getTblAlumnoAsignacionList() {
        return tblAlumnoAsignacionList;
    }

    public void setTblAlumnoAsignacionList(List<TblAlumnoAsignacion> tblAlumnoAsignacionList) {
        this.tblAlumnoAsignacionList = tblAlumnoAsignacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumno != null ? alumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAlumno)) {
            return false;
        }
        TblAlumno other = (TblAlumno) object;
        if ((this.alumno == null && other.alumno != null) || (this.alumno != null && !this.alumno.equals(other.alumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblAlumno[ alumno=" + alumno + " ]";
    }
    
}
