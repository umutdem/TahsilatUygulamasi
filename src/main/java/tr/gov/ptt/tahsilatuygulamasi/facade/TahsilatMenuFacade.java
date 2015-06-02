/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatuygulamasi.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatuygulamasi.TahsilatMenu;

/**
 *
 * @author Administrator
 */
@Stateless
public class TahsilatMenuFacade extends AbstractFacade<TahsilatMenu> {
    @PersistenceContext(unitName = "TahsilatUygulamasiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TahsilatMenuFacade() {
        super(TahsilatMenu.class);
    }
    
}
