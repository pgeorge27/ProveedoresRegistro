/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
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
@Table(name = "bdv_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BdvEmpresa.findAll", query = "SELECT b FROM BdvEmpresa b"),
    @NamedQuery(name = "BdvEmpresa.findByIdEmpresa", query = "SELECT b FROM BdvEmpresa b WHERE b.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "BdvEmpresa.findByTipoPersona", query = "SELECT b FROM BdvEmpresa b WHERE b.tipoPersona = :tipoPersona"),
    @NamedQuery(name = "BdvEmpresa.findByOrigen", query = "SELECT b FROM BdvEmpresa b WHERE b.origen = :origen"),
    @NamedQuery(name = "BdvEmpresa.findByEnte", query = "SELECT b FROM BdvEmpresa b WHERE b.ente = :ente"),
    @NamedQuery(name = "BdvEmpresa.findByTipoRif", query = "SELECT b FROM BdvEmpresa b WHERE b.tipoRif = :tipoRif"),
    @NamedQuery(name = "BdvEmpresa.findByRif", query = "SELECT b FROM BdvEmpresa b WHERE b.rif = :rif"),
    @NamedQuery(name = "BdvEmpresa.findByRazonSocial", query = "SELECT b FROM BdvEmpresa b WHERE b.razonSocial = :razonSocial"),
    @NamedQuery(name = "BdvEmpresa.findByNombreComercial", query = "SELECT b FROM BdvEmpresa b WHERE b.nombreComercial = :nombreComercial"),
    @NamedQuery(name = "BdvEmpresa.findByPaginaWeb", query = "SELECT b FROM BdvEmpresa b WHERE b.paginaWeb = :paginaWeb"),
    @NamedQuery(name = "BdvEmpresa.findByAnioInicioActividades", query = "SELECT b FROM BdvEmpresa b WHERE b.anioInicioActividades = :anioInicioActividades"),
    @NamedQuery(name = "BdvEmpresa.findByDomicilioTributario", query = "SELECT b FROM BdvEmpresa b WHERE b.domicilioTributario = :domicilioTributario"),
    @NamedQuery(name = "BdvEmpresa.findByInterseccionReferencia", query = "SELECT b FROM BdvEmpresa b WHERE b.interseccionReferencia = :interseccionReferencia"),
    @NamedQuery(name = "BdvEmpresa.findByNumero", query = "SELECT b FROM BdvEmpresa b WHERE b.numero = :numero"),
    @NamedQuery(name = "BdvEmpresa.findByEdificioReferencia", query = "SELECT b FROM BdvEmpresa b WHERE b.edificioReferencia = :edificioReferencia"),
    @NamedQuery(name = "BdvEmpresa.findByDepartamentoOficina", query = "SELECT b FROM BdvEmpresa b WHERE b.departamentoOficina = :departamentoOficina"),
    @NamedQuery(name = "BdvEmpresa.findByPais", query = "SELECT b FROM BdvEmpresa b WHERE b.pais = :pais"),
    @NamedQuery(name = "BdvEmpresa.findByTlfOficina", query = "SELECT b FROM BdvEmpresa b WHERE b.tlfOficina = :tlfOficina"),
    @NamedQuery(name = "BdvEmpresa.findByTlfCelular", query = "SELECT b FROM BdvEmpresa b WHERE b.tlfCelular = :tlfCelular"),
    @NamedQuery(name = "BdvEmpresa.findByTlfOpcional", query = "SELECT b FROM BdvEmpresa b WHERE b.tlfOpcional = :tlfOpcional"),
    @NamedQuery(name = "BdvEmpresa.findByOtroProducto", query = "SELECT b FROM BdvEmpresa b WHERE b.otroProducto = :otroProducto"),
    @NamedQuery(name = "BdvEmpresa.findByFinalizoRegistro", query = "SELECT b FROM BdvEmpresa b WHERE b.finalizoRegistro = :finalizoRegistro"),
    @NamedQuery(name = "BdvEmpresa.findByActivadoDesactivadoPor", query = "SELECT b FROM BdvEmpresa b WHERE b.activadoDesactivadoPor = :activadoDesactivadoPor"),
    @NamedQuery(name = "BdvEmpresa.findByFechaRegistro", query = "SELECT b FROM BdvEmpresa b WHERE b.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "BdvEmpresa.findByFechaActualizado", query = "SELECT b FROM BdvEmpresa b WHERE b.fechaActualizado = :fechaActualizado"),
    @NamedQuery(name = "BdvEmpresa.findByFechaActivadoDesactivado", query = "SELECT b FROM BdvEmpresa b WHERE b.fechaActivadoDesactivado = :fechaActivadoDesactivado")})
