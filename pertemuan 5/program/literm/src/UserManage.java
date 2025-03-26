import java.util.ArrayList;
import java.util.Scanner;

class User {
    private int id;
    private String nama;
    private String email;

    public User(int id, String nama, String email) {
        this.id = id;
        setNama(nama);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public void setNama(String nama) {
        if (nama.length() >= 3) {
            this.nama = nama;
        } else {
            System.out.println("Nama harus terdiri dari minimal 3 karakter!");
        }
    }

    public void setEmail(String email) {
        if (email.contains("@gmail.com")) {
            this.email = email;
        } else {
            System.out.println("Format email tidak valid!");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Email: " + email;
    }
}

class UserService {
    private ArrayList<User> daftarUser = new ArrayList<>();

    public void tambahUser(User user) {
        if (cariUser(user.getId()) == null) {
            daftarUser.add(user);
            System.out.println("User berhasil ditambahkan!");
        } else {
            System.out.println("ID sudah digunakan! Silakan masukkan ID yang berbeda.");
        }
    }

    public void tampilkanUser() {
        if (daftarUser.isEmpty()) {
            System.out.println("Belum ada User yang terdaftar.");
        } else {
            System.out.println("\nDaftar User:");
            for (User user : daftarUser) {
                System.out.println(user);
            }
        }
    }

    public void editUser(int id, String namaBaru, String emailBaru) {
        User user = cariUser(id);
        if (user != null) {
            user.setNama(namaBaru);
            user.setEmail(emailBaru);
            System.out.println("Data User berhasil diperbarui!");
        } else {
            System.out.println("User dengan ID tersebut tidak ditemukan.");
        }
    }

    public void hapusUser(int id) {
        User user = cariUser(id);
        if (user != null) {
            daftarUser.remove(user);
            System.out.println("User berhasil dihapus!");
        } else {
            System.out.println("User dengan ID tersebut tidak ditemukan.");
        }
    }

    public User cariUser(int id) {
        for (User user : daftarUser) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}

public class UserManage {
    private static UserService userService = new UserService();
    private static Scanner scanner = new Scanner(System.in);

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
                        userService.tampilkanUser();
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

                if (running) {
                    running = lanjutkanProgram();
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                running = lanjutkanProgram();
            }
        }
    }

    private static void tambahUser() {
        int id;
        while (true) {
            System.out.print("Masukkan ID User: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (userService.cariUser(id) == null) {
                    break;
                } else {
                    System.out.println("ID sudah digunakan! Silakan masukkan ID yang berbeda.");
                }
            } catch(Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        String nama;
        while (true) {
            System.out.print("Masukkan nama User: ");
            nama = scanner.nextLine();
            if (nama.length() >= 3) {
                break;
            } else {
                System.out.println("Nama harus terdiri dari minimal 3 karakter!");
            }
        }

        String email;
        while (true) {
            System.out.print("Masukkan email User: ");
            email = scanner.nextLine();
            if (email.contains("@gmail.com")) {
                break;
            } else {
                System.out.println("Format email tidak valid!");
            }
        }

        userService.tambahUser(new User(id, nama, email));
    }

    private static void editUser() {
        int id;
        User user;

        while(true) {
            System.out.print("Masukkan ID User yang ingin diubah: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                user = userService.cariUser(id);
                if (user != null) {
                    break;
                } else {
                    System.out.println("User dengan ID tersebut tidak ditemukan. Silakan masukkan ID yang valid.");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        String namaBaru;
        while (true) {
            System.out.print("Masukkan nama baru: ");
            namaBaru = scanner.nextLine();
            if (namaBaru.length() >= 3) {
                break;
            } else {
                System.out.println("Nama harus terdiri dari minimal 3 karakter!");
            }
        }

        String emailBaru;
        while (true) {
            System.out.print("Masukkan email baru: ");
            emailBaru = scanner.nextLine();
            if (emailBaru.contains("@gmail.com")) {
                break;
            } else {
                System.out.println("Format email tidak valid!");
            }
        }

        userService.editUser(id, namaBaru, emailBaru);
    }

    private static void hapusUser() {
        int id;

        while(true) {
            System.out.print("Masukkan ID User yang ingin dihapus: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if(userService.cariUser(id) != null) {
                    break;
                } else {
                    System.out.println("User dengan ID tersebut tidak ditemukan. Silakan masukkan ID yang valid.");
                }
            } catch(Exception e) {
                System.out.println("Input haru berupa angka!");
                scanner.nextLine();
            }
        }

        userService.hapusUser(id);
    }

    private static void cariUserMenu() {
        System.out.print("Masukkan ID User yang ingin dicari: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine();
    
            User user = userService.cariUser(id);
            if (user != null) {
                System.out.println("User ditemukan: " + user);
            } else {
                System.out.println("User dengan ID tersebut tidak ditemukan.");
            }
        } catch(Exception e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    private static boolean lanjutkanProgram() {
        while(true) {
            System.out.print("Lanjutkan program (y/n)? ");
            String respon = scanner.nextLine();

            if(respon.equalsIgnoreCase("y")) {
                return true;
            } else if(respon.equalsIgnoreCase("n")) {
                System.out.println("Terima kasih telah menggunakan Program Manajemen User LITerm");
                return false;
            } else {
                System.out.println("Masukkan pilihan yang valid (y/n)!");
            }
        }
    }
}