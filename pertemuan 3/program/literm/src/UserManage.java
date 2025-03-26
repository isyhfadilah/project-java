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
    public static void main(String[] args) {
        ArrayList<User> daftarUser = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        boolean next = true;
        while (next) {
            System.out.print("Masukkan perintah (tambah/edit/hapus/tampil/keluar): ");
            String perintah = scanner.nextLine().toLowerCase();

            if (perintah.equals("tambah")) {
                System.out.print("Masukkan ID User: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Masukkan Nama User: ");
                String nama = scanner.nextLine();
                
                daftarUser.add(new User(id, nama));
                System.out.println("User berhasil ditambahkan!\n");
            
            } else if (perintah.equals("edit")) {
                System.out.print("Masukkan ID User yang ingin diedit: ");
                int idEdit = scanner.nextInt();
                scanner.nextLine();
                
                boolean found = false;
                for (User p : daftarUser) {
                    if (p.id == idEdit) {
                        System.out.print("Masukkan nama baru: ");
                        p.nama = scanner.nextLine();
                        System.out.println("Data User berhasil diperbarui!\n");
                        found = true;
                        break;
                    }
                }
                
                if(!found) {
                    System.out.println("User dengan ID tersebut tidak ditemukan.\n");
                }
            
            } else if (perintah.equals("hapus")) {
                System.out.print("Masukkan ID User yang ingin dihapus: ");
                int idHapus = scanner.nextInt();
                scanner.nextLine(); 

                boolean removed = daftarUser.removeIf(p -> p.id == idHapus);
                if(removed) {
                    System.out.println("User berhasil dihapus!\n");
                } else {
                    System.out.println("User dengan ID tersebut tidak ditemukan.\n");
                }

            } else if (perintah.equals("tampil")) {
                if (daftarUser.isEmpty()) {
                    System.out.println("Belum ada User yang terdaftar.\n");
                } else {
                    System.out.println("\nDaftar User:");
                    for (User p : daftarUser) {
                        System.out.println(p);
                    }
                    System.out.println();
                }
            
            } else if (perintah.equals("keluar")) {
                next = false;
                System.out.println("Program selesai!");
            
            } else {
                System.out.println("Perintah tidak dikenal!\n");
            }
        }

        scanner.close();
    }
}
