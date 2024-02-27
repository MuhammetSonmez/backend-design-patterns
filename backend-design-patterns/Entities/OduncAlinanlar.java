package  mylibrarysystem.Entities;

import java.sql.Date;

public class OduncAlinanlar {
    private int oduncID;
    private int kullaniciID;
    private int kitapID;
    public Date oduncTarihi;
    private Date iadeTarihi;

    public OduncAlinanlar(int oduncID, int kullaniciID, int kitapID, Date oduncTarihi, Date iadeTarihi) {
        this.oduncID = oduncID;
        this.kullaniciID = kullaniciID;
        this.kitapID = kitapID;
        this.oduncTarihi = oduncTarihi;
        this.iadeTarihi = iadeTarihi;
    }
    
    public int getOduncID() {
        return oduncID;
    }
    public void setOduncID(int oduncID) {
        this.oduncID = oduncID;
    }
    public int getKullaniciID() {
        return kullaniciID;
    }
    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }
    public int getKitapID() {
        return kitapID;
    }
    public void setKitapID(int kitapID) {
        this.kitapID = kitapID;
    }
    public Date getOduncTarihi() {
        return oduncTarihi;
    }
    public void setOduncTarihi(Date oduncTarihi) {
        this.oduncTarihi = oduncTarihi;
    }
    public Date getIadeTarihi() {
        return iadeTarihi;
    }
    public void setIadeTarihi(Date iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }

}
