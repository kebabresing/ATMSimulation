/**
 * Kelas ini merepresentasikan sebuah ATM yang memungkinkan pengguna untuk
 * melakukan operasi seperti login, cek saldo, setor tunai, tarik tunai,
 * dan logout.
 */
public class ATM {
    private double saldo;
    private boolean loginStatus;

    /**
     * Konstruktor untuk menginisialisasi saldo awal pada ATM.
     *
     * @param saldoAwal saldo awal yang akan ditetapkan pada ATM
     */
    public ATM(double saldoAwal) {
        this.saldo = saldoAwal;
        this.loginStatus = false;
    }

    /**
     * Mengizinkan pengguna untuk login dengan PIN.
     *
     * @param pin PIN yang dimasukkan oleh pengguna
     * @return true jika login berhasil, false jika login gagal
     */
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

    /**
     * Menampilkan saldo saat ini jika pengguna telah login.
     */
    public void cekSaldo() {
        System.out.printf(isLoggedIn() ? "Saldo Anda: Rp %.2f\n" : "Anda harus login terlebih dahulu.\n", saldo);
    }

    /**
     * Mengizinkan pengguna untuk menyetor sejumlah uang ke saldo.
     *
     * @param jumlah jumlah uang yang akan disetor
     */
    public void setorTunai(double jumlah) {
        if (isLoggedIn()) {
            if (validasiJumlah(jumlah)) {
                saldo += jumlah;
                System.out.printf("Anda telah menyetor: Rp %.2f\n", jumlah);
            }
        }
    }

    /**
     * Mengizinkan pengguna untuk menarik sejumlah uang dari saldo.
     *
     * @param jumlah jumlah uang yang akan ditarik
     */
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

    /**
     * Mengeluarkan pengguna dari sesi login saat ini.
     */
    public void logout() {
        loginStatus = false;
        System.out.println("Anda telah logout.");
    }

    /**
     * Memeriksa apakah pengguna saat ini sedang login.
     *
     * @return true jika pengguna sedang login, false jika tidak
     */
    private boolean isLoggedIn() {
        return loginStatus;
    }

    /**
     * Memvalidasi jumlah yang dimasukkan oleh pengguna.
     *
     * @param jumlah jumlah yang akan divalidasi
     * @return true jika jumlah valid, false jika tidak
     */
    private boolean validasiJumlah(double jumlah) {
        if (jumlah > 0) {
            return true;
        } else {
            System.out.println("Jumlah tidak valid.");
            return false;
        }
    }
}
