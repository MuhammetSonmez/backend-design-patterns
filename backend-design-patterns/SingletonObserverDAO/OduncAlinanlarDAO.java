package  mylibrarysystem.SingletonObserverDAO;
import  mylibrarysystem.Singleton.BaglantiSingleton;
import  mylibrarysystem.Entities.OduncAlinanlar;
import java.sql.*;

public class OduncAlinanlarDAO extends DAO<OduncAlinanlar> {

    @Override
    public void insert(OduncAlinanlar oduncAlinanlar){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //OduncAlinanlar oduncAlinanlar = new OduncAlinanlar(id, kullaniciID, kitapID, oduncTarihi, iadeTarihi);

        try {
            String sql = "INSERT INTO OduncAlinanlar (OduncID, KullaniciID,KitapID, OduncTarihi , IadeTarihi) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, oduncAlinanlar.getOduncID());
                preparedStatement.setInt(2, oduncAlinanlar.getKullaniciID());
                preparedStatement.setInt(3, oduncAlinanlar.getKitapID());
                preparedStatement.setDate(4, new java.sql.Date(oduncAlinanlar.getOduncTarihi().getTime()));
                preparedStatement.setDate(5, new java.sql.Date(oduncAlinanlar.getIadeTarihi().getTime()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public OduncAlinanlar select(int id) {
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        OduncAlinanlar oduncAlinanlar = null;

        try {
            String sql = "SELECT * FROM OduncAlinanlar WHERE OduncID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int oduncID = resultSet.getInt("OduncID");
                        int kullaniciID = resultSet.getInt("KullaniciID");
                        int kitapID = resultSet.getInt("KitapID");
                        Date oduncTarihi  = resultSet.getDate("OduncTarihi");
                        Date iadeTarihi = resultSet.getDate("IadeTarihi");

                        oduncAlinanlar = new OduncAlinanlar(oduncID, kullaniciID, kitapID,oduncTarihi, iadeTarihi);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oduncAlinanlar;
    }

    @Override
    public void delete(int id){
        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();

        try {
            String sql = "DELETE FROM OduncAlinanlar WHERE OduncID = ?";
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
    public void update(OduncAlinanlar oduncAlinanlar){

        BaglantiSingleton baglantiSinglaton = BaglantiSingleton.getInstance();
        Connection baglanti = baglantiSinglaton.baglantiyiAl();
        //OduncAlinanlar oduncAlinanlar = new OduncAlinanlar(id, kullaniciID, kitapID, oduncTarihi, iadeTarihi);

        try {
            String sql = "UPDATE OduncAlinanlar SET KullaniciID = ?, KitapID = ?, OduncTarihi = ?,IadeTarihi= ? WHERE OduncID = ?";
            try (PreparedStatement preparedStatement = baglanti.prepareStatement(sql)) {
                preparedStatement.setInt(5, oduncAlinanlar.getOduncID());
                preparedStatement.setInt(1, oduncAlinanlar.getKullaniciID());
                preparedStatement.setInt(2, oduncAlinanlar.getKitapID());
                preparedStatement.setDate(3, oduncAlinanlar.getOduncTarihi());
                preparedStatement.setDate(4, oduncAlinanlar.getIadeTarihi());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
