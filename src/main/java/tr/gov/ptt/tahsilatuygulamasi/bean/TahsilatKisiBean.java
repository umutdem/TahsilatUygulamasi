
package tr.gov.ptt.tahsilatuygulamasi.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatKisi;
import tr.gov.ptt.tahsilatuygulamasi.service.TahsilatKisiService;
import tr.gov.ptt.tahsilatuygulamasi.util.JSFUtil;

@ManagedBean
@SessionScoped
public class TahsilatKisiBean {
    @EJB
    private TahsilatKisiService tahsilatKisiService;
    private TahsilatKisi kisi;
    private List<String> temaListesi;

    public List<String> getTemaListesi() {
        return temaListesi;
    }

    public TahsilatKisi getKisi() {
        return kisi;
    }

    public void setKisi(TahsilatKisi kisi) {
        this.kisi = kisi;
    }

    public TahsilatKisiBean() {
        kisi = new TahsilatKisi();
        if(kisi.getTema() == null)
        {
            kisi.setTema("ui-darkness");
        }
        
        temaListesi = new ArrayList<String>();
        temaListesiDoldur();
    }
    
    public String girisKontrol()
    {
        TahsilatKisi tahKisi =  tahsilatKisiService.giriseYetkilimi(kisi);
        if(tahKisi != null)
        {
            JSFUtil.getSession().setAttribute("username", kisi.getKullaniciAd());
            JSFUtil.getSession().setAttribute("kisi", tahKisi);
            
            this.kisi = tahKisi;
            return "menu.xhtml?faces-redirect=true";
        }
        JSFUtil.hataMesajiEkle("Kullanıcı adı ya da şifre yanlış.");
        return "giris.xhtml?faces-redirect=true";
    }
    
    public String guvenliCikis()
    {
        System.out.println("Session Bitiyor..." + JSFUtil.getSession().getId());
        JSFUtil.getSession().invalidate();        
        return "giris.xhtml?faces-redirect=true";
    }
    
    public void temaListesiDoldur()
    {
        temaListesi.add("ui-darkness");
        temaListesi.add("afterdark");
        temaListesi.add("le-frog");
        temaListesi.add("midnight");
        temaListesi.add("swanky-purse");
        temaListesi.add("glass-x");
        temaListesi.add("casablanca");
        
        
    }
    
    public void temaKaydet()
    {
        tahsilatKisiService.kisiGuncelle(kisi);
    }
    
}
