package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public interface KitapSiralamaStrategy {
    void sort(List<Kitaplar> kitaplar);

}
