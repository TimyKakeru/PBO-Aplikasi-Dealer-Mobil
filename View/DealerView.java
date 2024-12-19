package View;

import GusDealer.*;
import BahanBakar.*;
import Penjualan.Customer;

import java.util.Date;
import java.util.Scanner;

public class DealerView {
    private Dealer dealer;
    private Scanner scanner;

    public DealerView(Dealer dealer) {
        this.dealer = dealer;
        this.scanner = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\n=== Gus Dealer ===");
            System.out.println("1. Tambah Mobil ke Stok");
            System.out.println("2. Tampilkan Stok Mobil");
            System.out.println("3. Jual Mobil");
            System.out.println("4. Tampilkan Daftar Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    tambahMobilKeStok();
                    break;
                case 2:
                    dealer.stokMobil.tampilkanStok();
                    break;
                case 3:
                    jualMobil();
                    break;
                case 4:
                    dealer.tampilkanDaftarTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }

    private void tambahMobilKeStok() {
        System.out.print("Masukkan ID Mobil: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Merk Mobil: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Model Mobil: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan Warna Mobil: ");
        String warna = scanner.nextLine();
        System.out.print("Masukkan Harga Mobil: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan Tahun Mobil: ");
        int tahun = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        System.out.println("Pilih Tipe Mobil:");
        System.out.println("1. Bensin");
        System.out.println("2. Diesel");
        System.out.println("3. Listrik");
        System.out.print("Masukkan pilihan (1/2/3): ");
        int pilihanTipe = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        Mobil mobil = null;

        switch (pilihanTipe) {
            case 1:
                mobil = new MobilBensin(id, merk, model, warna, harga, tahun);
                break;
            case 2:
                mobil = new MobilDiesel(id, merk, model, warna, harga, tahun);
                break;
            case 3:
                mobil = new MobilListrik(id, merk, model, warna, harga, tahun);
                break;
            default:
                System.out.println("Pilihan tidak valid. Mobil tidak ditambahkan.");
                return; // Keluar dari metode jika pilihan tidak valid
        }
        dealer.tambahMobilKeStok(mobil);
        System.out.println("Mobil berhasil ditambahkan ke stok.");
    }

    private void jualMobil() {
        System.out.print("Masukkan ID Mobil yang ingin dijual: ");
        String idMobil = scanner.nextLine();
        Mobil mobil = dealer.stokMobil.getMobilById(idMobil); // Anda perlu menambahkan metode ini di StokMobil

        if (mobil != null) {
            System.out.print("Masukkan Nama Pembeli: ");
            String namaPembeli = scanner.nextLine();
            System.out.print("Masukkan Alamat Pembeli: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan Email Pembeli: ");
            String email = scanner.nextLine();
            System.out.print("Masukkan No HP Pembeli: ");
            int noHp = scanner.nextInt();
            System.out.print("Masukkan Saldo Pembeli: ");
            double saldo = scanner.nextDouble();
            scanner.nextLine(); // Membersihkan newline

            // Membuat objek Customer
            Customer customer = new Customer("CUST" + (dealer.getDaftarTransaksi().size() + 1), mobil, namaPembeli, new Date(), mobil.getHarga(), alamat, email, noHp, saldo, namaPembeli);
            dealer.jualMobil(customer, mobil);
        } else {
            System.out.println("Mobil tidak ditemukan.");
        }
    }
}