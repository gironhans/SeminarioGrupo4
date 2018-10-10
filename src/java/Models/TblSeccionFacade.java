/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.TblSeccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Seminario
 */
@Stateless
public class TblSeccionFacade extends AbstractFacade<TblSeccion> {

    @PersistenceContext(unitName = "SeminarioGrupo4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblSeccionFacade() {
        super(TblSeccion.class);
    }
    
}
