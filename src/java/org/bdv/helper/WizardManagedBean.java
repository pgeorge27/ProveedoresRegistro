/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.helper;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.bdv.modelo.BdvUser;
import org.bdv.vista.BdvUserController;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author georgeperez
 */
@ManagedBean
@SessionScoped
public class WizardManagedBean implements Serializable{

    private boolean checked;
    private boolean repre2;
    private boolean repre3;
    private boolean contacto2;
    private boolean contacto3;
    private boolean cuentaBanco2;
    private boolean cuentaBanco3;
    private boolean cuentaBancoVnz2;
    private boolean product;
    private boolean otroProduct;
    /**
     * Creates a new instance of WizardManagedBean
     */
    public WizardManagedBean() {
        checked = false;
        repre2 = false;
        repre3 = false;
        contacto2 = false;
        contacto3 = false;
        cuentaBanco2 = false;
        cuentaBanco3 = false;
        cuentaBancoVnz2 = false;
        product = true;
        otroProduct = true;
    }

    public boolean isProduct() {
        return product;
    }

    public void setProduct(boolean product) {
        this.product = product;
    }

    public boolean isOtroProduct() {
        return otroProduct;
    }

    public void setOtroProduct(boolean otroProduct) {
        this.otroProduct = otroProduct;
    }
    
    public void agregarRepre2(){
        setRepre2(true);
    }
    
    public void eliminarRepre2(){
        setRepre2(false);
        setRepre3(false);
    }
    
    public void agregarRepre3(){
        setRepre3(true);
    }
    
    public void eliminarRepre3(){
        setRepre3(false);
    }
    
    public void agregarCuentaBancoV2(){
        setCuentaBancoVnz2(true);
    }
    
    public void eliminarCuentaBancoV2(){
        setCuentaBancoVnz2(false);
    }
    
    public void agregarCuentaBanco2(){
        setCuentaBanco2(true);
    }

    public void eliminarCuentaBanco2(){
        setCuentaBanco2(false);
        setCuentaBanco3(false);
    }
    
    public void agregarCuentaBanco3(){
        setCuentaBanco3(true);
    }

    public void eliminarCuentaBanco3(){
        setCuentaBanco3(false);
    }
    
    public void agregarContacto2(){
        setContacto2(true);
    }
    
    public void eliminarContacto2(){
        setContacto2(false);
        setContacto3(false);
    }
    
    public void agregarContacto3(){
        setContacto3(true);
    }
    
    public void eliminarContacto3(){
        setContacto3(false);
    }
    
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isRepre2() {
        return repre2;
    }

    public void setRepre2(boolean repre2) {
        this.repre2 = repre2;
    }

    public boolean isRepre3() {
        return repre3;
    }

    public void setRepre3(boolean repre3) {
        this.repre3 = repre3;
    }

    public boolean isContacto2() {
        return contacto2;
    }

    public void setContacto2(boolean contacto2) {
        this.contacto2 = contacto2;
    }

    public boolean isContacto3() {
        return contacto3;
    }

    public void setContacto3(boolean contacto3) {
        this.contacto3 = contacto3;
    }

    public boolean isCuentaBanco2() {
        return cuentaBanco2;
    }

    public void setCuentaBanco2(boolean cuentaBanco2) {
        this.cuentaBanco2 = cuentaBanco2;
    }

    public boolean isCuentaBanco3() {
        return cuentaBanco3;
    }

    public void setCuentaBanco3(boolean cuentaBanco3) {
        this.cuentaBanco3 = cuentaBanco3;
    }

    public boolean isCuentaBancoVnz2() {
        return cuentaBancoVnz2;
    }

    public void setCuentaBancoVnz2(boolean cuentaBancoVnz2) {
        this.cuentaBancoVnz2 = cuentaBancoVnz2;
    }
    
    //Evaluamos si es obligatorio el campo Producto y el campo Otro producto
    public void productosRequired(){
        product = BdvUserController.selected.getIdEmpresa().getOtroProducto().isEmpty();
        otroProduct = BdvUserController.selected.getIdEmpresa().getBdvCategoriaProductoList().isEmpty();
        System.out.println("Seleccionado " + BdvUserController.selected.getIdEmpresa().getBdvCategoriaProductoList());
    }
}
