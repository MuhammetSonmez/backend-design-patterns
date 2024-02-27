package mylibrarysystem.StrategyAndStatePattern;

import  mylibrarysystem.Entities.Kitaplar;
import java.util.List;
public interface KitaplarState {
    void kitapGoruntule(List<Kitaplar> kitap);
    void displayKitap(Kitaplar kitap);

}
