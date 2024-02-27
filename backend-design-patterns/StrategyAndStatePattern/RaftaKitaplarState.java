package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public class RaftaKitaplarState implements KitaplarState{
    @Override
    public void kitapGoruntule(List<Kitaplar> kitaplar){
        System.out.println("Rafta kitaplar:");
        for(Kitaplar kitap: kitaplar){
            if (kitap.getDurum() == Kitaplar.KitapDurumu.RAFTA){
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
