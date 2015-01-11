package org.bdv.vista;

import java.io.IOException;
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
import org.bdv.helper.SendMail;

@ManagedBean(name = "bdvUserController")
@SessionScoped
public class BdvUserController implements Serializable {

    @EJB
    private org.bdv.controlador.BdvUserFacade ejbFacade;
    private List<BdvUser> items = null;
    private BdvUser selected;
    private BdvUser selected2;

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

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BdvUserDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BdvUser> getItems() {
        if (items == null) {
            items = getFacade().findAll();
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

    public void registrarProveedor(String email) {
        if (usuarioRegistrado(email)) { //!=Null = email ya registrado
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("EmailNoDisponible"));
        } else { //Email Disponible
            try {
                create();
                new SendMail(selected.getEmail());
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/faces/registroExitoso.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Nos devuelve si el email esta registrado en BD

    private Boolean usuarioRegistrado(String email) {
        return getFacade().obtenerUsuario(email) != null;
    }

    public String obtenerUsuario(String email, String contrasenia) {
        try {
            //Obtenemos los datos del usuario
            BdvUser a = getFacade().obtenerUsuario(email, contrasenia);
//            if (!a.getEmailValido()) { //Si el usuario no esta activo lo activamos
            prepareCreateUserRegistred();
            setSelected(a);
            selected.setEmailValido(true);
            updateActive();
            prepareCreateUserRegistred();
            selected.setIdUser(a.getIdUser());
            selected.setEmail(a.getEmail());
            selected.setContrasenia(a.getContrasenia());
            selected.setEmailValido(true);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserAndPasswordCorrect"));
            try {
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/faces/bdvRegistro/registro_continuar.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
//            } else { //Si el usuario ya esta activado
//                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserActiveOld"));
//                return null;
//            }
        } catch (EJBException | NoResultException | NullPointerException ex) {
            System.out.println("Id Usuario Null ");
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        //return "/bdvRegistro/validaEmail.xhtml";
        return null;
    }

    public String entrarHomeUser(String email, String contrasenia) {
        try {
            //Obtenemos los datos del usuario
            BdvUser a = getFacade().obtenerUsuario(email, contrasenia);
//            selected = new BdvUser();
            if (a.getEmailValido()) { //Si el usuario esta activo
                prepareCreateUserRegistred();
                setSelected(a);
                //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserAndPasswordCorrect"));                
                //return "homeUser";
                try {
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    context.redirect(context.getRequestContextPath() + "/faces/homeUser.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { //Si el usuario esta inactivo
                JsfUtil.addSuccessMessage("Usuario Inactivo");
                return null;
            }

        } catch (EJBException | NoResultException | NullPointerException ex) {
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        return null;
    }

    public String entrarHomeBackend(String email, String contrasenia) {
        try {
            BdvUser a = getFacade().obtenerUsuario(email, contrasenia);
            if (a.getEmailValido()) { //Si el usuario esta activo
                try {
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    context.redirect(context.getRequestContextPath() + "/faces/homeBackend.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { //Si el usuario esta inactivo
                JsfUtil.addSuccessMessage("Usuario Inactivo");
                return null;
            }

        } catch (EJBException | NoResultException | NullPointerException ex) {
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        return null;
    }

    public void completarRegistro() {
        try {
            selected.getIdEmpresa().setFinalizoRegistro(true);
            update();
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/registroFinalizado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
