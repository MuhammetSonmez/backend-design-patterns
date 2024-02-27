package  mylibrarysystem.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//singlation
public class BaglantiSingleton {

    private static BaglantiSingleton instance;
    private Connection baglanti;

    private BaglantiSingleton() {
    }

    public static BaglantiSingleton getInstance() {
        if (instance == null) {
            instance = new BaglantiSingleton();
        }
        return instance;
    }

    public Connection baglantiyiAl() {
        if (baglanti == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/KutuphaneSistemiOdevi";
                String kullaniciAdi = "root";
                String sifre = "12345";
                baglanti = DriverManager.getConnection(url, kullaniciAdi, sifre);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return baglanti;
    }


}
