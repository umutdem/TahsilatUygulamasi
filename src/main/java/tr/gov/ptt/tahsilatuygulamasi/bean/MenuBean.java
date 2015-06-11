package tr.gov.ptt.tahsilatuygulamasi.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.tahsilatuygulamasi.entity.TahsilatMenu;

@ManagedBean
@SessionScoped
public class MenuBean {

    private MenuModel simpleMenuModel = new DefaultMenuModel();
    @ManagedProperty(value="#{tahsilatKisiBean}")
    private TahsilatKisiBean kisiBean;

    public void setKisiBean(TahsilatKisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }
    @PostConstruct
    public void init()
    {
        List<TahsilatMenu> menuList = kisiBean.getKisi().getTahsilatMenuList();

        DefaultSubMenu subMenu = new DefaultSubMenu();
        subMenu.setLabel("Kullanıcı İşlemleri");
        DefaultMenuItem menuItem = null;

        for (TahsilatMenu menuList1 : menuList) {
            menuItem = new DefaultMenuItem();
            menuItem.setValue(menuList1.getBaslik());
            menuItem.setCommand(menuList1.getLink());
            subMenu.addElement(menuItem);
        }        
        simpleMenuModel.addElement(subMenu);        
    }

    public MenuBean() {        
    }

    public MenuModel getSimpleMenuModel() {
        return simpleMenuModel;
    }

}
