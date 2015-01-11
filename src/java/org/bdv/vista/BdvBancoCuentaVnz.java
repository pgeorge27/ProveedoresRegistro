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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgeperez
 */
@Entity
@Table(name = "bdv_banco_cuenta_vnz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvBancoCuentaVnz.findAll", query = "SELECT b FROM BdvBancoCuentaVnz b"),
    @NamedQuery(name = "BdvBancoCuentaVnz.findByIdBancoCuentaVnz", query = "SELECT b FROM BdvBancoCuentaVnz b WHERE b.idBancoCuentaVnz = :idBancoCuentaVnz"),
    @NamedQuery(name = "BdvBancoCuentaVnz.findByCodigoCuenta", query = "SELECT b FROM BdvBancoCuentaVnz b WHERE b.codigoCuenta = :codigoCuenta")})
public class BdvBancoCuentaVnz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banco_cuenta_vnz")
    private Integer idBancoCuentaVnz;
    @Size(max = 20)
    @Column(name = "codigo_cuenta")
    private String codigoCuenta;
    @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta")
    @ManyToOne(optional = false)
    private BdvTipoCuenta idTipoCuenta;
    @OneToMany(mappedBy = "idBancoCuentaVnz1")
    private List<BdvEmpresa> bdvEmpresaList;
    @OneToMany(mappedBy = "idBancoCuentaVnz2")
    private List<BdvEmpresa> bdvEmpresaList1;

    public BdvBancoCuentaVnz() {
    }

    public BdvBancoCuentaVnz(Integer idBancoCuentaVnz) {
        this.idBancoCuentaVnz = idBancoCuentaVnz;
    }

    public Integer getIdBancoCuentaVnz() {
        return idBancoCuentaVnz;
    }

    public void setIdBancoCuentaVnz(Integer idBancoCuentaVnz) {
        this.idBancoCuentaVnz = idBancoCuentaVnz;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public BdvTipoCuenta getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(BdvTipoCuenta idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBancoCuentaVnz != null ? idBancoCuentaVnz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvBancoCuentaVnz)) {
            return false;
        }
        BdvBancoCuentaVnz other = (BdvBancoCuentaVnz) object;
        if ((this.idBancoCuentaVnz == null && other.idBancoCuentaVnz != null) || (this.idBancoCuentaVnz != null && !this.idBancoCuentaVnz.equals(other.idBancoCuentaVnz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvBancoCuentaVnz[ idBancoCuentaVnz=" + idBancoCuentaVnz + " ]";
    }
    
}
