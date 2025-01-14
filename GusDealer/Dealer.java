package GusDealer;

import BahanBakar.Mobil;
import Penjualan.Customer;
import Penjualan.Transaksi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dealer {
    final String nama;
    private StokMobil stokMobil;
    private List<Transaksi> daftarTransaksi;

    public Dealer(String nama) {
        this.nama = nama;
        this.stokMobil = new StokMobil();
        this.daftarTransaksi = new ArrayList<>(); // Inisialisasi daftarTransaksi
    }

    public void jualMobil(Customer customer, Mobil mobil) {
        if (mobil == null) {
            System.out.println("Mobil tidak ditemukan.");
            return;
        }

        int hargaJual = mobil.getHarga(); // Ambil harga dari objek mobil
        Transaksi transaksi = new Transaksi("TRANS" + (daftarTransaksi.size() + 1), mobil, customer, new Date(), hargaJual);
        double totalBiaya = hargaJual + transaksi.hitungPajak(); // Hitung total biaya termasuk pajak

        if (customer.getSaldo() >= totalBiaya) {
            daftarTransaksi.add(transaksi);
            stokMobil.hapusMobil(mobil); // Menghapus mobil dari stok setelah terjual
            customer.setSaldo(customer.getSaldo() - totalBiaya); // Kurangi saldo customer
            System.out.println("Transaksi berhasil!");
        } else {
            System.out.println("Saldo tidak cukup untuk melakukan transaksi.");
        }
    }

    public StokMobil getStokMobil() {
        return stokMobil;
    }

    public void tampilkanDaftarTransaksi() {
        System.out.println("Daftar Transaksi:");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.infoTransaksi();
        }
    }

    public void tambahMobilKeStok(Mobil mobil) {
        stokMobil.tambahMobil(mobil);
    }
}