/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteEntidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author debian
 */
@Entity
@Table(name = "tbl_profesor")
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
    @Column(name = "profesor")
    private Integer profesor;
    @Size(max = 75)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 75)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 20)
    @Column(name = "doc_identificacion")
    private String docIdentificacion;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Size(max = 40)
    @Column(name = "area_docensia")
    private String areaDocensia;
    @JoinColumn(name = "id_estado", referencedColumnName = "estado")
    @ManyToOne
    private TblEstado idEstado;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<TblProfesorAsignacion> tblProfesorAsignacionCollection;

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

    public TblEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public Collection<TblProfesorAsignacion> getTblProfesorAsignacionCollection() {
        return tblProfesorAsignacionCollection;
    }

    public void setTblProfesorAsignacionCollection(Collection<TblProfesorAsignacion> tblProfesorAsignacionCollection) {
        this.tblProfesorAsignacionCollection = tblProfesorAsignacionCollection;
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
        return "PaqueteEntidad.TblProfesor[ profesor=" + profesor + " ]";
    }
    
}
