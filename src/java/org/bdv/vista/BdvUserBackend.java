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
import javax.persistence.JoinTable;
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
@Table(name = "bdv_user_backend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvUserBackend.findAll", query = "SELECT b FROM BdvUserBackend b"),
    @NamedQuery(name = "BdvUserBackend.findByIdUser", query = "SELECT b FROM BdvUserBackend b WHERE b.idUser = :idUser"),
    @NamedQuery(name = "BdvUserBackend.findByUserBackend", query = "SELECT b FROM BdvUserBackend b WHERE b.userBackend = :userBackend"),
    @NamedQuery(name = "BdvUserBackend.findByPassword", query = "SELECT b FROM BdvUserBackend b WHERE b.password = :password"),
    @NamedQuery(name = "BdvUserBackend.findByStatus", query = "SELECT b FROM BdvUserBackend b WHERE b.status = :status")})
public class BdvUserBackend implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userBackend")
    private String userBackend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinTable(name = "bdv_user_roles", joinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")}, inverseJoinColumns = {
        @JoinColumn(name = "id_role", referencedColumnName = "id_role")})
    @ManyToMany
    private List<BdvRole> bdvRoleList;

    public BdvUserBackend() {
    }

    public BdvUserBackend(Integer idUser) {
        this.idUser = idUser;
    }

    public BdvUserBackend(Integer idUser, String userBackend, String password, boolean status) {
        this.idUser = idUser;
        this.userBackend = userBackend;
        this.password = password;
        this.status = status;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserBackend() {
        return userBackend;
    }

    public void setUserBackend(String userBackend) {
        this.userBackend = userBackend;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<BdvRole> getBdvRoleList() {
        return bdvRoleList;
    }

    public void setBdvRoleList(List<BdvRole> bdvRoleList) {
        this.bdvRoleList = bdvRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvUserBackend)) {
            return false;
        }
        BdvUserBackend other = (BdvUserBackend) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvUserBackend[ idUser=" + idUser + " ]";
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
