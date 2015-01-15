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
import org.bdv.modelo.BdvUserBackend;

/**
 *
 * @author georgeperez
 */
@Stateless
public class BdvUserBackendFacade extends AbstractFacade<BdvUserBackend> {
    @PersistenceContext(unitName = "ProveedoresRegistroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BdvUserBackendFacade() {
        super(BdvUserBackend.class);
    }
    
    public BdvUserBackend obtenerUsuario(String userBackend, String contrasenia){
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("BdvUserBackend.findByUserContrasenia");
            q.setParameter("userBackend", userBackend);
            q.setParameter("contrasenia", contrasenia);
            return (BdvUserBackend) q.getSingleResult();
        } catch (EJBException | NoResultException | NullPointerException e) {
            return null;
        }
    }
}
