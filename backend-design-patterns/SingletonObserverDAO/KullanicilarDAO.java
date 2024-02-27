package  mylibrarysystem.SingletonObserverDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import  java.sql.ResultSet;

import  mylibrarysystem.Singleton.BaglantiSingleton;


import  mylibrarysystem.Entities.Kullanicilar;
public class KullanicilarDAO extends DAO<Kullanicilar> {

    public void updateOgr(Kullanicilar kullanici){

        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Kullanicilar kullanici = new Kullanicilar(id, name, password, kullaniciTuru);

        try {
            String sql = "UPDATE Kullanicilar SET KullaniciAdi = ?, Sifre = ?, kullaniciTuru = ?, Tel = ?, Soyisim = ?, Tc = ?, Mail = ?,OgrNo = ?, Bolum = ? WHERE KullaniciID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {

                preparedStatement.setString(1, kullanici.getKullaniciAdi());
                preparedStatement.setString(2, kullanici.getSifre());
                preparedStatement.setString(3, kullanici.getKullaniciTuru().toString());
                preparedStatement.setString(4,kullanici.getTel());
                preparedStatement.setString(5, kullanici.getSoyisim());
                preparedStatement.setString(6, kullanici.getTc());
                preparedStatement.setString(7, kullanici.getMail());
                preparedStatement.setLong(8, kullanici.getOgrNo());
                preparedStatement.setString(9, kullanici.getBolum());
                preparedStatement.setInt(10, kullanici.getKullaniciID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertOgr(Kullanicilar kullanici){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Kullanicilar kullanici = new Kullanicilar(id, name, password, kullaniciTuru);

        try {
            String sql = "INSERT INTO Kullanicilar (KullaniciID, KullaniciAdi, Sifre, kullaniciTuru,Tel, Soyisim, Tc, Mail,OgrNo, Bolum) VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, kullanici.getKullaniciID());
                preparedStatement.setString(2, kullanici.getKullaniciAdi());
                preparedStatement.setString(3, kullanici.getSifre());
                preparedStatement.setString(4, kullanici.getKullaniciTuru().toString());
                preparedStatement.setString(5,kullanici.getTel());
                preparedStatement.setString(6, kullanici.getSoyisim());
                preparedStatement.setString(7, kullanici.getTc());
                preparedStatement.setString(8,kullanici.getMail());
                preparedStatement.setLong(9, kullanici.getOgrNo());
                preparedStatement.setString(10, kullanici.getBolum());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Kullanicilar selectOgr(int id) {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        Kullanicilar kullanici = null;

        try {
            String sql = "SELECT * FROM Kullanicilar WHERE KullaniciID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int kullaniciID = resultSet.getInt("KullaniciID");
                        String kullaniciAdi = resultSet.getString("KullaniciAdi");
                        String sifre = resultSet.getString("Sifre");
                        String kullaniciTuruStr = resultSet.getString("kullaniciTuru");
                        Kullanicilar.KullaniciTuru kullaniciTuru = Kullanicilar.KullaniciTuru.valueOf(kullaniciTuruStr.toUpperCase().replace("Ö", "O").replace("İ", "I")
                                .replace("Ü", "U"));
                        String tel = resultSet.getString("Tel");
                        String soyisim = resultSet.getString("Soyisim");
                        String tc = resultSet.getString("Tc");
                        String mail = resultSet.getString("Mail");
                        long ogrNo = resultSet.getLong("OgrNo");
                        String bolum = resultSet.getString("Bolum");

                        kullanici = new Kullanicilar(kullaniciID, kullaniciAdi, sifre, kullaniciTuru,tel, soyisim ,tc, mail,ogrNo,bolum);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kullanici;
    }


    @Override
    public void insert(Kullanicilar kullanici){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Kullanicilar kullanici = new Kullanicilar(id, name, password, kullaniciTuru);

        try {
            String sql = "INSERT INTO Kullanicilar (KullaniciID, KullaniciAdi, Sifre, kullaniciTuru,Tel, Soyisim, Tc, Mail) VALUES (?, ?, ?, ?,?,?,?,?)";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, kullanici.getKullaniciID());
                preparedStatement.setString(2, kullanici.getKullaniciAdi());
                preparedStatement.setString(3, kullanici.getSifre());
                preparedStatement.setString(4, kullanici.getKullaniciTuru().toString());
                preparedStatement.setString(5,kullanici.getTel());
                preparedStatement.setString(6, kullanici.getSoyisim());
                preparedStatement.setString(7, kullanici.getTc());
                preparedStatement.setString(8,kullanici.getMail());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override

    public Kullanicilar select(int id) {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        Kullanicilar kullanici = null;

        try {
            String sql = "SELECT * FROM Kullanicilar WHERE KullaniciID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int kullaniciID = resultSet.getInt("KullaniciID");
                        String kullaniciAdi = resultSet.getString("KullaniciAdi");
                        String sifre = resultSet.getString("Sifre");
                        String kullaniciTuruStr = resultSet.getString("kullaniciTuru");
                        Kullanicilar.KullaniciTuru kullaniciTuru = Kullanicilar.KullaniciTuru.valueOf(kullaniciTuruStr.toUpperCase().replace("Ö", "O").replace("İ", "I")
                                .replace("Ü", "U"));
                        String tel = resultSet.getString("Tel");
                        String soyisim = resultSet.getString("Soyisim");
                        String tc = resultSet.getString("Tc");
                        String mail = resultSet.getString("Mail");

                        kullanici = new Kullanicilar(kullaniciID, kullaniciAdi, sifre, kullaniciTuru,tel, soyisim ,tc, mail);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kullanici;
    }
    @Override
    public void delete(int id){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();

        try {
            String sql = "DELETE FROM Kullanicilar WHERE KullaniciID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                System.out.println("Kullanıcı başarıyla silindi.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void update(Kullanicilar kullanici){

        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Kullanicilar kullanici = new Kullanicilar(id, name, password, kullaniciTuru);

        try {
            String sql = "UPDATE Kullanicilar SET KullaniciAdi = ?, Sifre = ?, kullaniciTuru = ?, Tel = ?, Soyisim = ?, Tc = ?, Mail = ? WHERE KullaniciID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {

                preparedStatement.setString(1, kullanici.getKullaniciAdi());
                preparedStatement.setString(2, kullanici.getSifre());
                preparedStatement.setString(3, kullanici.getKullaniciTuru().toString());
                preparedStatement.setString(4,kullanici.getTel());
                preparedStatement.setString(5, kullanici.getSoyisim());
                preparedStatement.setString(6, kullanici.getTc());
                preparedStatement.setString(7, kullanici.getMail());
                preparedStatement.setInt(8, kullanici.getKullaniciID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
