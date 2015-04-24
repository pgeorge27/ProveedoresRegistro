package org.bdv.vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bdv.modelo.BdvUser;
import org.bdv.vista.util.JsfUtil;
import org.bdv.vista.util.JsfUtil.PersistAction;
import org.bdv.controlador.BdvUserFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import org.bdv.helper.PasswordEncrypt;
import org.bdv.helper.PasswordValidator;
import org.bdv.helper.RandomManagedBean;
import org.bdv.helper.SendMail;
import org.bdv.modelo.BdvUserBackend;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "bdvUserController")
@SessionScoped
public class BdvUserController implements Serializable {

    @EJB
    private org.bdv.controlador.BdvUserFacade ejbFacade;
    private List<BdvUser> items = null;
    public static BdvUser selected;
    private BdvUser selected2; //Para ayudarnos en formulario y comparar valores contra selected
    private BdvUser userC; //Lo usuaremos para almacenar usuario Consultado de BD

    public BdvUserController() {

    }

    public BdvUser getSelected2() {
        return selected2;
    }

    public void setSelected2(BdvUser selected2) {
        this.selected2 = selected2;
    }

    public BdvUser getSelected() {
        return selected;
    }

    public void setSelected(BdvUser selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BdvUserFacade getFacade() {
        return ejbFacade;
    }

    public BdvUser prepareCreate() {
        selected = new BdvUser();
        initializeEmbeddableKey();
        return selected;
    }

    public BdvUser prepareCreateUserRegistred() {
        selected = new BdvUser(true);
        return selected;
    }
    //Metodo usado para validar el Email

    public BdvUser prepareCreate2() {
        selected2 = new BdvUser();
        return selected2;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BdvUserCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BdvUserUpdated"));
    }

    public void updateActive() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UserAndPasswordCorrect"));
    }

    public void updateChangePassword() {//Es solo para mostrar mensaje al cambiar password
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PasswordChanged"));
    }

