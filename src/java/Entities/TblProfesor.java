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
@Table(name = "TBL_PROFESOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProfesor.findAll", query = "SELECT t FROM TblProfesor t")
    , @NamedQuery(name = "TblProfesor.findByProfesor", query = "SELECT t FROM TblProfesor t WHERE t.profesor = :profesor")
    , @NamedQuery(name = "TblProfesor.findByNombre", query = "SELECT t FROM TblProfesor t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblProfesor.findByApellido", query = "SELECT t FROM TblProfesor t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "TblProfesor.findByFechaNacimiento", query = "SELECT t FROM TblProfesor t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblProfesor.findByDocIdentificacion", query = "SELECT t FROM TblProfesor t WHERE t.docIdentificacion = :docIdentificacion")
    , @NamedQuery(name = "TblProfesor.findByTelefono", query = "SELECT t FROM TblProfesor t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TblProfesor.findByCorreo", query = "SELECT t FROM TblProfesor t WHERE t.correo = :correo")
    , @NamedQuery(name = "TblProfesor.findByAreaDocensia", query = "SELECT t FROM TblProfesor t WHERE t.areaDocensia = :areaDocensia")})
public class TblProfesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROFESOR")
    private Integer profesor;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "DOC_IDENTIFICACION")
    private String docIdentificacion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "AREA_DOCENSIA")
    private String areaDocensia;
    @OneToMany(mappedBy = "idProfesor")
    private List<TblProfesorAsignacion> tblProfesorAsignacionList;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ESTADO")
    @ManyToOne
    private TblEstado idEstado;

    public TblProfesor() {
    }

    public TblProfesor(Integer profesor) {
        this.profesor = profesor;
    }

    public Integer getProfesor() {
        return profesor;
    }

    public void setProfesor(Integer profesor) {
        this.profesor = profesor;
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

    public String getDocIdentificacion() {
        return docIdentificacion;
    }

    public void setDocIdentificacion(String docIdentificacion) {
        this.docIdentificacion = docIdentificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAreaDocensia() {
        return areaDocensia;
    }

    public void setAreaDocensia(String areaDocensia) {
        this.areaDocensia = areaDocensia;
    }

    @XmlTransient
    public List<TblProfesorAsignacion> getTblProfesorAsignacionList() {
        return tblProfesorAsignacionList;
    }

    public void setTblProfesorAsignacionList(List<TblProfesorAsignacion> tblProfesorAsignacionList) {
        this.tblProfesorAsignacionList = tblProfesorAsignacionList;
    }

    public TblEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesor != null ? profesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProfesor)) {
            return false;
        }
        TblProfesor other = (TblProfesor) object;
        if ((this.profesor == null && other.profesor != null) || (this.profesor != null && !this.profesor.equals(other.profesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblProfesor[ profesor=" + profesor + " ]";
    }
    
}