public class BdvEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 20)
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @Size(max = 20)
    @Column(name = "origen")
    private String origen;
    @Size(max = 10)
    @Column(name = "ente")
    private String ente;
    @Size(max = 1)
    @Column(name = "tipo_rif")
    private String tipoRif;
    @Size(max = 20)
    @Column(name = "rif")
    private String rif;
    @Size(max = 100)
    @Column(name = "razon_social")
    private String razonSocial;
    @Size(max = 100)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Size(max = 100)
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Column(name = "anio_inicio_actividades")
    private Integer anioInicioActividades;
    @Size(max = 100)
    @Column(name = "domicilio_tributario")
    private String domicilioTributario;
    @Size(max = 100)
    @Column(name = "interseccion_referencia")
    private String interseccionReferencia;
    @Size(max = 100)
    @Column(name = "numero")
    private String numero;
    @Size(max = 100)
    @Column(name = "edificio_referencia")
    private String edificioReferencia;
    @Size(max = 100)
    @Column(name = "departamento_oficina")
    private String departamentoOficina;
    @Size(max = 50)
    @Column(name = "pais")
    private String pais;
    @Size(max = 20)
    @Column(name = "tlf_oficina")
    private String tlfOficina;
    @Size(max = 20)
    @Column(name = "tlf_celular")
    private String tlfCelular;
    @Size(max = 20)
    @Column(name = "tlf_opcional")
    private String tlfOpcional;
    @Size(max = 100)
    @Column(name = "otro_producto")
    private String otroProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finalizo_registro")
    private boolean finalizoRegistro;
    @Size(max = 50)
    @Column(name = "activado_desactivado_por")
    private String activadoDesactivadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_activado_desactivado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivadoDesactivado;
    @JoinTable(name = "bdv_empresa_categoria_producto", joinColumns = {
        @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")}, inverseJoinColumns = {
        @JoinColumn(name = "id_categoria_producto", referencedColumnName = "id_categoria_producto")})
    @ManyToMany
    private List<BdvCategoriaProducto> bdvCategoriaProductoList;
    @JoinColumn(name = "id_banco_cuenta1", referencedColumnName = "id_banco_cuenta")
    @ManyToOne
    private BdvBancoCuenta idBancoCuenta1;
    @JoinColumn(name = "id_nacionalidad", referencedColumnName = "id")
    @ManyToOne
    private BdvNacionalidad idNacionalidad;
    @JoinColumn(name = "id_contacto1", referencedColumnName = "id_contacto")
    @ManyToOne
    private BdvContacto idContacto1;
    @JoinColumn(name = "id_representate_legal1", referencedColumnName = "id_representate_legal")
    @ManyToOne
    private BdvRepresentateLegal idRepresentateLegal1;
    @JoinColumn(name = "id_representate_legal2", referencedColumnName = "id_representate_legal")
    @ManyToOne
    private BdvRepresentateLegal idRepresentateLegal2;
    @JoinColumn(name = "id_representate_legal3", referencedColumnName = "id_representate_legal")
    @ManyToOne
    private BdvRepresentateLegal idRepresentateLegal3;
    @JoinColumn(name = "id_banco_cuenta2", referencedColumnName = "id_banco_cuenta")
    @ManyToOne
    private BdvBancoCuenta idBancoCuenta2;
    @JoinColumn(name = "municipio", referencedColumnName = "id_ubic_geo")
    @ManyToOne
    private BdvMcbeUbicGeo municipio;
    @JoinColumn(name = "estado", referencedColumnName = "id_ubic_geo")
    @ManyToOne
    private BdvMcbeUbicGeo estado;
    @JoinColumn(name = "parroquia", referencedColumnName = "id_ubic_geo")
    @ManyToOne
    private BdvMcbeUbicGeo parroquia;
    @JoinColumn(name = "id_contacto2", referencedColumnName = "id_contacto")
    @ManyToOne
    private BdvContacto idContacto2;
    @JoinColumn(name = "id_banco_cuenta3", referencedColumnName = "id_banco_cuenta")
    @ManyToOne
    private BdvBancoCuenta idBancoCuenta3;
    @JoinColumn(name = "id_banco_cuenta_vnz1", referencedColumnName = "id_banco_cuenta_vnz")
    @ManyToOne
    private BdvBancoCuentaVnz idBancoCuentaVnz1;
    @JoinColumn(name = "id_banco_cuenta_vnz2", referencedColumnName = "id_banco_cuenta_vnz")
    @ManyToOne
    private BdvBancoCuentaVnz idBancoCuentaVnz2;
    @JoinColumn(name = "id_contacto3", referencedColumnName = "id_contacto")
    @ManyToOne
    private BdvContacto idContacto3;
    @JoinColumn(name = "id_recaudos", referencedColumnName = "id_recaudos")
    @ManyToOne
    private BdvRecaudos idRecaudos;
    @JoinColumn(name = "id_naturaleza_cliente", referencedColumnName = "id_naturaleza_cliente")
    @ManyToOne
    private BdvNaturalezaCliente idNaturalezaCliente;
    @JoinColumn(name = "id_sector", referencedColumnName = "id_seector")
    @ManyToOne
    private BdvSectorGremio idSector;
    @OneToMany(mappedBy = "idEmpresa")
    private List<BdvUser> bdvUserList;

    public BdvEmpresa() {
        System.out.println("En Constructor de Empresa");
        idNacionalidad = new BdvNacionalidad();
        idNaturalezaCliente = new BdvNaturalezaCliente();
        idRepresentateLegal1 = new BdvRepresentateLegal();
        //idRepresentateLegal2 = new BdvRepresentateLegal();
        //idRepresentateLegal3 = new BdvRepresentateLegal();
        idSector = new BdvSectorGremio();
        idBancoCuenta1 = new BdvBancoCuenta();
        //idBancoCuenta2 = new BdvBancoCuenta();
        //idBancoCuenta3 = new BdvBancoCuenta();
        idBancoCuentaVnz1 = new BdvBancoCuentaVnz();
        //idBancoCuentaVnz2 = new BdvBancoCuentaVnz();
        idContacto1 = new BdvContacto();
        //idContacto2 = new BdvContacto();
        //idContacto3 = new BdvContacto();
        bdvCategoriaProductoList = new ArrayList<>();
//        idRecaudos = new BdvRecaudos();
        
        //Seteamos valores por defecto
        this.finalizoRegistro = false;
        //this.activadoDesactivadoPor = "1001";
        fechaActivadoDesactivado = new Date();
        fechaActualizado = new Date();
        fechaRegistro = new Date();
    }

    public BdvEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public BdvEmpresa(Integer idEmpresa, boolean finalizoRegistro, Date fechaRegistro, Date fechaActualizado, Date fechaActivadoDesactivado) {
        this.idEmpresa = idEmpresa;
        this.finalizoRegistro = finalizoRegistro;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizado = fechaActualizado;
        this.fechaActivadoDesactivado = fechaActivadoDesactivado;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEnte() {
        return ente;
    }

    public void setEnte(String ente) {
        this.ente = ente;
    }

    public String getTipoRif() {
        return tipoRif;
    }

    public void setTipoRif(String tipoRif) {
        this.tipoRif = tipoRif;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Integer getAnioInicioActividades() {
        return anioInicioActividades;
    }

    public void setAnioInicioActividades(Integer anioInicioActividades) {
        this.anioInicioActividades = anioInicioActividades;
    }

    public String getDomicilioTributario() {
        return domicilioTributario;
    }

    public void setDomicilioTributario(String domicilioTributario) {
        this.domicilioTributario = domicilioTributario;
    }

    public String getInterseccionReferencia() {
        return interseccionReferencia;
    }

    public void setInterseccionReferencia(String interseccionReferencia) {
        this.interseccionReferencia = interseccionReferencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEdificioReferencia() {
        return edificioReferencia;
    }

    public void setEdificioReferencia(String edificioReferencia) {
        this.edificioReferencia = edificioReferencia;
    }

    public String getDepartamentoOficina() {
        return departamentoOficina;
    }

    public void setDepartamentoOficina(String departamentoOficina) {
        this.departamentoOficina = departamentoOficina;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTlfOficina() {
        return tlfOficina;
    }

    public void setTlfOficina(String tlfOficina) {
        this.tlfOficina = tlfOficina;
    }

    public String getTlfCelular() {
        return tlfCelular;
    }

    public void setTlfCelular(String tlfCelular) {
        this.tlfCelular = tlfCelular;
    }

    public String getTlfOpcional() {
        return tlfOpcional;
    }

    public void setTlfOpcional(String tlfOpcional) {
        this.tlfOpcional = tlfOpcional;
    }

    public String getOtroProducto() {
        return otroProducto;
    }

    public void setOtroProducto(String otroProducto) {
        this.otroProducto = otroProducto;
    }

    public boolean getFinalizoRegistro() {
        return finalizoRegistro;
    }

    public void setFinalizoRegistro(boolean finalizoRegistro) {
        this.finalizoRegistro = finalizoRegistro;
    }

    public String getActivadoDesactivadoPor() {
        return activadoDesactivadoPor;
    }

    public void setActivadoDesactivadoPor(String activadoDesactivadoPor) {
        this.activadoDesactivadoPor = activadoDesactivadoPor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(Date fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

    public Date getFechaActivadoDesactivado() {
        return fechaActivadoDesactivado;
    }

    public void setFechaActivadoDesactivado(Date fechaActivadoDesactivado) {
        this.fechaActivadoDesactivado = fechaActivadoDesactivado;
    }

    @XmlTransient
    public List<BdvCategoriaProducto> getBdvCategoriaProductoList() {
        return bdvCategoriaProductoList;
    }

    public void setBdvCategoriaProductoList(List<BdvCategoriaProducto> bdvCategoriaProductoList) {
        this.bdvCategoriaProductoList = bdvCategoriaProductoList;
    }

    public BdvBancoCuenta getIdBancoCuenta1() {
        return idBancoCuenta1;
    }

    public void setIdBancoCuenta1(BdvBancoCuenta idBancoCuenta1) {
        this.idBancoCuenta1 = idBancoCuenta1;
    }

    public BdvNacionalidad getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(BdvNacionalidad idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public BdvContacto getIdContacto1() {
        return idContacto1;
    }

    public void setIdContacto1(BdvContacto idContacto1) {
        this.idContacto1 = idContacto1;
    }

    public BdvRepresentateLegal getIdRepresentateLegal1() {
        return idRepresentateLegal1;
    }

    public void setIdRepresentateLegal1(BdvRepresentateLegal idRepresentateLegal1) {
        this.idRepresentateLegal1 = idRepresentateLegal1;
    }

    public BdvRepresentateLegal getIdRepresentateLegal2() {
        return idRepresentateLegal2;
    }

    public void setIdRepresentateLegal2(BdvRepresentateLegal idRepresentateLegal2) {
        this.idRepresentateLegal2 = idRepresentateLegal2;
    }

    public BdvRepresentateLegal getIdRepresentateLegal3() {
        return idRepresentateLegal3;
    }

    public void setIdRepresentateLegal3(BdvRepresentateLegal idRepresentateLegal3) {
        this.idRepresentateLegal3 = idRepresentateLegal3;
    }

    public BdvBancoCuenta getIdBancoCuenta2() {
        return idBancoCuenta2;
    }

    public void setIdBancoCuenta2(BdvBancoCuenta idBancoCuenta2) {
        this.idBancoCuenta2 = idBancoCuenta2;
    }

    public BdvMcbeUbicGeo getMunicipio() {
        return municipio;
    }

    public void setMunicipio(BdvMcbeUbicGeo municipio) {
        this.municipio = municipio;
    }

    public BdvMcbeUbicGeo getEstado() {
        return estado;
    }

    public void setEstado(BdvMcbeUbicGeo estado) {
        this.estado = estado;
    }

    public BdvMcbeUbicGeo getParroquia() {
        return parroquia;
    }

    public void setParroquia(BdvMcbeUbicGeo parroquia) {
        this.parroquia = parroquia;
    }

    public BdvContacto getIdContacto2() {
        return idContacto2;
    }

    public void setIdContacto2(BdvContacto idContacto2) {
        this.idContacto2 = idContacto2;
    }

    public BdvBancoCuenta getIdBancoCuenta3() {
        return idBancoCuenta3;
    }

    public void setIdBancoCuenta3(BdvBancoCuenta idBancoCuenta3) {
        this.idBancoCuenta3 = idBancoCuenta3;
    }

    public BdvBancoCuentaVnz getIdBancoCuentaVnz1() {
        return idBancoCuentaVnz1;
    }

    public void setIdBancoCuentaVnz1(BdvBancoCuentaVnz idBancoCuentaVnz1) {
        this.idBancoCuentaVnz1 = idBancoCuentaVnz1;
    }

    public BdvBancoCuentaVnz getIdBancoCuentaVnz2() {
        return idBancoCuentaVnz2;
    }

    public void setIdBancoCuentaVnz2(BdvBancoCuentaVnz idBancoCuentaVnz2) {
        this.idBancoCuentaVnz2 = idBancoCuentaVnz2;
    }

    public BdvContacto getIdContacto3() {
        return idContacto3;
    }

    public void setIdContacto3(BdvContacto idContacto3) {
        this.idContacto3 = idContacto3;
    }

    public BdvRecaudos getIdRecaudos() {
        return idRecaudos;
    }

    public void setIdRecaudos(BdvRecaudos idRecaudos) {
        this.idRecaudos = idRecaudos;
    }

    public BdvNaturalezaCliente getIdNaturalezaCliente() {
        return idNaturalezaCliente;
    }

    public void setIdNaturalezaCliente(BdvNaturalezaCliente idNaturalezaCliente) {
        this.idNaturalezaCliente = idNaturalezaCliente;
    }

    public BdvSectorGremio getIdSector() {
        return idSector;
    }

    public void setIdSector(BdvSectorGremio idSector) {
        this.idSector = idSector;
    }

    @XmlTransient
    public List<BdvUser> getBdvUserList() {
        return bdvUserList;
    }

    public void setBdvUserList(List<BdvUser> bdvUserList) {
        this.bdvUserList = bdvUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BdvEmpresa)) {
            return false;
        }
        BdvEmpresa other = (BdvEmpresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bdv.modelo.BdvEmpresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
