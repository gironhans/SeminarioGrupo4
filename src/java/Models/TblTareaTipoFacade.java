/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.TblTareaTipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Seminario
 */
@Stateless
public class TblTareaTipoFacade extends AbstractFacade<TblTareaTipo> {

    @PersistenceContext(unitName = "SeminarioGrupo4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTareaTipoFacade() {
        super(TblTareaTipo.class);
    }
    
}
