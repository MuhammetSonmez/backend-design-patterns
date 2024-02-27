package  mylibrarysystem.Entities;

public class Yetkiler {
    private int yetkiID;
    private boolean kitapEkle;
    private boolean kitapGuncelle;
    private boolean kitapSil;
    private boolean kitapAra;
    private boolean oduncAl;
    private boolean oduncIade;
    private KullaniciTuru kullaniciTuru;
    


    public Yetkiler(int yetkiID, boolean kitapEkle, boolean kitapGuncelle, boolean kitapSil, boolean kitapAra,
            boolean oduncAl, boolean oduncIade, KullaniciTuru kullaniciTuru) {
        this.yetkiID = yetkiID;
        this.kitapEkle = kitapEkle;
        this.kitapGuncelle = kitapGuncelle;
        this.kitapSil = kitapSil;
        this.kitapAra = kitapAra;
        this.oduncAl = oduncAl;
        this.oduncIade = oduncIade;
        this.kullaniciTuru = kullaniciTuru;
    }




    public int getYetkiID() {
        return yetkiID;
    }



    public void setYetkiID(int yetkiID) {
        this.yetkiID = yetkiID;
    }



    public boolean isKitapEkle() {
        return kitapEkle;
    }



    public void setKitapEkle(boolean kitapEkle) {
        this.kitapEkle = kitapEkle;
    }



    public boolean isKitapGuncelle() {
        return kitapGuncelle;
    }



    public void setKitapGuncelle(boolean kitapGuncelle) {
        this.kitapGuncelle = kitapGuncelle;
    }



    public boolean isKitapSil() {
        return kitapSil;
    }



    public void setKitapSil(boolean kitapSil) {
        this.kitapSil = kitapSil;
    }



    public boolean isKitapAra() {
        return kitapAra;
    }



    public void setKitapAra(boolean kitapAra) {
        this.kitapAra = kitapAra;
    }



    public boolean isOduncAl() {
        return oduncAl;
    }



    public void setOduncAl(boolean oduncAl) {
        this.oduncAl = oduncAl;
    }



    public boolean isOduncIade() {
        return oduncIade;
    }



    public void setOduncIade(boolean oduncIade) {
        this.oduncIade = oduncIade;
    }



    public KullaniciTuru getKullaniciTuru() {
        return kullaniciTuru;
    }



    public void setKullaniciTuru(KullaniciTuru kullaniciTuru) {
        this.kullaniciTuru = kullaniciTuru;
    }



    public enum KullaniciTuru{
        PERSONEL,
        OGRENCI,
        OGRETIM_UYESI
    }

}
