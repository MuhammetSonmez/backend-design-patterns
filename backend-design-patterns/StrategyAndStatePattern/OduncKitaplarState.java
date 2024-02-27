package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public class OduncKitaplarState implements KitaplarState{
    @Override
    public void kitapGoruntule(List<Kitaplar> kitaplar){
        System.out.println("Odunc kitaplar:");
        for(Kitaplar kitap: kitaplar){
            if (kitap.getDurum() == Kitaplar.KitapDurumu.ODUNC_ALINDI){
                displayKitap(kitap);
            }
        }
    }

    @Override
    public void displayKitap(Kitaplar kitap){
        System.out.println("id: " + kitap.getKitapID()
                +"\nkitap adi: "+kitap.getKitapAdi() +"\nyazar: "+ kitap.getYazar()+"\nkitap adi: "+kitap.getKitapAdi() +"\ndurum: " + kitap.getDurum().toString()+"\nstok: "+kitap.getStok());
    }
}
