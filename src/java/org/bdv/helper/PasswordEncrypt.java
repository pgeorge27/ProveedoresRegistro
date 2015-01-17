/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.helper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author georgeperez
 */
@ManagedBean
@RequestScoped
public class PasswordEncrypt {

    /**
     * Creates a new instance of PasswordEncrypt
     */
    public PasswordEncrypt() {
    }
    
    public String Encriptar(String contrasenia) {
        String encript256Hex=DigestUtils.sha256Hex(contrasenia);
        System.out.println("256Hex: " + encript256Hex);
        return encript256Hex;
    }
    
}
