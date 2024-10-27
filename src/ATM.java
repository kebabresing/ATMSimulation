import java.util.Scanner;

public class ATM {
    private double saldo;
    private boolean loginStatus;

    public ATM(double saldoAwal) {
        this.saldo = saldoAwal;
        this.loginStatus = false;
    }

    public boolean login(String pin) {
        if (pin.equals("1234")) {
            loginStatus = true;
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("PIN salah! Silakan coba lagi.");
            return false;
        }
    }

    public void cekSaldo() {
        if (isLoggedIn()) {
            System.out.printf("Saldo Anda: Rp %.2f\n", saldo);
        } else {
            System.out.println("Anda harus login terlebih dahulu.");
        }
    }

    public void setorTunai(double jumlah) {
        if (isLoggedIn()) {
            if (validasiJumlah(jumlah)) {
                saldo += jumlah;
                System.out.printf("Anda telah menyetor: Rp %.2f\n", jumlah);
            }
        }
    }

    public void tarikTunai(double jumlah) {
        if (isLoggedIn()) {
            if (validasiJumlah(jumlah) && jumlah <= saldo) {
                saldo -= jumlah;
                System.out.printf("Anda telah menarik: Rp %.2f\n", jumlah);
            } else {
                System.out.println("Jumlah tarik tunai tidak valid atau saldo tidak cukup.");
            }
        }
    }

    public void logout() {
        loginStatus = false;
        System.out.println("Anda telah logout.");
    }

    private boolean isLoggedIn() {
        return loginStatus;
    }

    private boolean validasiJumlah(double jumlah) {
        if (jumlah > 0) {
            return true;
        } else {
            System.out.println("Jumlah tidak valid.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(100000); // Saldo awal

        System.out.println("Selamat datang di ATM!");

        while (!loginUser(atm, scanner));

        while (true) {
            displayMenu();
            int pilihan = scanner.nextInt();
            handleUserChoice(atm, pilihan, scanner);
        }
    }

    private static boolean loginUser(ATM atm, Scanner scanner) {
        System.out.print("Masukkan PIN Anda: ");
        String pin = scanner.next();
        return atm.login(pin);
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Setor Tunai");
        System.out.println("3. Tarik Tunai");
        System.out.println("4. Logout");
        System.out.print("Pilih opsi (1-4): ");
    }

    private static void handleUserChoice(ATM atm, int pilihan, Scanner scanner) {
        switch (pilihan) {
            case 1:
                atm.cekSaldo();
                break;
            case 2:
                System.out.print("Masukkan jumlah setor: Rp ");
                double setor = scanner.nextDouble();
                atm.setorTunai(setor);
                break;
            case 3:
                System.out.print("Masukkan jumlah tarik: Rp ");
                double tarik = scanner.nextDouble();
                atm.tarikTunai(tarik);
                break;
            case 4:
                atm.logout();
                while (!loginUser(atm, scanner)); // Minta login kembali setelah logout
                break;
            default:
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
        }
    }
}
