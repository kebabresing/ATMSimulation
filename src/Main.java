import java.util.Scanner;

/**
 * Kelas ini adalah titik masuk (entry point) untuk aplikasi ATM.
 * Kelas ini mengelola interaksi pengguna dan menu aplikasi.
 */
public class Main {
    /**
     * Metode utama yang menjalankan aplikasi ATM.
     *
     * @pairam args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(100000); // Saldo awal

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

    /**
     * Mengelola proses login pengguna.
     *
     * @param atm objek ATM yang digunakan
     * @param scanner objek Scanner untuk input pengguna
     * @return true jika login berhasil, false jika gagal
     */
    private static boolean loginUser(ATM atm, Scanner scanner) {
        System.out.print("Masukkan PIN Anda: ");
        String pin = scanner.next();
        return atm.login(pin);
    }

    /**
     * Menampilkan menu utama kepada pengguna.
     */
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Setor Tunai");
        System.out.println("3. Tarik Tunai");
        System.out.println("4. Logout");
        System.out.print("Pilih opsi (1-4): ");
    }

    /**
     * Mengelola pilihan yang dipilih oleh pengguna.
     *
     * @param atm objek ATM yang digunakan
     * @param pilihan opsi yang dipilih oleh pengguna
     * @param scanner objek Scanner untuk input pengguna
     */
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
