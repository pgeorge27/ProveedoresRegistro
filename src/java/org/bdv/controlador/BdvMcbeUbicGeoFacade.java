/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bdv.modelo.BdvMcbeUbicGeo;

/**
 *
 * @author georgeperez
 */
@Stateless
public class BdvMcbeUbicGeoFacade extends AbstractFacade<BdvMcbeUbicGeo> {
    @PersistenceContext(unitName = "ProveedoresRegistroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BdvMcbeUbicGeoFacade() {
        super(BdvMcbeUbicGeo.class);
    }
    
    public List<BdvMcbeUbicGeo> obtenerEstado(int idPadre){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("BdvMcbeUbicGeo.findMunicipios");
        q.setParameter("idPadre", idPadre);
        return q.getResultList();
    }
    public List<BdvMcbeUbicGeo> obtenerMunicipio(int idPadre){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("BdvMcbeUbicGeo.findMunicipios");
        q.setParameter("idPadre", idPadre);
        return q.getResultList();
    }
    public List<BdvMcbeUbicGeo> obtenerParroquia(int idPadre){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("BdvMcbeUbicGeo.findMunicipios");
        q.setParameter("idPadre", idPadre);
        return q.getResultList();
    }
    
}
