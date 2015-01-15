/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgeperez
 */
@Entity
@Table(name = "bdv_categoria_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvCategoriaProducto.findAll", query = "SELECT b FROM BdvCategoriaProducto b"),
    @NamedQuery(name = "BdvCategoriaProducto.findByIdCategoriaProducto", query = "SELECT b FROM BdvCategoriaProducto b WHERE b.idCategoriaProducto = :idCategoriaProducto"),
    @NamedQuery(name = "BdvCategoriaProducto.findByDescrCategoria", query = "SELECT b FROM BdvCategoriaProducto b WHERE b.descrCategoria = :descrCategoria"),
    @NamedQuery(name = "BdvCategoriaProducto.findByFCreacion", query = "SELECT b FROM BdvCategoriaProducto b WHERE b.fCreacion = :fCreacion"),
    @NamedQuery(name = "BdvCategoriaProducto.findByFDesde", query = "SELECT b FROM BdvCategoriaProducto b WHERE b.fDesde = :fDesde"),
    @NamedQuery(name = "BdvCategoriaProducto.findByFFin", query = "SELECT b FROM BdvCategoriaProducto b WHERE b.fFin = :fFin")})
public class BdvCategoriaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_producto")
    private Integer idCategoriaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_categoria")
    private String descrCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_creacion")
    @Temporal(TemporalType.DATE)
    private Date fCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_desde")
    @Temporal(TemporalType.DATE)
    private Date fDesde;
    @Column(name = "f_fin")
    @Temporal(TemporalType.DATE)
    private Date fFin;
    @ManyToMany(mappedBy = "bdvCategoriaProductoList")
    private List<BdvEmpresa> bdvEmpresaList;

    public BdvCategoriaProducto() {
    }

    public BdvCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public BdvCategoriaProducto(Integer idCategoriaProducto, String descrCategoria, Date fCreacion, Date fDesde) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.descrCategoria = descrCategoria;
        this.fCreacion = fCreacion;
        this.fDesde = fDesde;
    }

    public Integer getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getDescrCategoria() {
        return descrCategoria;
    }

    public void setDescrCategoria(String descrCategoria) {
        this.descrCategoria = descrCategoria;
    }

    public Date getFCreacion() {
        return fCreacion;
    }

    public void setFCreacion(Date fCreacion) {
        this.fCreacion = fCreacion;
    }

    public Date getFDesde() {
        return fDesde;
    }

    public void setFDesde(Date fDesde) {
        this.fDesde = fDesde;
    }

    public Date getFFin() {
        return fFin;
    }

    public void setFFin(Date fFin) {
        this.fFin = fFin;
    }

    @XmlTransient
    public List<BdvEmpresa> getBdvEmpresaList() {
        return bdvEmpresaList;
    }

    public void setBdvEmpresaList(List<BdvEmpresa> bdvEmpresaList) {
        this.bdvEmpresaList = bdvEmpresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaProducto != null ? idCategoriaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvCategoriaProducto)) {
            return false;
        }
        BdvCategoriaProducto other = (BdvCategoriaProducto) object;
        if ((this.idCategoriaProducto == null && other.idCategoriaProducto != null) || (this.idCategoriaProducto != null && !this.idCategoriaProducto.equals(other.idCategoriaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descrCategoria.toUpperCase();
    }
    
}
