public class AritmatikaLITerm {
    public static void main(String[] args) {
        Double totalBuku = Double.valueOf(250);
        Double bukuTerbaca = Double.valueOf(75);
        Double bukuTersisa;
        Double persenDibaca;

        bukuTersisa = totalBuku - bukuTerbaca;
        persenDibaca = (bukuTerbaca / totalBuku) * 100;

        System.out.println("=== Statistik LITerm (Literasi Terminal) ===");
        System.out.println("Total Buku: " + totalBuku);
        System.out.println("Buku yang sudah dibaca: " + bukuTerbaca);
        System.out.println("Buku yang tersisa: " + bukuTersisa);
        System.out.println("Persentase Buku yang telah dibaca: " + persenDibaca + "%");
    }
}
