package View;

import GusDealer.Dealer;
import BahanBakar.Mobil;
import BahanBakar.MobilBensin;
import BahanBakar.MobilDiesel;
import BahanBakar.MobilListrik;
import Penjualan.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DealerView {
    private Dealer dealer;
    private Scanner scanner;

    public DealerView(Dealer dealer) {
        this.dealer = dealer;
        this.scanner = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        int pilihan = 0;
        do {
            System.out.println("\n=== Gus Dealer ===");
            System.out.println("1. Tambah Mobil ke Stok");
            System.out.println("2. Tampilkan Stok Mobil");
            System.out.println("3. Jual Mobil");
            System.out.println("4. Tampilkan Daftar Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline

                switch (pilihan) {
                    case 1:
                        tambahMobilKeStok();
                        break;
                    case 2:
                        dealer.getStokMobil().tampilkanStok();
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
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); // Membersihkan input yang tidak valid
            }
        } while (pilihan != 0);
    }

    private void tambahMobilKeStok() {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka untuk harga dan tahun.");
            scanner.nextLine(); // Membersihkan input yang tidak valid
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan mobil: " + e.getMessage());
        }
    }

    private void jualMobil() {
        try {
            System.out.print("Masukkan ID Mobil yang ingin dijual: ");
            String idMobil = scanner.nextLine();
            Mobil mobil = dealer.getStokMobil().getMobilById(idMobil); // Anda perlu menambahkan metode ini di StokMobil

            if (mobil != null) {
                System.out.print("Masukkan Nama Pembeli: ");
                String namaPembeli = scanner.nextLine();
                System.out.print("Masukkan Alamat Pembeli : ");
                String alamat = scanner.nextLine();
                System.out.print("Masukkan Email Pembeli: ");
                String email = scanner.nextLine();
                System.out.print("Masukkan No HP Pembeli: ");
                int noHp = scanner.nextInt();
                System.out.print("Masukkan Saldo Pembeli: ");
                double saldo = scanner.nextDouble();
                scanner.nextLine(); // Membersihkan newline

                // Membuat objek Customer
                Customer customer = new Customer(namaPembeli, alamat, email, noHp, saldo);
                dealer.jualMobil(customer, mobil);
            } else {
                System.out.println("Mobil tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka untuk No HP dan Saldo.");
            scanner.nextLine(); // Membersihkan input yang tidak valid
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menjual mobil: " + e.getMessage());
        }
    }
}