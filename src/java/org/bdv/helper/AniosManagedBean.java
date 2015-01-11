/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author georgeperez
 */
@ManagedBean
@RequestScoped
public class AniosManagedBean {
    private List<SelectItem> anios;

    public List<SelectItem> getAnios() {
        return anios;
    }

    public void setAnios(List<SelectItem> anios) {
        this.anios = anios;
    }
    
    /**
     * Creates a new instance of AniosManagedBean
     */
    public AniosManagedBean() {
    }
    
    
    public List<SelectItem> getListAnios() {
        anios = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        for (int i = 1900; i < calendar.get(Calendar.YEAR) + 1; i++) {
            anios.add(new SelectItem(i,""+i));
        }
        return anios;
    }
}
