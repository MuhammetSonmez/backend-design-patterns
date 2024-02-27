package mylibrarysystem.Entities;

public class Kullanicilar {
    private int kullaniciID;
    private String kullaniciAdi;
    private String sifre;
    private KullaniciTuru kullaniciTuru;
    private String tel;
    private String soyisim;

    private String tc;
    private String mail;

    private long ogrNo;
    private String bolum;

    public Kullanicilar(int kullaniciID, String kullaniciAdi, String sifre, KullaniciTuru kullaniciTuru, String tel, String soyisim, String tc, String mail) {
        this.kullaniciID = kullaniciID;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.kullaniciTuru = kullaniciTuru;
        this.tel = tel;
        this.soyisim = soyisim;
        this.tc = tc;
        this.mail = mail;
    }
    public Kullanicilar(int kullaniciID, String kullaniciAdi, String sifre, KullaniciTuru kullaniciTuru, String tel, String soyisim, String tc, String mail, long ogrNo,String bolum) {
        this.kullaniciID = kullaniciID;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.kullaniciTuru = kullaniciTuru;
        this.tel = tel;
        this.soyisim = soyisim;
        this.tc = tc;
        this.mail = mail;
        this.ogrNo = ogrNo;
        this.bolum = bolum;
    }

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public KullaniciTuru getKullaniciTuru() {
        return kullaniciTuru;
    }

    public void setKullaniciTuru(KullaniciTuru kullaniciTuru) {
        this.kullaniciTuru = kullaniciTuru;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public long getOgrNo() {
        return ogrNo;
    }

    public void setOgrNo(long ogrNo) {
        this.ogrNo = ogrNo;
    }

    public enum KullaniciTuru {
        PERSONEL,
        OGRENCI,
        OGRETIM_UYESI
    }

}




