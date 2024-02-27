# backend-design-patterns
 design patterns


## Factory Design Pattern

Proje içindeki FactoryDesign klasöründe kullanılmıştır.
Amaç, nesne oluşturma sürecini bir sınıfa veya bir sınıf ailesine izole etmektir.
Örneğin, UserFactory sınıfı farklı kullanıcı türlerine göre uygun kullanıcı nesneleri oluşturur (Ogrenci, OgretimGorevlisi, Personel).

## Observer Design Pattern

Proje içindeki Observer klasöründe kullanılmıştır.
Amaç, nesneler arasında bir bağımlılık kurmak ve bir nesnenin durumu değiştiğinde diğer nesnelerin otomatik olarak güncellenmesini sağlamaktır.
Örneğin, KitapObserver sınıfı, kitap durumlarını izler ve bu durumlar değiştiğinde diğer bileşenlere bildirim gönderir.

## Singleton Design Pattern

Proje içindeki Singleton ve SingletonObserverDAO klasörlerinde kullanılmıştır.
Amaç, bir sınıfın yalnızca bir örneğine izin vermek ve bu örneğe global erişim sağlamaktır.
Örneğin, BaglantiSingleton sınıfı, tek bir veritabanı bağlantısı örneği oluşturur ve tüm uygulama boyunca bu örneğe erişim sağlar.

## Strategy Design Pattern ve State Design Pattern

Proje içindeki StrategyAndStatePattern klasöründe kullanılmıştır.
Amaç, bir algoritma ailesini tanımlamak ve bu algoritmaları birbiriyle değiştirilebilir hale getirmektir.
Örneğin, AdinaGoreSiralamaStrategy, KonuyaGoreSirala, ve YazaraGoreSirala sınıfları farklı sıralama stratejilerini temsil ederken, KitaplarState, KayipKitaplarState, RaftaKitaplarState, ve OduncKitaplarState sınıfları farklı kitap durumlarını temsil eder ve bu durumlara göre davranışlarını değiştirir.


## DAO (Data Access Object) Design Pattern
Proje içindeki SingletonObserverDAO klasöründe kullanılmıştır.
Amaç, veri kaynağına erişimi soyutlamak ve veritabanı işlemlerini ayrı bir katmana taşımaktır.
Örneğin, KitaplarDAO, KullanicilarDAO, OduncAlinanlarDAO, ve YetkilerDAO sınıfları, ilgili veri tabanı tablolarına erişim sağlayan veri erişim nesnelerini temsil eder. Bu sınıflar, veritabanı işlemlerini gerçekleştirirken diğer katmanlardan gelen istekleri karşılar ve verilerin güncellenmesini, ekleme yapılmasını veya sorgulanmasını sağlar. Bu sayede, veritabanı işlemleri diğer kod parçalarından ayrı tutulur ve yeniden kullanılabilirlik ve bakım kolaylığı sağlanır.




