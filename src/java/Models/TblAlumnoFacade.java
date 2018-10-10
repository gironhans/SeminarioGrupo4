/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.TblAlumno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Seminario
 */
@Stateless
public class TblAlumnoFacade extends AbstractFacade<TblAlumno> {

    @PersistenceContext(unitName = "SeminarioGrupo4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAlumnoFacade() {
        super(TblAlumno.class);
    }
    
}
