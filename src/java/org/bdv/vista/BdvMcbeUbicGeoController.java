package org.bdv.vista;

import org.bdv.modelo.BdvMcbeUbicGeo;
import org.bdv.vista.util.JsfUtil;
import org.bdv.vista.util.JsfUtil.PersistAction;
import org.bdv.controlador.BdvMcbeUbicGeoFacade;

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
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@ManagedBean(name="bdvMcbeUbicGeoController")
@SessionScoped
public class BdvMcbeUbicGeoController implements Serializable {


    @EJB private org.bdv.controlador.BdvMcbeUbicGeoFacade ejbFacade;
    private List<BdvMcbeUbicGeo> items = null;
    private BdvMcbeUbicGeo selected;
    private int idEstado = -1;
    private int idMunicipio = -1;
    
    public BdvMcbeUbicGeoController() {
         
    }

    public BdvMcbeUbicGeo getSelected() {
        return selected;
    }

    public void setSelected(BdvMcbeUbicGeo selected) {
        this.selected = selected;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
        System.out.println("En setIdEstado");
        System.out.println("Valor " + idEstado);
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
        System.out.println("En SetIdMuni");
        System.out.println("Valor " + idMunicipio);
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BdvMcbeUbicGeoFacade getFacade() {
        return ejbFacade;
    }

    public BdvMcbeUbicGeo prepareCreate() {
        selected = new BdvMcbeUbicGeo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BdvMcbeUbicGeoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BdvMcbeUbicGeoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BdvMcbeUbicGeoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BdvMcbeUbicGeo> getItems() {
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

    public List<BdvMcbeUbicGeo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<BdvMcbeUbicGeo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    public List<BdvMcbeUbicGeo> obtenerEstados() {
        System.out.println("ID PADRE Estado == " + getIdEstado());
        return getFacade().obtenerMunicipio(0);
    }
    
    public List<BdvMcbeUbicGeo> obtenerMunicipios() {
        System.out.println("ID PADRE Municipio == " + getIdEstado());
//        return getFacade().obtenerMunicipio(getIdEstado());
        return getFacade().obtenerMunicipio(BdvUserController.selected.getIdEmpresa().getEstado().getIdUbicGeo());
    }
    
    public List<BdvMcbeUbicGeo> obtenerParroquias() {
//        return getFacade().obtenerParroquia(getIdMunicipio());
        return getFacade().obtenerMunicipio(BdvUserController.selected.getIdEmpresa().getMunicipio().getIdUbicGeo());
    }
   
    @FacesConverter(forClass=BdvMcbeUbicGeo.class)
    public static class BdvMcbeUbicGeoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BdvMcbeUbicGeoController controller = (BdvMcbeUbicGeoController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bdvMcbeUbicGeoController");
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
            if (object instanceof BdvMcbeUbicGeo) {
                BdvMcbeUbicGeo o = (BdvMcbeUbicGeo) object;
                return getStringKey(o.getIdUbicGeo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BdvMcbeUbicGeo.class.getName()});
                return null;
            }
        }

    }

}
