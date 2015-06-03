
package tr.gov.ptt.tahsilatuygulamasi.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatKisi;
import tr.gov.ptt.tahsilatuygulamasi.facade.TahsilatKisiFacade;

@Stateless
public class TahsilatKisiService {
    @EJB
    private TahsilatKisiFacade tahsilatKisiFacade;
    
    public TahsilatKisi giriseYetkilimi(TahsilatKisi p_tahKisi)
    {
        return tahsilatKisiFacade.kisininMenuleriniGetir(p_tahKisi);
    }
}


