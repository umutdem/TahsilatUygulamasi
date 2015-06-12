/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatuygulamasi.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatBorc;

/**
 *
 * @author Administrator
 */
@Stateless
public class TahsilatBorcFacade extends AbstractFacade<TahsilatBorc> {
    @PersistenceContext(unitName = "TahsilatUygulamasiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TahsilatBorcFacade() {
        super(TahsilatBorc.class);
    }
    
}
