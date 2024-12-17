package BahanBakar;

public abstract class Mobil {
    protected String id;
    protected String merk;
    protected String model;
    protected String warna;
    protected int harga;
    protected int tahun;

    public Mobil(String id, String merk, String model, String warna, int harga, int tahun) {
        this.id = id;
        this.merk = merk;
        this.model = model;
        this.warna = warna;
        this.harga = harga;
        this.tahun = tahun;
    }
    public abstract void infoMobil() ;
}