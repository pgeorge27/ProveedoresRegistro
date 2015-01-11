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
@Table(name = "bdv_banco_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvBancoCuenta.findAll", query = "SELECT b FROM BdvBancoCuenta b"),
    @NamedQuery(name = "BdvBancoCuenta.findByIdBancoCuenta", query = "SELECT b FROM BdvBancoCuenta b WHERE b.idBancoCuenta = :idBancoCuenta"),
    @NamedQuery(name = "BdvBancoCuenta.findByCodigoCuenta", query = "SELECT b FROM BdvBancoCuenta b WHERE b.codigoCuenta = :codigoCuenta"),
    @NamedQuery(name = "BdvBancoCuenta.findByTelefono", query = "SELECT b FROM BdvBancoCuenta b WHERE b.telefono = :telefono")})
public class BdvBancoCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banco_cuenta")
    private Integer idBancoCuenta;
    @Size(max = 20)
    @Column(name = "codigo_cuenta")
    private String codigoCuenta;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "id_banco", referencedColumnName = "banco_id")
    @ManyToOne(optional = false)
    private BdvBancosNac idBanco;
    @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta")
    @ManyToOne(optional = false)
    private BdvTipoCuenta idTipoCuenta;
    @OneToMany(mappedBy = "idBancoCuenta2")
    private List<BdvEmpresa> bdvEmpresaList;
    @OneToMany(mappedBy = "idBancoCuenta1")
    private List<BdvEmpresa> bdvEmpresaList1;
    @OneToMany(mappedBy = "idBancoCuenta3")
    private List<BdvEmpresa> bdvEmpresaList2;

    public BdvBancoCuenta() {
    }

    public BdvBancoCuenta(Integer idBancoCuenta) {
        this.idBancoCuenta = idBancoCuenta;
    }

    public Integer getIdBancoCuenta() {
        return idBancoCuenta;
    }

    public void setIdBancoCuenta(Integer idBancoCuenta) {
        this.idBancoCuenta = idBancoCuenta;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BdvBancosNac getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(BdvBancosNac idBanco) {
        this.idBanco = idBanco;
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
        hash += (idBancoCuenta != null ? idBancoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvBancoCuenta)) {
            return false;
        }
        BdvBancoCuenta other = (BdvBancoCuenta) object;
        if ((this.idBancoCuenta == null && other.idBancoCuenta != null) || (this.idBancoCuenta != null && !this.idBancoCuenta.equals(other.idBancoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvBancoCuenta[ idBancoCuenta=" + idBancoCuenta + " ]";
    }
    
}
