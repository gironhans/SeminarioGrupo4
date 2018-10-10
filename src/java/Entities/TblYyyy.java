/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "TBL_YYYY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblYyyy.findAll", query = "SELECT t FROM TblYyyy t")
    , @NamedQuery(name = "TblYyyy.findByYyyy", query = "SELECT t FROM TblYyyy t WHERE t.yyyy = :yyyy")
    , @NamedQuery(name = "TblYyyy.findByAnual", query = "SELECT t FROM TblYyyy t WHERE t.anual = :anual")
    , @NamedQuery(name = "TblYyyy.findBySleccion", query = "SELECT t FROM TblYyyy t WHERE t.sleccion = :sleccion")})
public class TblYyyy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "YYYY")
    private Integer yyyy;
    @Basic(optional = false)
    @Column(name = "ANUAL")
    private int anual;
    @Basic(optional = false)
    @Column(name = "SLECCION")
    private int sleccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idYyyy")
    private List<TblNota> tblNotaList;

    public TblYyyy() {
    }

    public TblYyyy(Integer yyyy) {
        this.yyyy = yyyy;
    }

    public TblYyyy(Integer yyyy, int anual, int sleccion) {
        this.yyyy = yyyy;
        this.anual = anual;
        this.sleccion = sleccion;
    }

    public Integer getYyyy() {
        return yyyy;
    }

    public void setYyyy(Integer yyyy) {
        this.yyyy = yyyy;
    }

    public int getAnual() {
        return anual;
    }

    public void setAnual(int anual) {
        this.anual = anual;
    }

    public int getSleccion() {
        return sleccion;
    }

    public void setSleccion(int sleccion) {
        this.sleccion = sleccion;
    }

    @XmlTransient
    public List<TblNota> getTblNotaList() {
        return tblNotaList;
    }

    public void setTblNotaList(List<TblNota> tblNotaList) {
        this.tblNotaList = tblNotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yyyy != null ? yyyy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblYyyy)) {
            return false;
        }
        TblYyyy other = (TblYyyy) object;
        if ((this.yyyy == null && other.yyyy != null) || (this.yyyy != null && !this.yyyy.equals(other.yyyy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblYyyy[ yyyy=" + yyyy + " ]";
    }
    
}
