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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgeperez
 */
@Entity
@Table(name = "bdv_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvContacto.findAll", query = "SELECT b FROM BdvContacto b"),
    @NamedQuery(name = "BdvContacto.findByIdContacto", query = "SELECT b FROM BdvContacto b WHERE b.idContacto = :idContacto"),
    @NamedQuery(name = "BdvContacto.findByPrimerApellido", query = "SELECT b FROM BdvContacto b WHERE b.primerApellido = :primerApellido"),
    @NamedQuery(name = "BdvContacto.findBySegundoApellido", query = "SELECT b FROM BdvContacto b WHERE b.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "BdvContacto.findByPrimerNombre", query = "SELECT b FROM BdvContacto b WHERE b.primerNombre = :primerNombre"),
    @NamedQuery(name = "BdvContacto.findBySegundoNombre", query = "SELECT b FROM BdvContacto b WHERE b.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "BdvContacto.findBySexo", query = "SELECT b FROM BdvContacto b WHERE b.sexo = :sexo"),
    @NamedQuery(name = "BdvContacto.findByDocumentoIdentidad", query = "SELECT b FROM BdvContacto b WHERE b.documentoIdentidad = :documentoIdentidad"),
    @NamedQuery(name = "BdvContacto.findByNumeroIdentidad", query = "SELECT b FROM BdvContacto b WHERE b.numeroIdentidad = :numeroIdentidad"),
    @NamedQuery(name = "BdvContacto.findByCargo", query = "SELECT b FROM BdvContacto b WHERE b.cargo = :cargo"),
    @NamedQuery(name = "BdvContacto.findByAreaOcupacional", query = "SELECT b FROM BdvContacto b WHERE b.areaOcupacional = :areaOcupacional")})
public class BdvContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto")
    private Integer idContacto;
    @Size(max = 100)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 100)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 100)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 100)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 50)
    @Column(name = "documento_identidad")
    private String documentoIdentidad;
    @Size(max = 50)
    @Column(name = "numero_identidad")
    private String numeroIdentidad;
    @Size(max = 100)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 100)
    @Column(name = "area_ocupacional")
    private String areaOcupacional;
    @OneToMany(mappedBy = "idContacto1")
    private List<BdvEmpresa> bdvEmpresaList;
    @OneToMany(mappedBy = "idContacto3")
    private List<BdvEmpresa> bdvEmpresaList1;
    @OneToMany(mappedBy = "idContacto2")
    private List<BdvEmpresa> bdvEmpresaList2;

    public BdvContacto() {
    }

    public BdvContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAreaOcupacional() {
        return areaOcupacional;
    }

    public void setAreaOcupacional(String areaOcupacional) {
        this.areaOcupacional = areaOcupacional;
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
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvContacto)) {
            return false;
        }
        BdvContacto other = (BdvContacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvContacto[ idContacto=" + idContacto + " ]";
    }
    
}
