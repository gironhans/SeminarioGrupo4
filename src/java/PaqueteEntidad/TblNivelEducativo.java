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
@Table(name = "tbl_nivel_educativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNivelEducativo.findAll", query = "SELECT t FROM TblNivelEducativo t")
    , @NamedQuery(name = "TblNivelEducativo.findByNivelEducativo", query = "SELECT t FROM TblNivelEducativo t WHERE t.nivelEducativo = :nivelEducativo")
    , @NamedQuery(name = "TblNivelEducativo.findByNombre", query = "SELECT t FROM TblNivelEducativo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblNivelEducativo.findByDescripcion", query = "SELECT t FROM TblNivelEducativo t WHERE t.descripcion = :descripcion")})
public class TblNivelEducativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nivel_educativo")
    private Integer nivelEducativo;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idNivelEducativo")
    private Collection<TblGradoEducativo> tblGradoEducativoCollection;

    public TblNivelEducativo() {
    }

    public TblNivelEducativo(Integer nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Integer getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(Integer nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
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

    @XmlTransient
    public Collection<TblGradoEducativo> getTblGradoEducativoCollection() {
        return tblGradoEducativoCollection;
    }

    public void setTblGradoEducativoCollection(Collection<TblGradoEducativo> tblGradoEducativoCollection) {
        this.tblGradoEducativoCollection = tblGradoEducativoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelEducativo != null ? nivelEducativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNivelEducativo)) {
            return false;
        }
        TblNivelEducativo other = (TblNivelEducativo) object;
        if ((this.nivelEducativo == null && other.nivelEducativo != null) || (this.nivelEducativo != null && !this.nivelEducativo.equals(other.nivelEducativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaqueteEntidad.TblNivelEducativo[ nivelEducativo=" + nivelEducativo + " ]";
    }
    
}
