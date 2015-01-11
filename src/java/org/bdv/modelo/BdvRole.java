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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "bdv_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvRole.findAll", query = "SELECT b FROM BdvRole b"),
    @NamedQuery(name = "BdvRole.findByIdRole", query = "SELECT b FROM BdvRole b WHERE b.idRole = :idRole"),
    @NamedQuery(name = "BdvRole.findByRoleNombre", query = "SELECT b FROM BdvRole b WHERE b.roleNombre = :roleNombre")})
public class BdvRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_role")
    private Integer idRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "role_nombre")
    private String roleNombre;
    @ManyToMany(mappedBy = "bdvRoleList")
    private List<BdvUserBackend> bdvUserBackendList;

    public BdvRole() {
    }

    public BdvRole(Integer idRole) {
        this.idRole = idRole;
    }

    public BdvRole(Integer idRole, String roleNombre) {
        this.idRole = idRole;
        this.roleNombre = roleNombre;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleNombre() {
        return roleNombre;
    }

    public void setRoleNombre(String roleNombre) {
        this.roleNombre = roleNombre;
    }

    @XmlTransient
    public List<BdvUserBackend> getBdvUserBackendList() {
        return bdvUserBackendList;
    }

    public void setBdvUserBackendList(List<BdvUserBackend> bdvUserBackendList) {
        this.bdvUserBackendList = bdvUserBackendList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvRole)) {
            return false;
        }
        BdvRole other = (BdvRole) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvRole[ idRole=" + idRole + " ]";
    }
    
}
