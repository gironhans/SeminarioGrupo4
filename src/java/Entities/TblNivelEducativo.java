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
@Table(name = "TBL_NIVEL_EDUCATIVO")
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
    @Column(name = "NIVEL_EDUCATIVO")
    private Integer nivelEducativo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idNivelEducativo")
    private List<TblGradoEducativo> tblGradoEducativoList;

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
    public List<TblGradoEducativo> getTblGradoEducativoList() {
        return tblGradoEducativoList;
    }

    public void setTblGradoEducativoList(List<TblGradoEducativo> tblGradoEducativoList) {
        this.tblGradoEducativoList = tblGradoEducativoList;
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
        return "Entities.TblNivelEducativo[ nivelEducativo=" + nivelEducativo + " ]";
    }
    
}
