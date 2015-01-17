/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author georgeperez
 */
@ManagedBean
@RequestScoped
public class PasswordValidator {

    /**
     * Creates a new instance of PasswordValidator
     */
    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!*&^&]).{8,40})";

    public PasswordValidator() {
        System.out.println("En el Constructor");
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String password) {
        System.out.println("Clave es " + password);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
