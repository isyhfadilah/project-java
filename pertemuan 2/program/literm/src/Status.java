import java.util.Scanner;

public class Status {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Pengecek Status Membaca LITerm ===");

        int targetBuku = 0;
        while (targetBuku <= 0) {
            System.out.print("Berapa target jumlah buku yang ingin Anda baca tahun ini? ");
            if (scanner.hasNextInt()) {
                targetBuku = scanner.nextInt();
                if (targetBuku <= 0) {
                    System.out.println("Target harus lebih dari 0. Silakan masukkan angka yang benar.");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.next();
            }
        }

        int jumlahBuku = -1;
        while (jumlahBuku < 0 || jumlahBuku > targetBuku) {
            System.out.print("Masukkan jumlah buku yang telah Anda baca tahun ini: ");
            if (scanner.hasNextInt()) {
                jumlahBuku = scanner.nextInt();
                if (jumlahBuku < 0) {
                    System.out.println("Jumlah buku tidak boleh negatif. Silakan masukkan angka yang benar.");
                } else if (jumlahBuku > targetBuku) {
                    System.out.println("Jumlah buku yang telah dibaca tidak bisa melebihi target! Coba lagi.");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.next();
            }
        }

        double persenBaca = ((double) jumlahBuku / targetBuku) * 100;

        if (persenBaca == 0) {
            System.out.println("Anda belum membaca buku tahun ini. Cobalah mulai dengan buku yang ringan dan menarik!");
        } else if (persenBaca <= 25) {
            System.out.println("Anda baru mencapai " + String.format("%.2f", persenBaca) + "% dari target. Coba tingkatkan kebiasaan membaca!");
        } else if (persenBaca <= 50) {
            System.out.println("Anda sudah mencapai " + String.format("%.2f", persenBaca) + "% dari target. Bagus! Tapi tetap konsisten.");
        } else if (persenBaca <= 75) {
            System.out.println("Hebat! Anda sudah mencapai " + String.format("%.2f", persenBaca) + "% dari target. Teruskan membaca!");
        } else if (persenBaca < 100) {
            System.out.println("Luar biasa! Anda hampir mencapai target dengan " + String.format("%.2f", persenBaca) + "% dari target.");
        } else {
            System.out.println("Fantastis! Anda telah mencapai 100% dari target membaca Anda. Anda benar-benar seorang kutu buku!");
        }

        System.out.print("Apakah Anda ingin mendapatkan rekomendasi buku? (ya/tidak): ");
        scanner.nextLine();
        String jawaban = scanner.nextLine().trim().toLowerCase();

        while (!jawaban.equals("ya") && !jawaban.equals("tidak")) {
            System.out.print("Jawaban tidak valid. Harap ketik 'ya' atau 'tidak': ");
            jawaban = scanner.nextLine().trim().toLowerCase();
        }

        if (jawaban.equals("ya")) {
            System.out.println("Berikut beberapa rekomendasi buku untuk Anda:");
            System.out.println("- 'Atomic Habits' oleh James Clear");
            System.out.println("- 'Sapiens' oleh Yuval Noah Harari");
            System.out.println("- 'The Alchemist' oleh Paulo Coelho");
        } else {
            System.out.println("Baik, tetap semangat dalam membaca!");
        }

        System.out.println("Terima kasih telah menggunakan LITerm!");
        scanner.close();
    }
}
