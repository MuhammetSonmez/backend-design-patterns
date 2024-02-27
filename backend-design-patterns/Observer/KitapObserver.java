package  mylibrarysystem.Observer;

import  mylibrarysystem.Entities.Kitaplar;

public class KitapObserver {
    public void update(Kitaplar kitaplar) {
        System.out.println("Bildirim: Kitap güncellendi - " + kitaplar.getKitapAdi());
        // Burada kullanıcıya bildirim gönderme veya başka bir işlem yapabilirsiniz.
    }
}
