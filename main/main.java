package GusDealer;
import BahanBakar.*;
import Penjualan.*;

import java.util.Date;

public class main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer("Gus Dealer Becak");

        // Menambahkan mobil ke stok
        MobilBensin mobil1 = new MobilBensin("MOB001", "Toyota", "Avanza", "Hitam", 2000, 2022);
        MobilDiesel mobil2 = new MobilDiesel("MOB002", "Isuzu", "D-Max", "Putih", 3000, 2021);

        dealer.stokMobil.tambahMobil(mobil1);
        dealer.stokMobil.tambahMobil(mobil2);

        // Menampilkan stok mobil
        dealer.stokMobil.tampilkanStok();

        // Melakukan transaksi
        dealer.jualMobil(mobil1, "Yosep", mobil1.harga);


        // Menampilkan informasi transaksi
        dealer.tampilkanDaftarTransaksi();

        // Menampilkan informasi customer
        Customer Customer = new Customer("C001", mobil1, "Yosep", new Date(), 2500, "Jalan Raya", "5j8r1@example.com" ,12345, 10000,"Yosep");

        double saldoAwal = Customer.saldoAwal();
        System.out.println("Saldo Awal : " + saldoAwal);

        double saldoCustomer = Customer.getHargaJual(10000);
        System.out.println("Saldo Setelah pembelian (belum dipotong pajak) : " + saldoCustomer);

        double pajak = Customer.hitungPajak();
        System.out.println("Pajak : " + pajak);

        Customer.setSaldo(saldoCustomer - pajak);
        System.out.println("Saldo Customer setelah dipotong pajak : " + Customer.getSaldo());

        Customer.infoCustomer();
    }
}