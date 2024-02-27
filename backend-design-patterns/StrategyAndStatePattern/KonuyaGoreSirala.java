package  mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;

import java.util.List;

public class KonuyaGoreSirala implements KitapSiralamaStrategy{

    @Override
    public void sort(List<Kitaplar> kitaplar){
        kitaplar.sort((b1,b2)-> b1.getKonu().compareTo(b2.getKonu()));
    }


}
