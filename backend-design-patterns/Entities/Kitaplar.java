package mylibrarysystem.Entities;

public class Kitaplar {


    private int kitapID;
    private String kitapAdi;
    private String yazar;
    private String konu;
    private KitapDurumu durum;

    private int stok;


    public Kitaplar(int kitapID, String kitapAdi, String yazar, String konu, KitapDurumu durum,int stok) {
        this.kitapID = kitapID;
        this.kitapAdi = kitapAdi;
        this.yazar = yazar;
        this.konu = konu;
        this.durum = durum;
        this.stok = stok;
    }



    public int getKitapID() {
        return kitapID;
    }



    public void setKitapID(int kitapID) {
        this.kitapID = kitapID;
    }



    public String getKitapAdi() {
        return kitapAdi;
    }



    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }



    public String getYazar() {
        return yazar;
    }



    public void setYazar(String yazar) {
        this.yazar = yazar;
    }



    public String getKonu() {
        return konu;
    }



    public void setKonu(String konu) {
        this.konu = konu;
    }



    public KitapDurumu getDurum() {
        return durum;
    }



    public void setDurum(KitapDurumu durum) {
        this.durum = durum;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Object getKategori() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getBasimYili() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public enum KitapDurumu {
        RAFTA,
        ODUNC_ALINDI,
        KAYIP
    }
}