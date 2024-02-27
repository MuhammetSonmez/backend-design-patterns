package  mylibrarysystem.FactoryDesign;

public class UserFactory {

    public User kullaniciOlustur(String tip){
        if (tip == "ogrenci"){
            return new Ogrenci();
        }else if (tip == "ogretim gorevlisi"){
            return new OgretimGorevlisi();
        } else if (tip == "personel"){
            return new Personel();
        }

        return null;
    }



}
