package GusDealer;

import BahanBakar.Mobil;

import java.util.Date;

public class Transaksi {
    private String idTransaksi;
    private Mobil mobil;
    private String pembeli;
    private Date tanggalTransaksi;
    private int hargaJual;

    public Transaksi(String idTransaksi, Mobil mobil, String pembeli, Date tanggalTransaksi, int hargaJual) {
        this.idTransaksi = idTransaksi;
        this.mobil = mobil;
        this.pembeli = pembeli;
        this.tanggalTransaksi = tanggalTransaksi;
        this.hargaJual = hargaJual;
    }

    public void infoTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pembeli: " + pembeli);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        System.out.println("Harga Jual: " + hargaJual);
        mobil.infoMobil();
    }
}