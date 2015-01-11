/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "bdv_tipo_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvTipoCuenta.findAll", query = "SELECT b FROM BdvTipoCuenta b"),
    @NamedQuery(name = "BdvTipoCuenta.findByIdTipoCuenta", query = "SELECT b FROM BdvTipoCuenta b WHERE b.idTipoCuenta = :idTipoCuenta"),
    @NamedQuery(name = "BdvTipoCuenta.findByDescripcion", query = "SELECT b FROM BdvTipoCuenta b WHERE b.descripcion = :descripcion")})
public class BdvTipoCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cuenta")
    private Integer idTipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCuenta")
    private List<BdvBancoCuenta> bdvBancoCuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCuenta")
    private List<BdvBancoCuentaVnz> bdvBancoCuentaVnzList;

    public BdvTipoCuenta() {
    }

    public BdvTipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public BdvTipoCuenta(Integer idTipoCuenta, String descripcion) {
        this.idTipoCuenta = idTipoCuenta;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<BdvBancoCuenta> getBdvBancoCuentaList() {
        return bdvBancoCuentaList;
    }

    public void setBdvBancoCuentaList(List<BdvBancoCuenta> bdvBancoCuentaList) {
        this.bdvBancoCuentaList = bdvBancoCuentaList;
    }

    @XmlTransient
    public List<BdvBancoCuentaVnz> getBdvBancoCuentaVnzList() {
        return bdvBancoCuentaVnzList;
    }

    public void setBdvBancoCuentaVnzList(List<BdvBancoCuentaVnz> bdvBancoCuentaVnzList) {
        this.bdvBancoCuentaVnzList = bdvBancoCuentaVnzList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCuenta != null ? idTipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvTipoCuenta)) {
            return false;
        }
        BdvTipoCuenta other = (BdvTipoCuenta) object;
        if ((this.idTipoCuenta == null && other.idTipoCuenta != null) || (this.idTipoCuenta != null && !this.idTipoCuenta.equals(other.idTipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvTipoCuenta[ idTipoCuenta=" + idTipoCuenta + " ]";
    }
    
}
