package org.bdv.vista;

import java.io.IOException;
import org.bdv.modelo.BdvUserBackend;
import org.bdv.vista.util.JsfUtil;
import org.bdv.vista.util.JsfUtil.PersistAction;
import org.bdv.controlador.BdvUserBackendFacade;

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
import org.bdv.modelo.BdvUser;

@ManagedBean(name = "bdvUserBackendController")
@SessionScoped
public class BdvUserBackendController implements Serializable {

    @EJB
    private org.bdv.controlador.BdvUserBackendFacade ejbFacade;
    private List<BdvUserBackend> items = null;
    private BdvUserBackend selected;
    private BdvUserBackend selected2;
    private BdvUserBackend activo;

    public BdvUserBackendController() {
    }

    public BdvUserBackend getSelected() {
        return selected;
    }

    public void setSelected(BdvUserBackend selected) {
        this.selected = selected;
    }

    public BdvUserBackend getSelected2() {
        return selected2;
    }

    public void setSelected2(BdvUserBackend selected2) {
        this.selected2 = selected2;
    }

    public BdvUserBackend getActivo() {
        return activo;
    }

    public void setActivo(BdvUserBackend activo) {
        this.activo = activo;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BdvUserBackendFacade getFacade() {
        return ejbFacade;
    }

    public BdvUserBackend prepareCreate() {
        selected = new BdvUserBackend();
        initializeEmbeddableKey();
        return selected;
    }

    public BdvUserBackend prepareCreate2() {
        selected2 = new BdvUserBackend();
        return selected2;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BdvUserBackendCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BdvUserBackendUpdated"));
    }
    
    public void updateChangePassword() {//Es solo para mostrar mensaje al cambiar password
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PasswordChanged"));
    }
    
    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BdvUserBackendDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BdvUserBackend> getItems() {
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

    public List<BdvUserBackend> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<BdvUserBackend> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public String entrarHomeBackend(String userBackend, String contrasenia) {
        try {
            String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);//Encriptamos la contraseña
            BdvUserBackend user = getFacade().obtenerUsuario(userBackend, contraseniaEncriptada);
            if (user.getActivo()) { //Si el usuario esta activo
                try {
                    prepareCreate();
                    setSelected(user);
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    context.redirect(context.getRequestContextPath() + "/faces/homeBackend.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { //Si el usuario esta inactivo
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("UsuarioInactivo"));
                return null;
            }
        } catch (EJBException | NoResultException | NullPointerException ex) {
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        return null;
    }
    
    public void cambiarContrasenia(String contrasenia, String contraseniaNueva){
        try {
            String contraseniaEncriptada = new PasswordEncrypt().Encriptar(contrasenia);//Encriptamos la contraseña
            BdvUserBackend user = getFacade().obtenerUsuario(selected.getUserBackend(), contraseniaEncriptada);
            System.out.println("Contrasena actual " + contrasenia + "nueva " + contraseniaNueva);
            System.out.println("Contrasena del usuario en bd " + user.getContrasenia());
            if(user.getContrasenia().equals(contraseniaEncriptada)){
                System.out.println("Las contrasenas son iguales " + user.getContrasenia() + " y " + contrasenia);
                contraseniaEncriptada = new PasswordEncrypt().Encriptar(contraseniaNueva);//Encriptamos la contraseña nueva
                selected.setContrasenia(contraseniaEncriptada);
                System.out.println("Cambiar a " + selected.getContrasenia());
                updateChangePassword();
                
            }else{
                System.out.println("Las contrasenias no son iguales");
            }
        } catch (Exception e) {
        }
    }
    
    public void logOut() {
        getRequest().getSession().invalidate();
        this.selected = null;
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/loginBackend.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BdvUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    @FacesConverter(value = "BdvUserBackendControllerConverter", forClass = BdvUserBackend.class)
    public static class BdvUserBackendControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BdvUserBackendController controller = (BdvUserBackendController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bdvUserBackendController");
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
            if (object instanceof BdvUserBackend) {
                BdvUserBackend o = (BdvUserBackend) object;
                return getStringKey(o.getIdUser());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BdvUserBackend.class.getName()});
                return null;
            }
        }

    }

}
