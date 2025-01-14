package Penjualan;

import BahanBakar.Mobil;

import java.util.Date;

public class Transaksi {
    private String idTransaksi;
    private Mobil mobil;
    private Customer customer; // Menggunakan objek Customer
    private Date tanggalTransaksi;
    private int hargaJual;

    public Transaksi(String idTransaksi, Mobil mobil, Customer customer, Date tanggalTransaksi, int hargaJual) {
        this.idTransaksi = idTransaksi;
        this.mobil = mobil;
        this.customer = customer;
        this.tanggalTransaksi = tanggalTransaksi;
        this.hargaJual = hargaJual;
    }


    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public double hitungPajak() {
        return getHargaJual() * 0.1;
    }

    public void infoTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pembeli: " + customer.getNama());
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        System.out.println("Harga Jual: " + hargaJual);
        System.out.println("Alamat Customer: " + customer.getAlamat());
        System.out.println("Email Customer: " + customer.getEmail());
        System.out.println("No HP Customer: " + customer.getNoHp());
        System.out.println("Saldo Customer: " + customer.getSaldo());
        mobil.infoMobil();
    }
}