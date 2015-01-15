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
@Table(name = "bdv_sector_gremio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvSectorGremio.findAll", query = "SELECT b FROM BdvSectorGremio b"),
    @NamedQuery(name = "BdvSectorGremio.findByIdSeector", query = "SELECT b FROM BdvSectorGremio b WHERE b.idSeector = :idSeector"),
    @NamedQuery(name = "BdvSectorGremio.findByDescripcion", query = "SELECT b FROM BdvSectorGremio b WHERE b.descripcion = :descripcion")})
public class BdvSectorGremio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seector")
    private Integer idSeector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idSector")
    private List<BdvEmpresa> bdvEmpresaList;

    public BdvSectorGremio() {
    }

    public BdvSectorGremio(Integer idSeector) {
        this.idSeector = idSeector;
    }

    public BdvSectorGremio(Integer idSeector, String descripcion) {
        this.idSeector = idSeector;
        this.descripcion = descripcion;
    }

    public Integer getIdSeector() {
        return idSeector;
    }

    public void setIdSeector(Integer idSeector) {
        this.idSeector = idSeector;
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
        hash += (idSeector != null ? idSeector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvSectorGremio)) {
            return false;
        }
        BdvSectorGremio other = (BdvSectorGremio) object;
        if ((this.idSeector == null && other.idSeector != null) || (this.idSeector != null && !this.idSeector.equals(other.idSeector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion.toUpperCase();
    }
    
}
