
package tr.gov.ptt.tahsilatuygulamasi.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tr.gov.ptt.tahsilatuygulamasi.TahsilatKisi;
import tr.gov.ptt.tahsilatuygulamasi.service.TahsilatKisiService;

@ManagedBean
@ViewScoped
public class TahsilatKisiBean {
    @EJB
    private TahsilatKisiService tahsilatKisiService;
    
    private TahsilatKisi kisi;

    public TahsilatKisi getKisi() {
        return kisi;
    }

    public void setKisi(TahsilatKisi kisi) {
        this.kisi = kisi;
    }

    public TahsilatKisiBean() {
        kisi = new TahsilatKisi();
    }
    
    public String girisKontrol()
    {
        return null;
    }
    
    
}
