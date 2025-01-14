package Penjualan;

public class Customer {
    private String nama;
    private String alamat;
    private String email;
    private int noHp;
    private double saldo;

    public Customer(String nama, String alamat, String email, int noHp, double saldo) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noHp = noHp;
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getEmail() {
        return email;
    }

    public int getNoHp() {
        return noHp;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}