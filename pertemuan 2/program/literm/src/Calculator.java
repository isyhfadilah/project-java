import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ulangi = true;
        
        int totalBuku = 0;
        int bukuTerbaca = 0;
        
        while (ulangi) {
            System.out.println("\n=== Calculator LI Terminal ===");
            System.out.println("1. Tambahkan buku baru");
            System.out.println("2. Tandai buku sebagai sudah dibaca");
            System.out.println("3. Hapus buku yang belum dibaca");
            System.out.println("4. Hitung persentase buku yang telah dibaca");
            System.out.println("5. Estimasi waktu membaca berdasarkan jumlah halaman");
            System.out.println("6. Keluar");
            System.out.print("Pilih operasi (1-6): ");
            
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah buku baru yang dimiliki: ");
                    int tambahTotalBuku = scanner.nextInt();
                    if (tambahTotalBuku > 0) {
                        totalBuku += tambahTotalBuku;
                        System.out.println("Total buku sekarang: " + totalBuku + " buku.");
                    } else {
                        System.out.println("Jumlah harus lebih dari 0.");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan jumlah buku yang telah selesai dibaca: ");
                    int tambahBuku = scanner.nextInt();
                    if (tambahBuku > 0 && (bukuTerbaca + tambahBuku) <= totalBuku) {
                        bukuTerbaca += tambahBuku;
                        System.out.println("Total buku terbaca sekarang: " + bukuTerbaca + " buku.");
                    } else {
                        System.out.println("Jumlah tidak valid. Pastikan tidak melebihi total buku.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan jumlah buku yang ingin dihapus dari belum dibaca: ");
                    int kurangBuku = scanner.nextInt();
                    int bukuBelumDibaca = totalBuku - bukuTerbaca;

                    if (kurangBuku > 0 && kurangBuku <= bukuBelumDibaca) {
                        totalBuku -= kurangBuku;
                        System.out.println("Total buku belum dibaca sekarang: " + (totalBuku - bukuTerbaca) + " buku.");
                    } else {
                        System.out.println("Jumlah tidak valid. Pastikan tidak melebihi jumlah buku yang belum dibaca.");
                    }
                    break;
                case 4:
                    if (totalBuku == 0) {
                        System.out.println("Belum ada buku yang terdaftar.");
                    } else {
                        float persenDibaca = ((float) bukuTerbaca / totalBuku) * 100;
                        System.out.println("Persentase buku yang telah dibaca: " + String.format("%.2f", persenDibaca) + "%");
                    }
                    break;
                case 5:
                    System.out.print("Masukkan jumlah halaman buku: ");
                    int halaman = scanner.nextInt();
                    System.out.print("Masukkan jumlah halaman yang dapat dibaca per hari: ");
                    int halamanPerHari = scanner.nextInt();
                    if (halamanPerHari <= 0) {
                        System.out.println("Jumlah halaman per hari harus lebih dari 0.");
                    } else {
                        int estimasiHari = halaman / halamanPerHari;
                        System.out.println("Estimasi waktu membaca: " + estimasiHari + " hari.");
                    }
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan kalkulator ReadCLI!");
                    ulangi = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
