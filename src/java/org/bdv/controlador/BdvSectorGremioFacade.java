/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.bdv.modelo.BdvSectorGremio;

/**
 *
 * @author georgeperez
 */
@Stateless
public class BdvSectorGremioFacade extends AbstractFacade<BdvSectorGremio> {
    @PersistenceContext(unitName = "ProveedoresRegistroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BdvSectorGremioFacade() {
        super(BdvSectorGremio.class);
    }
    
}
