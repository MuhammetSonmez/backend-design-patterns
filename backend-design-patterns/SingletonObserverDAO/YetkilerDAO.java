package  mylibrarysystem.SingletonObserverDAO;
import  mylibrarysystem.Singleton.BaglantiSingleton;
import  mylibrarysystem.Entities.Yetkiler;

import java.sql.*;

public class YetkilerDAO extends DAO<Yetkiler> {

    @Override
    public void insert(Yetkiler yetkiler){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Yetkiler yetkiler = new Yetkiler(id, kitapEkle, kitapGuncelle, kitapSil, kitapAra, oduncAl, oduncIade, kullaniciTuru);

        try {
            String sql = "INSERT INTO Yetkiler (YetkiID, KitapEkle,KitapGuncelle, KitapSil , KitapAra, OduncAl, OduncIade, KullaniciTuru) VALUES (?, ?, ?, ?, ?,?,?,?)";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, yetkiler.getYetkiID());
                preparedStatement.setBoolean(2, yetkiler.isKitapEkle());
                preparedStatement.setBoolean(3, yetkiler.isKitapGuncelle());
                preparedStatement.setBoolean(4, yetkiler.isKitapSil());
                preparedStatement.setBoolean(5,yetkiler.isKitapAra());
                preparedStatement.setBoolean(6,yetkiler.isOduncAl());
                preparedStatement.setBoolean(7,yetkiler.isOduncIade());
                preparedStatement.setString(5, yetkiler.getKullaniciTuru().toString());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Yetkiler select(int yetkiID) {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        Yetkiler yetkiler = null;

        try {
            String sql = "SELECT * FROM Yetkiler WHERE YetkiID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, yetkiID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        boolean kitapEkle = resultSet.getBoolean("KitapEkle");
                        boolean kitapGuncelle = resultSet.getBoolean("KitapGuncelle");
                        boolean kitapSil = resultSet.getBoolean("KitapSil");
                        boolean kitapAra = resultSet.getBoolean("KitapAra");
                        boolean oduncAl = resultSet.getBoolean("OduncAl");
                        boolean oduncIade = resultSet.getBoolean("OduncIade");
                        String kullaniciTuruStr = resultSet.getString("KullaniciTuru");
                        Yetkiler.KullaniciTuru kullaniciTuru = Yetkiler.KullaniciTuru.valueOf(kullaniciTuruStr.toUpperCase().replace("İ", "I")
                                .replace("Ö","O").replace("Ü", "U"));
                        yetkiler = new Yetkiler(yetkiID, kitapEkle, kitapGuncelle, kitapSil, kitapAra, oduncAl, oduncIade, kullaniciTuru);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return yetkiler;
    }
    @Override
    public void delete(int id){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();

        try {
            String sql = "DELETE FROM Yetkiler WHERE OduncID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                System.out.println("Kayıt başarıyla silindi.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Yetkiler yetkiler) {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();

        try {
            String sql = "UPDATE Yetkiler SET KitapEkle=?, KitapGuncelle=?, KitapSil=?, KitapAra=?, OduncAl=?, OduncIade=?, KullaniciTuru=? WHERE YetkiID=?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setBoolean(1, yetkiler.isKitapEkle());
                preparedStatement.setBoolean(2, yetkiler.isKitapGuncelle());
                preparedStatement.setBoolean(3, yetkiler.isKitapSil());
                preparedStatement.setBoolean(4, yetkiler.isKitapAra());
                preparedStatement.setBoolean(5, yetkiler.isOduncAl());
                preparedStatement.setBoolean(6, yetkiler.isOduncIade());
                preparedStatement.setString(7, yetkiler.getKullaniciTuru().toString());
                preparedStatement.setInt(8, yetkiler.getYetkiID());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
