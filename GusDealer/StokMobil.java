package GusDealer;

import BahanBakar.Mobil;

import java.util.ArrayList;
import java.util.List;

public class StokMobil {
    private List<Mobil> daftarMobil;

    public StokMobil() {
        this.daftarMobil = new ArrayList<>();
    }

    public void tambahMobil(Mobil mobil) {
        daftarMobil.add(mobil);
    }

    public void hapusMobil(Mobil mobil) {
        daftarMobil.remove(mobil);
    }

    public Mobil getMobilById(String idMobil) {
        for (Mobil mobil : daftarMobil) {
            if (mobil.getId().equals(idMobil)) { // Pastikan ada metode getId() di kelas Mobil
                return mobil;
            }
        }
        return null; // Jika mobil tidak ditemukan
    }

    public void tampilkanStok() {
        System.out.println("Stok Mobil:");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil dalam stok.");
        } else {
            for (Mobil mobil : daftarMobil) {
                mobil.infoMobil();
            }
        }
    }
}