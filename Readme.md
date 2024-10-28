# ATM Simulation

## Deskripsi Proyek

ATM Simulation adalah aplikasi sederhana yang mensimulasikan operasi mesin ATM. Pengguna dapat melakukan beberapa fungsi seperti login, cek saldo, setor tunai, tarik tunai, dan logout. Proyek ini ditulis dalam bahasa pemrograman Java dan dirancang untuk memberikan pengalaman pengguna yang intuitif dalam menggunakan layanan ATM.

## Fitur Utama

- Login menggunakan PIN.
- Cek saldo.
- Setor tunai.
- Tarik tunai.
- Logout dengan sesi aman.

## Prasyarat

Sebelum menjalankan proyek ini, pastikan Anda memiliki:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk23-downloads.html) terinstal di komputer Anda.
- Environment variable `JAVA_HOME` diatur dengan benar.
- Command Line Interface (CLI) untuk menjalankan aplikasi.

## Cara Menjalankan Proyek

1. **Clone Repository**:
   Untuk memulai, clone repository ini ke komputer Anda dengan menggunakan perintah:

   ```bash
   git clone https://github.com/kebabresing/ATMSimulation.git

## Struktur Proyek

Berikut adalah struktur direktori dari proyek ini:

```
ATMSimulation/
├── src/
│   ├── Main.java           # Kelas utama untuk menjalankan aplikasi ATM
│   ├── ATM.java            # Kelas yang menangani logika ATM (cek saldo, setor, tarik tunai)
├── bin/                    # Direktori keluaran untuk file yang dikompilasi
├── README.md               # Dokumentasi proyek
└── .gitignore              # File untuk mengecualikan file yang tidak perlu dalam repository
```

## Alur Penggunaan

1. **Login**: Pengguna harus memasukkan PIN yang valid untuk mengakses layanan ATM.
2. **Cek Saldo**: Setelah login, pengguna dapat memeriksa saldo akun mereka.
3. **Setor Tunai**: Pengguna dapat menambah saldo dengan menyetor uang tunai.
4. **Tarik Tunai**: Pengguna dapat menarik uang dari saldo yang tersedia.
5. **Logout**: Setelah selesai, pengguna dapat logout untuk mengakhiri sesi dengan aman.

## Catatan

- Pastikan PIN yang dimasukkan adalah benar untuk menghindari akses tidak sah.
- Pastikan jumlah yang disetor atau ditarik adalah valid dan dalam batas saldo yang tersedia.
- Selalu logout setelah selesai menggunakan layanan untuk keamanan akun Anda.