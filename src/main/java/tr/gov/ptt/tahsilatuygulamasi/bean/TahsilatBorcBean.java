
package tr.gov.ptt.tahsilatuygulamasi.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatBorc;
import tr.gov.ptt.tahsilatuygulamasi.service.TahsilatBorcService;


@ManagedBean
@SessionScoped
public class TahsilatBorcBean {
    private TahsilatBorc borc;
    @EJB
    private TahsilatBorcService tahsilatBorcService;

    public TahsilatBorc getBorc() {
        return borc;
    }

    public void setBorc(TahsilatBorc borc) {
        this.borc = borc;
    }

    public TahsilatBorcBean() {
        borc = new TahsilatBorc();
    }
    
    public String sorgula()
    {
        return "faturaListele.xhtml?faces-redirect=true";
    }
    
    public List<String> kurumAdiTamamla(String query)
    {
        return tahsilatBorcService.kurumAdlariGetir(query);
    }
}
