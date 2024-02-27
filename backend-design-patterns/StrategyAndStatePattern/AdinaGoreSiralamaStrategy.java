package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public class AdinaGoreSiralamaStrategy implements KitapSiralamaStrategy{

    @Override
    public void sort(List<Kitaplar> kitaplar){
        kitaplar.sort((b1,b2) -> b1.getKitapAdi().compareTo(b2.getKitapAdi()));
    }
}
