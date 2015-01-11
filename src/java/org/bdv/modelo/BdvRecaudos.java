/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgeperez
 */
@Entity
@Table(name = "bdv_recaudos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvRecaudos.findAll", query = "SELECT b FROM BdvRecaudos b"),
    @NamedQuery(name = "BdvRecaudos.findByIdRecaudos", query = "SELECT b FROM BdvRecaudos b WHERE b.idRecaudos = :idRecaudos"),
    @NamedQuery(name = "BdvRecaudos.findByCertificadoSnc", query = "SELECT b FROM BdvRecaudos b WHERE b.certificadoSnc = :certificadoSnc"),
    @NamedQuery(name = "BdvRecaudos.findByPlanillaRnc", query = "SELECT b FROM BdvRecaudos b WHERE b.planillaRnc = :planillaRnc"),
    @NamedQuery(name = "BdvRecaudos.findByComunicacionRepresentante", query = "SELECT b FROM BdvRecaudos b WHERE b.comunicacionRepresentante = :comunicacionRepresentante"),
    @NamedQuery(name = "BdvRecaudos.findBySolvenciaSso", query = "SELECT b FROM BdvRecaudos b WHERE b.solvenciaSso = :solvenciaSso"),
    @NamedQuery(name = "BdvRecaudos.findBySolvenciaLaboral", query = "SELECT b FROM BdvRecaudos b WHERE b.solvenciaLaboral = :solvenciaLaboral"),
    @NamedQuery(name = "BdvRecaudos.findBySolvenciaInce", query = "SELECT b FROM BdvRecaudos b WHERE b.solvenciaInce = :solvenciaInce"),
    @NamedQuery(name = "BdvRecaudos.findByOrganigrama", query = "SELECT b FROM BdvRecaudos b WHERE b.organigrama = :organigrama"),
    @NamedQuery(name = "BdvRecaudos.findByListaProductos", query = "SELECT b FROM BdvRecaudos b WHERE b.listaProductos = :listaProductos"),
    @NamedQuery(name = "BdvRecaudos.findByReferenciaBancaria", query = "SELECT b FROM BdvRecaudos b WHERE b.referenciaBancaria = :referenciaBancaria"),
    @NamedQuery(name = "BdvRecaudos.findByReferenciaComercial", query = "SELECT b FROM BdvRecaudos b WHERE b.referenciaComercial = :referenciaComercial"),
    @NamedQuery(name = "BdvRecaudos.findByDateRegister", query = "SELECT b FROM BdvRecaudos b WHERE b.dateRegister = :dateRegister"),
    @NamedQuery(name = "BdvRecaudos.findByDateUpdate", query = "SELECT b FROM BdvRecaudos b WHERE b.dateUpdate = :dateUpdate")})
public class BdvRecaudos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recaudos")
    private Integer idRecaudos;
    @Size(max = 255)
    @Column(name = "certificado_snc")
    private String certificadoSnc;
    @Size(max = 255)
    @Column(name = "planilla_rnc")
    private String planillaRnc;
    @Size(max = 255)
    @Column(name = "comunicacion_representante")
    private String comunicacionRepresentante;
    @Size(max = 255)
    @Column(name = "solvencia_sso")
    private String solvenciaSso;
    @Size(max = 255)
    @Column(name = "solvencia_laboral")
    private String solvenciaLaboral;
    @Size(max = 255)
    @Column(name = "solvencia_ince")
    private String solvenciaInce;
    @Size(max = 255)
    @Column(name = "organigrama")
    private String organigrama;
    @Size(max = 255)
    @Column(name = "lista_productos")
    private String listaProductos;
    @Size(max = 255)
    @Column(name = "referencia_bancaria")
    private String referenciaBancaria;
    @Size(max = 255)
    @Column(name = "referencia_comercial")
    private String referenciaComercial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_register")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegister;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @OneToMany(mappedBy = "idRecaudos")
    private List<BdvEmpresa> bdvEmpresaList;

    public BdvRecaudos() {
    }

    public BdvRecaudos(Integer idRecaudos) {
        this.idRecaudos = idRecaudos;
    }

    public BdvRecaudos(Integer idRecaudos, Date dateRegister, Date dateUpdate) {
        this.idRecaudos = idRecaudos;
        this.dateRegister = dateRegister;
        this.dateUpdate = dateUpdate;
    }

    public Integer getIdRecaudos() {
        return idRecaudos;
    }

    public void setIdRecaudos(Integer idRecaudos) {
        this.idRecaudos = idRecaudos;
    }

    public String getCertificadoSnc() {
        return certificadoSnc;
    }

    public void setCertificadoSnc(String certificadoSnc) {
        this.certificadoSnc = certificadoSnc;
    }

    public String getPlanillaRnc() {
        return planillaRnc;
    }

    public void setPlanillaRnc(String planillaRnc) {
        this.planillaRnc = planillaRnc;
    }

    public String getComunicacionRepresentante() {
        return comunicacionRepresentante;
    }

    public void setComunicacionRepresentante(String comunicacionRepresentante) {
        this.comunicacionRepresentante = comunicacionRepresentante;
    }

    public String getSolvenciaSso() {
        return solvenciaSso;
    }

    public void setSolvenciaSso(String solvenciaSso) {
        this.solvenciaSso = solvenciaSso;
    }

    public String getSolvenciaLaboral() {
        return solvenciaLaboral;
    }

    public void setSolvenciaLaboral(String solvenciaLaboral) {
        this.solvenciaLaboral = solvenciaLaboral;
    }

    public String getSolvenciaInce() {
        return solvenciaInce;
    }

    public void setSolvenciaInce(String solvenciaInce) {
        this.solvenciaInce = solvenciaInce;
    }

    public String getOrganigrama() {
        return organigrama;
    }

    public void setOrganigrama(String organigrama) {
        this.organigrama = organigrama;
    }

    public String getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(String listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getReferenciaBancaria() {
        return referenciaBancaria;
    }

    public void setReferenciaBancaria(String referenciaBancaria) {
        this.referenciaBancaria = referenciaBancaria;
    }

    public String getReferenciaComercial() {
        return referenciaComercial;
    }

    public void setReferenciaComercial(String referenciaComercial) {
        this.referenciaComercial = referenciaComercial;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
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
        hash += (idRecaudos != null ? idRecaudos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvRecaudos)) {
            return false;
        }
        BdvRecaudos other = (BdvRecaudos) object;
        if ((this.idRecaudos == null && other.idRecaudos != null) || (this.idRecaudos != null && !this.idRecaudos.equals(other.idRecaudos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvRecaudos[ idRecaudos=" + idRecaudos + " ]";
    }
    
}
