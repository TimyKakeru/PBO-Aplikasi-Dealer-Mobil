package Penjualan;

import BahanBakar.Mobil;

import java.util.Date;

public class Transaksi {
    private String idTransaksi;
    private Mobil mobil;
    private String pembeli;
    private Date tanggalTransaksi;
    private double hargaJual;

    public Transaksi(String idTransaksi, Mobil mobil, String pembeli, Date tanggalTransaksi, double hargaJual) {
        this.idTransaksi = idTransaksi;
        this.mobil = mobil;
        this.pembeli = pembeli;
        this.tanggalTransaksi = tanggalTransaksi;
        this.hargaJual = hargaJual;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public String getPembeli() {
        return pembeli;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void infoTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pembeli: " + pembeli);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        System.out.println("Harga Jual: " + hargaJual);
        mobil.infoMobil();
    }
}