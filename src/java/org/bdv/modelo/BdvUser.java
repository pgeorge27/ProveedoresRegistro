/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author georgeperez
 */
@Entity
@Table(name = "bdv_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvUser.findAll", query = "SELECT b FROM BdvUser b"),
    @NamedQuery(name = "BdvUser.findByIdUser", query = "SELECT b FROM BdvUser b WHERE b.idUser = :idUser"),
    @NamedQuery(name = "BdvUser.findByEmail", query = "SELECT b FROM BdvUser b WHERE b.email = :email"),
    @NamedQuery(name = "BdvUser.findByContrasenia", query = "SELECT b FROM BdvUser b WHERE b.contrasenia = :contrasenia"),
    @NamedQuery(name = "BdvUser.findByActivo", query = "SELECT b FROM BdvUser b WHERE b.activo = :activo")})
public class BdvUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne
    private BdvEmpresa idEmpresa;

    public BdvUser() {
    }

    public BdvUser(Integer idUser) {
        this.idUser = idUser;
    }

    public BdvUser(Integer idUser, String email, String contrasenia, boolean activo) {
        this.idUser = idUser;
        this.email = email;
        this.contrasenia = contrasenia;
        this.activo = activo;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public BdvEmpresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(BdvEmpresa idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        if (!(object instanceof BdvUser)) {
            return false;
        }
        BdvUser other = (BdvUser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return email;
    }
    
}