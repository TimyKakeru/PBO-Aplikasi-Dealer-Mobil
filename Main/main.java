import GusDealer.Dealer;
import View.DealerView;

public class main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer("GusDealer ");
        DealerView dealerView = new DealerView(dealer);

        // Menampilkan menu untuk interaksi pengguna
        dealerView.tampilkanMenu();
    }
}