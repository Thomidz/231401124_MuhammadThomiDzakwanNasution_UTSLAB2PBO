// main.java

import java.util.*;

public class Main {
    private static Map<String, karyawan> dataKaryawan = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Karyawan ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Cari Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahKaryawan(scanner);
                case 2 -> hapusKaryawan(scanner);
                case 3 -> ubahPosisi(scanner);
                case 4 -> ubahGaji(scanner);
                case 5 -> tampilkanSemua();
                case 6 -> cariKaryawan(scanner);
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    private static void tambahKaryawan(Scanner scanner) {
        System.out.print("Masukkan ID: ");
        String id = scanner.nextLine();
        if (dataKaryawan.containsKey(id)) {
            System.out.println("ID sudah digunakan.");
            return;
        }
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Posisi: ");
        String posisi = scanner.nextLine();
        System.out.print("Masukkan Gaji: ");
        double gaji = scanner.nextDouble();
        scanner.nextLine();

        if (gaji < 0) {
            System.out.println("Gaji tidak boleh negatif.");
            return;
        }

        karyawan k = new karyawan(id, nama, posisi, gaji);
        dataKaryawan.put(id, k);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    private static void hapusKaryawan(Scanner scanner) {
        System.out.print("Masukkan ID karyawan yang akan dihapus: ");
        String id = scanner.nextLine();
        if (dataKaryawan.containsKey(id)) {
            dataKaryawan.remove(id);
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("ID tidak ditemukan.");
        }
    }

    private static void ubahPosisi(Scanner scanner) {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        if (dataKaryawan.containsKey(id)) {
            System.out.print("Masukkan posisi baru: ");
            String posisiBaru = scanner.nextLine();
            dataKaryawan.get(id).setPosisi(posisiBaru);
            System.out.println("Posisi berhasil diperbarui.");
        } else {
            System.out.println("ID tidak ditemukan.");
        }
    }

    private static void ubahGaji(Scanner scanner) {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        if (dataKaryawan.containsKey(id)) {
            System.out.print("Masukkan gaji baru: ");
            double gajiBaru = scanner.nextDouble();
            scanner.nextLine();
            if (gajiBaru < 0) {
                System.out.println("Gaji tidak boleh negatif.");
            } else {
                dataKaryawan.get(id).setGaji(gajiBaru);
                System.out.println("Gaji berhasil diperbarui.");
            }
        } else {
            System.out.println("ID tidak ditemukan.");
        }
    }

    private static void tampilkanSemua() {
        if (dataKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
        } else {
            System.out.println("\nDaftar Karyawan:");
            for (karyawan k : dataKaryawan.values()) {
                System.out.println(k);
            }
        }
    }

    private static void cariKaryawan(Scanner scanner) {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        if (dataKaryawan.containsKey(id)) {
            System.out.println(dataKaryawan.get(id));
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }
}
