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

    public void tampilkanStok() {
        System.out.println("Stok Mobil:");
        for (Mobil mobil : daftarMobil) {
            mobil.infoMobil();
            System.out.println("-".repeat(20));
        }
    }
}