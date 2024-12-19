package Penjualan;

import BahanBakar.Mobil;

import java.util.Date;

public class Customer extends Transaksi {
    private String nama;
    private String alamat;
    private String email;
    private int noHp;
    private double saldo;

    public Customer(String idTransaksi, Mobil mobil, String pembeli, Date tanggalTransaksi, double hargaJual, String alamat, String email, int noHp, double saldo, String nama) {
        super(idTransaksi, mobil, pembeli, tanggalTransaksi, hargaJual);
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noHp = noHp;
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getHargaJual() {
        return super.getHargaJual();
    }

    public double hitungPajak() {
        return getHargaJual() * 0.1;
    }

}