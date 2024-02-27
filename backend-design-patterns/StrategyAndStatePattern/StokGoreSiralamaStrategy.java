package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public class StokGoreSiralamaStrategy implements KitapSiralamaStrategy{

    @Override
    public void sort(List<Kitaplar> kitaplar) {
        kitaplar.sort((b1, b2) -> Integer.compare(b1.getStok(), b2.getStok()));
    }
}
