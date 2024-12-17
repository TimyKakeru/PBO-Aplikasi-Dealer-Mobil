package GusDealer;

import BahanBakar.Mobil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dealer {
    final String nama ;
    protected StokMobil stokMobil;
    private List<Transaksi> daftarTransaksi;

    public Dealer(String nama) {
        this.nama = nama;
        this.stokMobil = new StokMobil();
        this.daftarTransaksi = new ArrayList<>(); // Inisialisasi daftarTransaksi
    }

    public void jualMobil(Mobil mobil, String pembeli, int hargaJual) {
        Transaksi transaksi = new Transaksi("TRANS" + (daftarTransaksi.size() + 1), mobil, pembeli, new Date(), hargaJual);
        daftarTransaksi.add(transaksi);
        stokMobil.hapusMobil(mobil); // Menghapus mobil dari stok setelah terjual
    }

    public void tampilkanDaftarTransaksi() {
        System.out.println("Daftar Transaksi:");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.infoTransaksi();
        }
    }
}