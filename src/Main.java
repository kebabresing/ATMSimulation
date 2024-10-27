import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(900000); // Saldo awal

        System.out.println("Selamat datang di ATM!");

        // Proses login
        while (!loginUser(atm, scanner));

        // Menu utama
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
                // Minta login kembali setelah logout
                while (!loginUser(atm, scanner));
                break;
            default:
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
        }
    }
}
