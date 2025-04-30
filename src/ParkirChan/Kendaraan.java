public class Kendaraan {
    private String jenis;
    private int lamaParkir;
    private double biayaPerJam;

    // Constructor
    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
        switch (this.jenis) {
            case "motor" -> biayaPerJam = 2000;
            case "mobil" -> biayaPerJam = 5000;
            case "truk" -> biayaPerJam = 9000;
            default -> biayaPerJam = 0;
        }
    }

    // Method overloading
    public void hitungBiaya(int durasi) {
        this.lamaParkir = durasi;
    }

    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        this.lamaParkir = jamKeluar - jamMasuk;
    }

    public double getTotalBiaya() {
        double total = lamaParkir * biayaPerJam;
        if (lamaParkir > 5) {
            total *= 0.9; // Diskon 10%
        }
        return total;
    }

    public void tampilRingkasan() {
        System.out.println("\n---- PARKING SUMMARY ----");
        System.out.println("Vehicle Type    : " + capitalize(jenis));
        System.out.println("Parking Time    : " + lamaParkir + " hour(s)");
        System.out.println("Total Fee       : Rp" + getTotalBiaya());
    }

    public double getTotal() {
        return getTotalBiaya();
    }

    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
