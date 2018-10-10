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
@Table(name = "TBL_CENTRO_EDUCATIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCentroEducativo.findAll", query = "SELECT t FROM TblCentroEducativo t")
    , @NamedQuery(name = "TblCentroEducativo.findByCentroEducativo", query = "SELECT t FROM TblCentroEducativo t WHERE t.centroEducativo = :centroEducativo")
    , @NamedQuery(name = "TblCentroEducativo.findByCodigoDepartamental", query = "SELECT t FROM TblCentroEducativo t WHERE t.codigoDepartamental = :codigoDepartamental")
    , @NamedQuery(name = "TblCentroEducativo.findByNombre", query = "SELECT t FROM TblCentroEducativo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblCentroEducativo.findByDireccion", query = "SELECT t FROM TblCentroEducativo t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TblCentroEducativo.findByTelefono", query = "SELECT t FROM TblCentroEducativo t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TblCentroEducativo.findByCorreo", query = "SELECT t FROM TblCentroEducativo t WHERE t.correo = :correo")
    , @NamedQuery(name = "TblCentroEducativo.findByAdministradorEscuela", query = "SELECT t FROM TblCentroEducativo t WHERE t.administradorEscuela = :administradorEscuela")
    , @NamedQuery(name = "TblCentroEducativo.findByCargo", query = "SELECT t FROM TblCentroEducativo t WHERE t.cargo = :cargo")})
public class TblCentroEducativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CENTRO_EDUCATIVO")
    private Integer centroEducativo;
    @Column(name = "CODIGO_DEPARTAMENTAL")
    private String codigoDepartamental;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "ADMINISTRADOR_ESCUELA")
    private String administradorEscuela;
    @Column(name = "CARGO")
    private String cargo;
    @OneToMany(mappedBy = "idCentroEducativo")
    private List<TblAlumno> tblAlumnoList;

    public TblCentroEducativo() {
    }

    public TblCentroEducativo(Integer centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public Integer getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(Integer centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getCodigoDepartamental() {
        return codigoDepartamental;
    }

    public void setCodigoDepartamental(String codigoDepartamental) {
        this.codigoDepartamental = codigoDepartamental;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getAdministradorEscuela() {
        return administradorEscuela;
    }

    public void setAdministradorEscuela(String administradorEscuela) {
        this.administradorEscuela = administradorEscuela;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public List<TblAlumno> getTblAlumnoList() {
        return tblAlumnoList;
    }

    public void setTblAlumnoList(List<TblAlumno> tblAlumnoList) {
        this.tblAlumnoList = tblAlumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centroEducativo != null ? centroEducativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCentroEducativo)) {
            return false;
        }
        TblCentroEducativo other = (TblCentroEducativo) object;
        if ((this.centroEducativo == null && other.centroEducativo != null) || (this.centroEducativo != null && !this.centroEducativo.equals(other.centroEducativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblCentroEducativo[ centroEducativo=" + centroEducativo + " ]";
    }
    
}
