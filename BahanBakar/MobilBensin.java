package BahanBakar;

public class MobilBensin extends Mobil {
    public MobilBensin(String id, String merk, String model, String warna, int harga, int tahun) {
        super(id, merk, model, warna, harga, tahun);
    }

    @Override
    public void infoMobil() {
        System.out.println("ID: " + id);
        System.out.println("Merk: " + merk);
        System.out.println("Model: " + model);
        System.out.println("Warna: " + warna);
        System.out.println("Harga: " + harga);
        System.out.println("Tahun: " + tahun);
        System.out.println("Tipe: Bensin");
    }
}
