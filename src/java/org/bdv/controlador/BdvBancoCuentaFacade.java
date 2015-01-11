/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdv.controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.bdv.modelo.BdvBancoCuenta;

/**
 *
 * @author georgeperez
 */
@Stateless
public class BdvBancoCuentaFacade extends AbstractFacade<BdvBancoCuenta> {
    @PersistenceContext(unitName = "ProveedoresRegistroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BdvBancoCuentaFacade() {
        super(BdvBancoCuenta.class);
    }
    
}
