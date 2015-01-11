/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.controlador;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bdv.modelo.BdvUser;

/**
 *
 * @author georgeperez
 */
@Stateless
public class BdvUserFacade extends AbstractFacade<BdvUser> {
    @PersistenceContext(unitName = "ProveedoresRegistroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BdvUserFacade() {
        super(BdvUser.class);
    }
    
     public BdvUser obtenerUsuario(String email, String contrasenia){
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("BdvUser.findByEmailAndContrasenia");
            q.setParameter("email", email);
            q.setParameter("contrasenia", contrasenia);
            return (BdvUser) q.getSingleResult();
        } catch (EJBException | NoResultException | NullPointerException e) {
            return null;
        }
    }
    
    public BdvUser obtenerUsuario(String email){
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("BdvUser.findByEmail");
            q.setParameter("email", email);
            return (BdvUser) q.getSingleResult();
        } catch (EJBException | NoResultException | NullPointerException e) {
            return null;
        }
    }
    
}
