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
@Table(name = "bdv_naturaleza_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvNaturalezaCliente.findAll", query = "SELECT b FROM BdvNaturalezaCliente b"),
    @NamedQuery(name = "BdvNaturalezaCliente.findByIdNaturalezaCliente", query = "SELECT b FROM BdvNaturalezaCliente b WHERE b.idNaturalezaCliente = :idNaturalezaCliente"),
    @NamedQuery(name = "BdvNaturalezaCliente.findByDescripcion", query = "SELECT b FROM BdvNaturalezaCliente b WHERE b.descripcion = :descripcion")})
public class BdvNaturalezaCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_naturaleza_cliente")
    private Integer idNaturalezaCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idNaturalezaCliente")
    private List<BdvEmpresa> bdvEmpresaList;

    public BdvNaturalezaCliente() {
    }

    public BdvNaturalezaCliente(Integer idNaturalezaCliente) {
        this.idNaturalezaCliente = idNaturalezaCliente;
    }

    public BdvNaturalezaCliente(Integer idNaturalezaCliente, String descripcion) {
        this.idNaturalezaCliente = idNaturalezaCliente;
        this.descripcion = descripcion;
    }

    public Integer getIdNaturalezaCliente() {
        return idNaturalezaCliente;
    }

    public void setIdNaturalezaCliente(Integer idNaturalezaCliente) {
        this.idNaturalezaCliente = idNaturalezaCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idNaturalezaCliente != null ? idNaturalezaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvNaturalezaCliente)) {
            return false;
        }
        BdvNaturalezaCliente other = (BdvNaturalezaCliente) object;
        if ((this.idNaturalezaCliente == null && other.idNaturalezaCliente != null) || (this.idNaturalezaCliente != null && !this.idNaturalezaCliente.equals(other.idNaturalezaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvNaturalezaCliente[ idNaturalezaCliente=" + idNaturalezaCliente + " ]";
    }
    
}
