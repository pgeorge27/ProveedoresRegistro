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
@Table(name = "bdv_bancos_nac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvBancosNac.findAll", query = "SELECT b FROM BdvBancosNac b"),
    @NamedQuery(name = "BdvBancosNac.findByBancoId", query = "SELECT b FROM BdvBancosNac b WHERE b.bancoId = :bancoId"),
    @NamedQuery(name = "BdvBancosNac.findByBancoDescripcion", query = "SELECT b FROM BdvBancosNac b WHERE b.bancoDescripcion = :bancoDescripcion")})
public class BdvBancosNac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "banco_id")
    private Integer bancoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "banco_descripcion")
    private String bancoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanco")
    private List<BdvBancoCuenta> bdvBancoCuentaList;

    public BdvBancosNac() {
    }

    public BdvBancosNac(Integer bancoId) {
        this.bancoId = bancoId;
    }

    public BdvBancosNac(Integer bancoId, String bancoDescripcion) {
        this.bancoId = bancoId;
        this.bancoDescripcion = bancoDescripcion;
    }

    public Integer getBancoId() {
        return bancoId;
    }

    public void setBancoId(Integer bancoId) {
        this.bancoId = bancoId;
    }

    public String getBancoDescripcion() {
        return bancoDescripcion;
    }

    public void setBancoDescripcion(String bancoDescripcion) {
        this.bancoDescripcion = bancoDescripcion;
    }

    @XmlTransient
    public List<BdvBancoCuenta> getBdvBancoCuentaList() {
        return bdvBancoCuentaList;
    }

    public void setBdvBancoCuentaList(List<BdvBancoCuenta> bdvBancoCuentaList) {
        this.bdvBancoCuentaList = bdvBancoCuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bancoId != null ? bancoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvBancosNac)) {
            return false;
        }
        BdvBancosNac other = (BdvBancosNac) object;
        if ((this.bancoId == null && other.bancoId != null) || (this.bancoId != null && !this.bancoId.equals(other.bancoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return bancoDescripcion.toUpperCase();
    }
    
}
