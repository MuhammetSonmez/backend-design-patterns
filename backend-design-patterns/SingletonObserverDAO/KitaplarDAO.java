package  mylibrarysystem.SingletonObserverDAO;

import  mylibrarysystem.Observer.KitapObserver;
import  mylibrarysystem.Singleton.BaglantiSingleton;
import  mylibrarysystem.Entities.Kitaplar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitaplarDAO extends   DAO<Kitaplar>{
    private List<KitapObserver> observers = new ArrayList<>();
    public void addObserver(KitapObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(KitapObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Kitaplar kitaplar) {
        for (KitapObserver observer : observers) {
            observer.update(kitaplar);
        }
    }

    @Override
    public void insert(Kitaplar kitaplar){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Kitaplar kitaplar = new Kitaplar(id, kitapAdi, yazar, konu, durum);

        try {
            String sql = "INSERT INTO Kitaplar (KitapID, KitapAdi,Yazar, Konu , Durum, Stok) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, kitaplar.getKitapID());
                preparedStatement.setString(2, kitaplar.getKitapAdi());
                preparedStatement.setString(3, kitaplar.getYazar());
                preparedStatement.setString(4, kitaplar.getKonu());
                preparedStatement.setString(5, kitaplar.getDurum().toString());
                preparedStatement.setInt(6,kitaplar.getStok());
                preparedStatement.executeUpdate();
                notifyObservers(kitaplar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Kitaplar select(int id) {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        Kitaplar kitaplar = null;

        try {
            String sql = "SELECT * FROM Kitaplar WHERE KitapID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int kitapID = resultSet.getInt("KitapID");
                        String kitapAdi = resultSet.getString("kitapAdi");
                        String yazar = resultSet.getString("Yazar");
                        String konu = resultSet.getString("Konu");
                        String durumStr = resultSet.getString("Durum");
                        Kitaplar.KitapDurumu durum = Kitaplar.KitapDurumu.valueOf(durumStr.toUpperCase().replace("İ", "I"));
                        int stok = resultSet.getInt("Stok");
                        kitaplar = new Kitaplar(kitapID, kitapAdi, yazar, konu, durum,stok);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kitaplar;
    }
    @Override
    public void delete(int id){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();

        try {
            String sql = "DELETE FROM Kitaplar WHERE KitapID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                Kitaplar deletedKitap = select(id);
                notifyObservers(deletedKitap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Kitaplar kitaplar){

        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //Kitaplar kitaplar = new Kitaplar(id, kitapAdi, yazar, konu, durum);

        try {
            String sql = "UPDATE Kitaplar SET KitapAdi = ?, Yazar = ?, Konu = ?,Durum = ?, Stok = ? WHERE KitapID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setString(1, kitaplar.getKitapAdi());
                preparedStatement.setString(2, kitaplar.getYazar());
                preparedStatement.setString(3, kitaplar.getKonu());
                preparedStatement.setString(4, kitaplar.getDurum().toString());
                preparedStatement.setInt(5, kitaplar.getStok());
                preparedStatement.setInt(6, kitaplar.getKitapID());
                preparedStatement.executeUpdate();
                notifyObservers(kitaplar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Kitaplar> selectAll() {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        ArrayList<Kitaplar> kitaplarList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Kitaplar";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int kitapID = resultSet.getInt("KitapID");
                    String kitapAdi = resultSet.getString("KitapAdi");
                    String yazar = resultSet.getString("Yazar");
                    String konu = resultSet.getString("Konu");
                    String durumStr = resultSet.getString("Durum");
                    Kitaplar.KitapDurumu durum = Kitaplar.KitapDurumu.valueOf(durumStr.toUpperCase().replace("İ", "I"));
                    int stok = resultSet.getInt("Stok");

                    Kitaplar kitaplar = new Kitaplar(kitapID, kitapAdi, yazar, konu, durum,stok);
                    kitaplarList.add(kitaplar);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kitaplarList;
    }

    public void insert(String text, String text0, Object selectedItem, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
