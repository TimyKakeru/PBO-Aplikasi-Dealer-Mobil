package GusDealer;

import BahanBakar.Mobil;
import Penjualan.Customer;
import Penjualan.Transaksi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dealer {
    final String nama;
    public StokMobil stokMobil;
    private List<Transaksi> daftarTransaksi;

    public Dealer(String nama) {
        this.nama = nama;
        this.stokMobil = new StokMobil();
        this.daftarTransaksi = new ArrayList<>(); // Inisialisasi daftarTransaksi
    }
    public void jualMobil(Customer customer, Mobil mobil) {
        double hargaJual = mobil.getHarga(); // Ambil harga dari objek mobil
        double totalBiaya = hargaJual + customer.hitungPajak(); // Hitung total biaya termasuk pajak

        if (customer.getSaldo() >= totalBiaya) {
            Transaksi transaksi = new Transaksi("TRANS" + (daftarTransaksi.size() + 1), mobil, customer.getPembeli(),new Date(),hargaJual);
            daftarTransaksi.add(transaksi);
            stokMobil.hapusMobil(mobil); // Menghapus mobil dari stok setelah terjual
            customer.setSaldo(customer.getSaldo() - totalBiaya); // Kurangi saldo customer
            System.out.println("Transaksi berhasil!" );
        } else {
            System.out.println("Saldo tidak cukup untuk melakukan transaksi.");
        }
    }

    public void tampilkanDaftarTransaksi() {
        System.out.println("Daftar Transaksi:");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.infoTransaksi();
        }
    }
    public List<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }
    public void tambahMobilKeStok(Mobil mobil) {
        stokMobil.tambahMobil(mobil);
    }
}

