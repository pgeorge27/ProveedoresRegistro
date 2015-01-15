/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.helper;

import java.util.Properties;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author georgeperez
 */
@ManagedBean
@NoneScoped
public class SendMail {
    
    private Session session;
    

    /**
     * Creates a new instance of SendMail
     */
    public SendMail() {
    }
    
    public SendMail(String email) {
        prepareEmail();
        enviarEmail(email);
    }
    
    public SendMail(String email, String quien) {
        if(quien.equalsIgnoreCase("admin")){
            prepareEmail();
            enviarEmailAdmin();
        }else if(quien.equalsIgnoreCase("recuperar")){
            prepareEmail();
            enviarEmailRecuperar();
        }else if(quien.equalsIgnoreCase("aprobado")){
            prepareEmail();
            enviarEmailAprobado();
        }else if(quien.equalsIgnoreCase("notificacion")){
            prepareEmail();
            enviarEmailNotificacion();
        }
    }
    
    
    private void enviarEmailAdmin(){
        
    }
    private void enviarEmailRecuperar(){
        
    }
    private void enviarEmailAprobado(){
        
    }
    private void enviarEmailNotificacion(){
        
    }
    private void enviarEmail(String email){        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ResourceBundle.getBundle("/Bundle").getString("EmailFrom")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(ResourceBundle.getBundle("/Bundle").getString("EmailSubject"));
             // Send the actual HTML message, as big as you like
            message.setContent(ResourceBundle.getBundle("/Bundle").getString("EmailValidar"),
                            "text/html" );
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void prepareEmail(){
    Properties props = new Properties();
        props.put("mail.smtp.host", ResourceBundle.getBundle("/Bundle").getString("EmailHost"));
        props.put("mail.smtp.socketFactory.port", ResourceBundle.getBundle("/Bundle").getString("EmailPort"));
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", ResourceBundle.getBundle("/Bundle").getString("EmailAuth"));
        props.put("mail.smtp.port", ResourceBundle.getBundle("/Bundle").getString("EmailPort"));
        
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ResourceBundle.getBundle("/Bundle").getString("EmailUsuario"),
                            ResourceBundle.getBundle("/Bundle").getString("EmailContrasenia"));
                    }
                });
    }
}
