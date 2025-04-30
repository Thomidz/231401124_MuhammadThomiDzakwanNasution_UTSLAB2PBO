import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Kendaraan> listKendaraan = new ArrayList<>();
        String lanjut = "y";

        System.out.println("======== Welcome to ParkingChan ========");

        while (lanjut.equalsIgnoreCase("y")) {
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk): ");
            String jenis = scanner.nextLine();

            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.print("Enter Duration (Manual/Time): ");
            String metode = scanner.nextLine().toLowerCase();

            if (metode.equals("manual")) {
                System.out.print("Enter Duration (in hour): ");
                int durasi = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline
                kendaraan.hitungBiaya(durasi);
            } else if (metode.equals("time")) {
                System.out.print("Enter entry time  : ");
                int masuk = scanner.nextInt();
                System.out.print("Enter exit time   : ");
                int keluar = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline
                kendaraan.hitungBiaya(masuk, keluar);
            } else {
                System.out.println("Metode input tidak dikenali. Data diabaikan.");
                continue;
            }

            kendaraan.tampilRingkasan();
            listKendaraan.add(kendaraan);

            System.out.print("\nAdd another vehicle? (y/n): ");
            lanjut = scanner.nextLine();
        }

        // Final report
        double totalBiaya = 0;
        for (Kendaraan k : listKendaraan) {
            totalBiaya += k.getTotal();
        }

        System.out.println("\n======== FINAL REPORT ========");
        System.out.println("Total Vehicle Final     : " + listKendaraan.size());
        System.out.println("Total Parking Fees Final: Rp" + totalBiaya);
        System.out.println("Thank You.....");
    }
}
