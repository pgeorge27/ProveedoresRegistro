/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.vista.util;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bdv.helper.RandomManagedBean;

/**
 *
 * @author georgeperez
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        MessageDigest md = null;
//	String password = "password D:";
//        try {
//            
//            String encriptMD5=DigestUtils.md5Hex(password);
//            System.out.println("md5:"+encriptMD5);
//        
//            String encript256Hex=DigestUtils.sha256Hex(password);
//            System.out.println("256Hex:"+encript256Hex);
//            
//            //SHA-512
//            md= MessageDigest.getInstance("SHA-512");
//            md.update(password.getBytes());
//            byte[] mb = md.digest();
//            System.out.println(Hex.encodeHex(mb));
//            
//            //SHA-1
//            md= MessageDigest.getInstance("SHA-1");
//            md.update(password.getBytes());
//            mb = md.digest();
//            System.out.println(Hex.encodeHex(mb));
//            
//            //MD5
//            md= MessageDigest.getInstance("MD5");
//            md.update(password.getBytes());
//            mb = md.digest();
//            System.out.println(Hex.encodeHex(mb));
//            
//        } catch (NoSuchAlgorithmException e) {
//            //Error
//        }
        
//        Locale currentLocale;
//  
//
//  currentLocale = new Locale("es");
//
//
//        
//        File files = new File(ResourceBundle.getBundle("/BundleUpload").getString("Destino")+"prueba");
//        if (files.exists()) {
//            System.out.println("La carpeta ya existe");
//            if (files.mkdirs()) {
//                System.out.println("Multiple directories are created!");
//            } else {
//                System.out.println("Failed to create multiple directories!");
//            }
//        }else{
//            files.mkdir();
//            System.out.println("Archivo creado!");
//        }
        
        RandomManagedBean a = new RandomManagedBean();
        try {
            System.out.println("Clave = " + a.generateRandomString());
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
