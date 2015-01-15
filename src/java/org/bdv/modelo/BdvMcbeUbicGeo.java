/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgeperez
 */
@Entity
@Table(name = "bdv_mcbe_ubic_geo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvMcbeUbicGeo.findAll", query = "SELECT b FROM BdvMcbeUbicGeo b"),
    @NamedQuery(name = "BdvMcbeUbicGeo.findByIdUbicGeo", query = "SELECT b FROM BdvMcbeUbicGeo b WHERE b.idUbicGeo = :idUbicGeo"),
    @NamedQuery(name = "BdvMcbeUbicGeo.findByDescripcion", query = "SELECT b FROM BdvMcbeUbicGeo b WHERE b.descripcion = :descripcion"),
    @NamedQuery(name = "BdvMcbeUbicGeo.findByNivel", query = "SELECT b FROM BdvMcbeUbicGeo b WHERE b.nivel = :nivel"),
    @NamedQuery(name = "BdvMcbeUbicGeo.findByIdPadre", query = "SELECT b FROM BdvMcbeUbicGeo b WHERE b.idPadre = :idPadre")})
public class BdvMcbeUbicGeo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ubic_geo")
    private Integer idUbicGeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_padre")
    private int idPadre;
    @OneToMany(mappedBy = "municipio")
    private List<BdvEmpresa> bdvEmpresaList;
    @OneToMany(mappedBy = "estado")
    private List<BdvEmpresa> bdvEmpresaList1;
    @OneToMany(mappedBy = "parroquia")
    private List<BdvEmpresa> bdvEmpresaList2;

    public BdvMcbeUbicGeo() {
    }

    public BdvMcbeUbicGeo(Integer idUbicGeo) {
        this.idUbicGeo = idUbicGeo;
    }

    public BdvMcbeUbicGeo(Integer idUbicGeo, String descripcion, int nivel, int idPadre) {
        this.idUbicGeo = idUbicGeo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.idPadre = idPadre;
    }

    public Integer getIdUbicGeo() {
        return idUbicGeo;
    }

    public void setIdUbicGeo(Integer idUbicGeo) {
        this.idUbicGeo = idUbicGeo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    @XmlTransient
    public List<BdvEmpresa> getBdvEmpresaList() {
        return bdvEmpresaList;
    }

    public void setBdvEmpresaList(List<BdvEmpresa> bdvEmpresaList) {
        this.bdvEmpresaList = bdvEmpresaList;
    }

    @XmlTransient
    public List<BdvEmpresa> getBdvEmpresaList1() {
        return bdvEmpresaList1;
    }

    public void setBdvEmpresaList1(List<BdvEmpresa> bdvEmpresaList1) {
        this.bdvEmpresaList1 = bdvEmpresaList1;
    }

    @XmlTransient
    public List<BdvEmpresa> getBdvEmpresaList2() {
        return bdvEmpresaList2;
    }

    public void setBdvEmpresaList2(List<BdvEmpresa> bdvEmpresaList2) {
        this.bdvEmpresaList2 = bdvEmpresaList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicGeo != null ? idUbicGeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvMcbeUbicGeo)) {
            return false;
        }
        BdvMcbeUbicGeo other = (BdvMcbeUbicGeo) object;
        if ((this.idUbicGeo == null && other.idUbicGeo != null) || (this.idUbicGeo != null && !this.idUbicGeo.equals(other.idUbicGeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion.toUpperCase();
    }
    
}
