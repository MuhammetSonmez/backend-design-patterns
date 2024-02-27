package  mylibrarysystem.FactoryDesign;

import  mylibrarysystem.Entities.Yetkiler;
import  mylibrarysystem.SingletonObserverDAO.YetkilerDAO;

public class Personel implements User{
    @Override
    public Yetkiler createYetki(){

        YetkilerDAO dao = new YetkilerDAO();
        Yetkiler yetki = dao.select(1);
        System.out.println(yetki.getKullaniciTuru());
        return yetki;
    }
}
