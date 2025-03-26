import java.util.ArrayList;
import java.util.Scanner;

class User {
    public int id;
    public String nama;

    public User(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama;
    }
}

public class UserManage {
    public static ArrayList<User> daftarUser = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Manajemen User LITerm ===");
            System.out.println("1. Tambah User");
            System.out.println("2. Tampilkan Semua User");
            System.out.println("3. Edit User");
            System.out.println("4. Hapus User");
            System.out.println("5. Cari User");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
    
                switch (choice) {
                    case 1:
                        tambahUser();
                        break;
                    case 2:
                        tampilkanUser();
                        break;
                    case 3:
                        editUser();
                        break;
                    case 4:
                        hapusUser();
                        break;
                    case 5:
                        cariUserMenu();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan Program Manajemen User LITerm!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
    
                if(running) {
                    running = lanjutkanProgram();
                }
            } catch(Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                running = lanjutkanProgram();
            }
        }
    }

    public static void tambahUser() {
        System.out.print("Masukkan ID User: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (cariUser(id, daftarUser, false) != null) {
            System.out.println("ID sudah digunakan! Silakan masukkan ID yang berbeda.");
            return;
        }

        System.out.print("Masukkan nama User: ");
        String nama = scanner.nextLine();
        daftarUser.add(new User(id, nama));
        System.out.println("User berhasil ditambahkan!");
    }

    public static void tampilkanUser() {
        if (daftarUser.isEmpty()) {
            System.out.println("Belum ada User yang terdaftar.");
        } else {
            System.out.println("\nDaftar User:");
            for (User p : daftarUser) {
                System.out.println(p);
            }
        }
    }

    public static void editUser() {
        System.out.print("Masukkan ID User yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        User user = cariUser(id, daftarUser, true);
        if (user != null) {
            System.out.print("Masukkan nama baru: ");
            user.nama = scanner.nextLine();
            System.out.println("Data User berhasil diperbarui!");
        }
    }

    public static void hapusUser() {
        System.out.print("Masukkan ID User yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        User user = cariUser(id, daftarUser, true);
        if (user != null) {
            daftarUser.remove(user);
            System.out.println("User berhasil dihapus!");
        }
    }

    public static void cariUserMenu() {
        System.out.print("Masukkan ID User yang ingin dicari: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        User user = cariUser(id, daftarUser, true);
        if (user != null) {
            System.out.println("User ditemukan: " + user);
        }
    }

    public static User cariUser(int id, ArrayList<User> daftarUser, boolean tampilkanPesan) {
        for (User p : daftarUser) {
            if (p.id == id) {
                return p;
            }
        }
        
        if (tampilkanPesan) {
            System.out.println("User dengan ID tersebut tidak ditemukan.");
        }

        return null;
    }

    public static boolean lanjutkanProgram() {
        System.out.print("Lanjutkan program (y/n)? ");
        String respon = scanner.nextLine();
        
        if (respon.equals("n")) {
            System.out.println("Terima kasih telah menggunakan Program Manajemen User LITerm!");
        }
        return respon.equals("y");
    }
}