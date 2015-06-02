
package tr.gov.ptt.tahsilatuygulamasi.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.tahsilatuygulamasi.util.JSFUtil;



@ManagedBean
@SessionScoped
public class MenuBean {
    
    private MenuModel simpleMenuModel = new DefaultMenuModel();
   
    public MenuBean() {
        
        DefaultSubMenu subMenu = new DefaultSubMenu();
        subMenu.setLabel("Kullanıcı İşlemleri");
        
        DefaultMenuItem menuItem = new DefaultMenuItem();
        menuItem.setValue("Tahsilat Giriş");
        menuItem.setUrl("giris.xhtml");
        subMenu.addElement(menuItem);
        //simpleMenuModel.addElement(menuItem);
       
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Raporlar");
        menuItem.setUrl("raporlar.xhtml");
        subMenu.addElement(menuItem);
        
        simpleMenuModel.addElement(subMenu);
        
        subMenu = new DefaultSubMenu();
        subMenu.setLabel("Yönetim İşlemleri");
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Tahsilat İptal");
        menuItem.setUrl("tahsilatIptal.xhtml");
        subMenu.addElement(menuItem);
        
        simpleMenuModel.addElement(subMenu);       
    }
    
    public MenuModel getSimpleMenuModel() {
        return simpleMenuModel;
    }
    
}
