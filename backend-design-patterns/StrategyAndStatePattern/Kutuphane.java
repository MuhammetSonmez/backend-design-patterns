package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public class Kutuphane {
    private KitapSiralamaStrategy siralamaStrategy;

    public Kutuphane(){

    }

    public void setSortingStrategy(KitapSiralamaStrategy siralamaStrategy){
        this.siralamaStrategy = siralamaStrategy;
    }

    public void kitaplariListele(List<Kitaplar> kitaplar){
        siralamaStrategy.sort(kitaplar);
        for (Kitaplar kitap:kitaplar){
            displayKitap(kitap);
        }

    }
    public void displayKitap(Kitaplar kitap){
        System.out.println("id: " + kitap.getKitapID()
                +"\nkitap adi: "+kitap.getKitapAdi() +"\nyazar: "+ kitap.getYazar()+"\nkitap adi: "+kitap.getKitapAdi() +"\ndurum: " + kitap.getDurum().toString()+"\nstok: "+kitap.getStok());
    }

    private KitaplarState durum;

    public void setState(KitaplarState state){
        this.durum = state;
    }
    public void kitaplarınGuncelDurumunuListele(List<Kitaplar> kitaplar){
        durum.kitapGoruntule(kitaplar);
    }

}