    public void updateEmpresa() {//Para activar la empresa o realizar algun cambio desde el backend
        System.out.println("Usuario Id " + selected.getIdUser());
        System.out.println("Empresa Activa? " + selected.getIdEmpresa().isEmpresaAprobada());
        System.out.println("Email " + selected.getEmail());
        selected.getIdEmpresa().setActivadoDesactivadoPor(BdvUserBackendController.selected.getUserBackend());
        try {
            if (selected.getIdEmpresa().isEmpresaAprobada()) {//Si es aprobado se le envia un email
                selected.getIdEmpresa().setEmpresaAprobada(true);
                update();
                //new SendMail(selected.getEmail(), "aprobado");
            }
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/bdvUser/List.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BdvUserDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BdvUser> getItems() {
        if (items == null) {
            //items = getFacade().findAll();
            //Obtenemos solo los usuarios que han finalizado el registro
            items = getFacade().obtenerUsuariosFinalizados();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<BdvUser> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<BdvUser> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public void registrarProveedor(String email, String contrasenia) {
        if (usuarioRegistrado(email)) { //!=Null = email ya registrado
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("EmailNoDisponible"));
        } else { //Email Disponible
            if (new PasswordValidator().validate(contrasenia)) {
                try {
                    String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);
                    selected.setContrasenia(contraseniaEncriptada);
                    selected.setActivo(true);
                    selected.setEmailValido(false);
                    selected.setCambiaContrasenia(false);
                    selected.setFinalizoRegistro(false);
                    create();
                    //new SendMail(selected.getEmail());
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    context.redirect(context.getRequestContextPath() + "/faces/registroExitoso.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("PasswordNoAcept"));
            }
        }
    }

    //Nos devuelve si el email esta registrado en BD
    private Boolean usuarioRegistrado(String email) {
        return getFacade().obtenerUsuario(email) != null;
    }

    public String obtenerUsuario(String email, String contrasenia) {
        try {//encriptamos la contrasenia
            String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);//Encriptamos la contraseña
            //Obtenemos los datos del usuario
            BdvUser user = getFacade().obtenerUsuario(email, contraseniaEncriptada);
            if (!user.getEmailValido()) { //Si el usuario valido el email
//            prepareCreateUserRegistred();
                prepareCreate();
                setSelected(user);
//            selected.setIdUser(a.getIdUser());
//            selected.setEmail(a.getEmail());
//            selected.setContrasenia(a.getContrasenia());
                selected.setEmailValido(true);
//            selected.setActivo(true);
                updateActive();
                prepareCreateUserRegistred();

                user = getFacade().obtenerUsuario(email, contraseniaEncriptada);
//            setSelected(user);
                selected.setIdUser(user.getIdUser());
                selected.setEmail(user.getEmail());
                selected.setContrasenia(user.getContrasenia());
                selected.setActivo(user.getActivo());
                selected.setEmailValido(user.getEmailValido());
                selected.setCambiaContrasenia(user.isCambiaContrasenia());

                try {
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    context.redirect(context.getRequestContextPath() + "/faces/bdvRegistro/registro_continuar.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { //Si el usuario ya esta activado
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserActiveOld"));
                return null;
            }
        } catch (EJBException | NoResultException | NullPointerException ex) {
            System.out.println("Id Usuario Null ");
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        //return "/bdvRegistro/validaEmail.xhtml";
        return null;
    }

    public String entrarHomeUser(String email, String contrasenia) {
        try {
            String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);//Encriptamos la contraseña
            userC = getFacade().obtenerUsuario(email, contraseniaEncriptada);//Obtenemos los datos del usuario
            if (userC.getActivo()) {//Verificamos que el usuario se encuentre activo
                System.out.println("En activo");
                if (userC.getEmailValido()) { //valido el email?
                    System.out.println("En valido");
                    prepareCreateUserRegistred();//Inicializamos al usuario 
                    //
                    if (userC.getIdEmpresa() != null && userC.getFinalizoRegistro()) {//Si registro su empresa y finalizo el registro
                        if (userC.isCambiaContrasenia()) {
                            try { // Debe cambiar Contrasenia
                                setSelected(userC);//Le asignamos sus valores
                                System.out.println("Cambiar Contrasenia");
                                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                                context.redirect(context.getRequestContextPath() + "/faces/cambiarContraseniaOlvidada.xhtml");
                            } catch (IOException ex) {
                                Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try { // Al home User
                                setSelected(userC);//Le asignamos sus valores
                                System.out.println("al home");
                                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                                context.redirect(context.getRequestContextPath() + "/faces/homeUser.xhtml");
                            } catch (IOException ex) {
                                Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    } else { // A culminar su registro
                        try {
                            //prepareCreateUserRegistred();//SE DEBE SOLUCIONAR OJO
                            setSelected(userC);//Le asignamos sus valores //SE DEBE SOLUCIONAR OJO
                            //evaluarSeteado();//Evaluamos que valores le setearemos al usuario
                            System.out.println("Al registro");
                            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                            context.redirect(context.getRequestContextPath() + "/faces/bdvRegistro/registro_continuar.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else { //Si el usuario no valido su email
                    JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("EmailNoValidated"));
                    return null;
                }
            } else { //Si el usuario esta inactivo
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("UsuarioInactivo"));
                return null;
            }
        } catch (EJBException | NoResultException | NullPointerException ex) { // Error en el usuario o contraseña
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        return null;
    }

    public void completarRegistro() {
        try {
            selected.setFinalizoRegistro(true);
            update();
            //new SendMail(ResourceBundle.getBundle("/BundleEmail").getString("EmailAdmin"), "admin");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/registroFinalizado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recuperarContrasenia(String email) {
        try {
            if (usuarioRegistrado(email)) {
                //Obtenemos el usuario
                BdvUser user = getFacade().obtenerUsuario(email);
                //Generamos una nueva contrasenia
                String contrasenia = new RandomManagedBean().generateRandomString();
                //Encriptamos la contraseña
                String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);
                setSelected(user);
                //Seteamos la contrasenia nueva
                selected.setContrasenia(contraseniaEncriptada);
                //Establecemos que debera cambiar password al hacer login
                selected.setCambiaContrasenia(true);
                //Cambiamos la Contrasenia del usuario
                updateChangePassword();
                //Enviamos email con contraseña nueva al usuario
                //new SendMail(selected.getEmail(),"recuperar",contrasenia);
                System.out.println("Enviamos email a " + email);
                System.out.println("Contrasenia Nueva " + contrasenia);
                System.out.println("Debe cambiar Pass? " + selected.isCambiaContrasenia());
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/faces/revisarEmail.xhtml");
            } else {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("EmailNoExiste"));
            }
        } catch (Exception e) {
        }
    }

    public void cambiarContrasenia(String contrasenia, String contraseniaNueva) {
        try {
            String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);//Encriptamos la contraseña
            BdvUser user = getFacade().obtenerUsuario(selected.getEmail(), contraseniaEncriptada);
            System.out.println("Contrasena actual " + contrasenia + "nueva " + contraseniaNueva);
            System.out.println("Contrasena del usuario en bd " + user.getContrasenia());
            if (user.getContrasenia().equals(contraseniaEncriptada)) {
                System.out.println("Las contrasenas son iguales " + user.getContrasenia() + " y " + contrasenia);
                contraseniaEncriptada = new PasswordEncrypt().Encriptar(contraseniaNueva);//Encriptamos la contraseña nueva
                selected.setContrasenia(contraseniaEncriptada);
                System.out.println("Cambiar a " + selected.getContrasenia());
                updateChangePassword();

            } else {
                System.out.println("Las contrasenias no son iguales");
            }
        } catch (Exception e) {
        }
    }

    public void actualizarContrasenia(String contrasenia) {
        if (new PasswordValidator().validate(contrasenia)) {
            try {
                String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);//Encriptamos la contraseña
                selected.setContrasenia(contraseniaEncriptada);
                selected.setCambiaContrasenia(false);
                updateChangePassword();
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/faces/contraseniaCambiada.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("PasswordNoAcept"));
        }
    }

    public void agregarRepre2() {
        selected.getIdEmpresa().agregarRepresentante2();
    }

    public void eliminarRepre2() {
        selected.getIdEmpresa().eliminarRepresentante2();
    }

    public void agregarRepre3() {
        selected.getIdEmpresa().agregarRepresentante3();
    }

    public void eliminarRepre3() {
        selected.getIdEmpresa().eliminarRepresentante3();
    }

    public void agregarCuentaBancoV2() {
        selected.getIdEmpresa().agregarCuentaBancoV2();
    }

    public void eliminarCuentaBancoV2() {
        selected.getIdEmpresa().eliminarCuentaBancoV2();
    }

    public void agregarCuentaBanco2() {
        selected.getIdEmpresa().agregarCuentaBanco2();
    }

    public void eliminarCuentaBanco2() {
        selected.getIdEmpresa().eliminarCuentaBanco2();
    }

    public void agregarCuentaBanco3() {
        selected.getIdEmpresa().agregarCuentaBanco3();
    }

    public void eliminarCuentaBanco3() {
        selected.getIdEmpresa().eliminarCuentaBanco3();
    }

    public void agregarContacto2() {
        selected.getIdEmpresa().agregarContacto2();
    }

    public void eliminarContacto2() {
        selected.getIdEmpresa().eliminarContacto2();
    }

    public void agregarContacto3() {
        selected.getIdEmpresa().agregarContacto3();
    }

    public void eliminarContacto3() {
        selected.getIdEmpresa().eliminarContacto3();
    }

    public void logOut() {
        getRequest().getSession().invalidate();
        this.selected = null;
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return "../login.xhtml";
    }

    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    private String destination = ResourceBundle.getBundle("/BundleUpload").getString("Destino");
//+selected.getIdEmpresa().getNombreComercial().replaceAll("\\s","");
//            ResourceBundle.getBundle("/BundleUpload").getString("Destino");

    public void uploadCertificadoSnc(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            if (selected.getIdEmpresa().getIdRecaudos() == null) {
                System.out.println("RECAUDOS NULL");
                selected.getIdEmpresa().agregarRecaudos(); //Si el registro no tiene recaudos
            }
            selected.getIdEmpresa().getIdRecaudos().setCertificadoSnc(destination + "certificadoSnc.pdf");
//            System.out.println("Certificado Snc = " + selected.getIdEmpresa().getIdRecaudos().getCertificadoSnc());
//            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            copyFile("certificadoSnc.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadPlanillaRnc(FileUploadEvent event) {
        //destination = selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setPlanillaRnc(destination + "planillaRnc.pdf");
            copyFile("planillaRnc.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadComunicacionRepresentante(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setComunicacionRepresentante(destination + "comunicacionRepresentante.pdf");
            copyFile("comunicacionRepresentante.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadSolvenciaSso(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setSolvenciaSso(destination + "solvenciaSso.pdf");
            copyFile("solvenciaSso.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadSolvenciaLaboral(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setCertificadoSnc(destination + "solvenciaLaboral.pdf");
            copyFile("solvenciaLaboral.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadSolvenciaInce(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setCertificadoSnc(destination + "solvenciaInce.pdf");
            copyFile("solvenciaInce.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadOrganigrama(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setOrganigrama(destination + "organigrama.pdf");
            copyFile("organigrama.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadListaProductos(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setListaProductos(destination + "listaProductos.pdf");
            copyFile("listaProductos.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadReferenciaBancaria(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setReferenciaBancaria(destination + "referenciaBancaria.pdf");
            copyFile("referenciaBancaria.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadReferenciaComercial(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setReferenciaComercial(destination + "referenciaComercial.pdf");
            copyFile("referenciaComercial.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadCedula(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setCedula(destination + "cedula.pdf");
            copyFile("cedula.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void uploadRif(FileUploadEvent event) {
//        destination = destination + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        try {
            selected.getIdEmpresa().getIdRecaudos().setRif(destination + "rif.pdf");
            copyFile("rif.pdf", event.getFile().getInputstream());
            JsfUtil.addSuccessMessage("Carga exitosa del archivo");
        } catch (IOException e) {
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createFolder() {
        File files = new File(ResourceBundle.getBundle("/BundleUpload").getString("Destino") + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", ""));
        System.out.println("Nombre de la carpeta " + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", ""));
        //Seteamos el destino de los archivos que seran subidos
        destination = ResourceBundle.getBundle("/BundleUpload").getString("Destino") + selected.getIdEmpresa().getNombreComercial().replaceAll("\\s", "") + File.separator;
        if (files.exists()) {
            System.out.println("La carpeta ya existe");
            if (files.mkdirs()) {
                System.out.println("Carpeta Creada!");
            } else {
                System.out.println("No se pudo crear la carpeta!");
            }
        } else {
            files.mkdir();
            System.out.println("Carpeta creada!");
        }
    }

    private void evaluarSeteado() {
        if (userC.getIdEmpresa() != null) {
            if (!userC.getIdEmpresa().getTipoPersona().isEmpty()) {//Verificamos si tiene valor la empresa
                selected.getIdEmpresa().setTipoPersona(userC.getIdEmpresa().getTipoPersona());
            }
        }
    }

    public String onFlowProcess(FlowEvent event) {
//        System.out.println("Current wizard step: " + event.getOldStep());
//        System.out.println("Next step: " + event.getNewStep());
        
        if (selected.getIdEmpresa().getIdRecaudos() == null) {
            selected.getIdEmpresa().agregarRecaudos(); //Si el registro no tiene recaudos
        }

        if (event.getOldStep().equalsIgnoreCase("certificadoSncTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getCertificadoSnc() == null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "certificadoSncTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("planillaRncTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getPlanillaRnc()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "planillaRncTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("comunicacionRepresentanteTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getComunicacionRepresentante()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "comunicacionRepresentanteTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("solvenciaSsoTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getSolvenciaSso()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "solvenciaSsoTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("solvenciaLaboralTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getSolvenciaLaboral()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "solvenciaLaboralTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("solvenciaInceTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getSolvenciaInce()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "solvenciaLaboralTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("organigramaTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getOrganigrama()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "organigramaTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("referenciaBancariaTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getReferenciaBancaria()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "referenciaBancariaTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("referenciaComercialTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getReferenciaComercial()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "referenciaComercialTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("cedulaUTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getCedula()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "cedulaUTab";
            } else {
                return event.getNewStep();
            }
        }else if (event.getOldStep().equalsIgnoreCase("rifUTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getRif()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "rifUTab";
            } else {
                return event.getNewStep();
            }
        }
        else if (event.getOldStep().equalsIgnoreCase("listaProductosTab")) {
            if (selected.getIdEmpresa().getIdRecaudos().getListaProductos()== null) {
                JsfUtil.addErrorMessage("Debe cargar el documento.");
                return "listaProductosTab";
            } else {
                return "PF('wizardWV').next()";
            }
        }
        
        return null;
    }

    @FacesConverter(forClass = BdvUser.class)
    public static class BdvUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BdvUserController controller = (BdvUserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bdvUserController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof BdvUser) {
                BdvUser o = (BdvUser) object;
                return getStringKey(o.getIdUser());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BdvUser.class.getName()});
                return null;
            }
        }

    }

}
