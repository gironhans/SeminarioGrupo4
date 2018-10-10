/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.TblGradoEducativo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Seminario
 */
@Stateless
public class TblGradoEducativoFacade extends AbstractFacade<TblGradoEducativo> {

    @PersistenceContext(unitName = "SeminarioGrupo4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblGradoEducativoFacade() {
        super(TblGradoEducativo.class);
    }
    
}
