
package tr.gov.ptt.tahsilatuygulamasi.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatKurum;
import tr.gov.ptt.tahsilatuygulamasi.facade.TahsilatKurumFacade;

@Stateless
public class TahsilatBorcService {
    
    @EJB
    private TahsilatKurumFacade tahsilatKurumFacade;
    public List<String> kurumAdlariGetir(String query)
    {
        List <TahsilatKurum> kurumList = tahsilatKurumFacade.findAll();
        List kurumAdiList = new ArrayList<String>();
        for (TahsilatKurum kurum : kurumList) {
            if(kurum.getAd().toUpperCase().contains(query.toUpperCase()))
            {
                kurumAdiList.add(kurum.getAd());
            }            
        }
        
        
        return kurumAdiList;
    }
}
