
package tr.gov.ptt.tahsilatuygulamasi.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatKisi;
import tr.gov.ptt.tahsilatuygulamasi.service.TahsilatKisiService;
import tr.gov.ptt.tahsilatuygulamasi.util.JSFUtil;

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
        TahsilatKisi tahKisi =  tahsilatKisiService.giriseYetkilimi(kisi);
        if(tahKisi != null)
        {
            JSFUtil.getSession().setAttribute("username", kisi.getKullaniciAd());
            return "menu.xhtml?faces-redirect=true";
        }
        JSFUtil.hataMesajiEkle("Kullanıcı adı ya da şifre yanlış.");
        return "giris.xhtml?faces-redirect=true";
    }
    
    
}
