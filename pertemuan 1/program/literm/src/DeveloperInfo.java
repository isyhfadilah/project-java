import java.util.ArrayList;

class Developer {
    String namaLengkap;
    String peran;
    String email;
    Long nomorHp;
    String alamat;
    String sosialMedia;
    Integer tanggalMulai;
    Integer tanggalAkhir;

    public Developer(String namaLengkap, String peran, String email, Long nomorHp, String alamat, String sosialMedia, Integer tanggalMulai, Integer tanggalAkhir) {
        this.namaLengkap = namaLengkap;
        this.peran = peran;
        this.email = email;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
        this.sosialMedia = sosialMedia;
        this.tanggalMulai = tanggalMulai;
        this.tanggalAkhir = tanggalAkhir;
    }

    public void tampilkanInfo(int index) {
        System.out.println("=== Identitas Developer " + index + " ===");
        System.out.println("Nama Lengkap: " + namaLengkap);
        System.out.println("Peran dalam Proyek: " + peran);
        System.out.println("Email: " + email);
        System.out.println("Nomor HP: " + nomorHp);
        System.out.println("Alamat: " + alamat);
        System.out.println("Tanggal Mulai Pengembangan: " + tanggalMulai);
        System.out.println("Tanggal Akhir Pengembangan: " + tanggalAkhir);
        System.out.println("Sosial Media: " + sosialMedia);
        System.out.println();
    }
}

public class DeveloperInfo {
    public static void main(String[] args) {
        ArrayList<Developer> developer = new ArrayList<>();
        developer.add(new Developer("Aisyah Nur Fadilah", "Project Manager, Developer", "aisyah.fadilah@satu.ac.id", Long.valueOf("081234567890"), "Jl. Ganesa No. 10. Coblong, Kota Bandung", "Aisyah Nur Fadilah (LinkedIn)", Integer.valueOf(20250212), Integer.valueOf(20250604)));
        developer.add(new Developer("Alberta Natal Kristin Nababan", "Developer", "alberta.nababan@satu.ac.id", Long.valueOf("081298765432"), "Jl. BKR No.63, Ancol, Regol, Kota Bandung", "albertanatal_ (Instagram)", Integer.valueOf(20250212), Integer.valueOf(20250604)));
        
        int index = 1;
        for (Developer dev : developer) {
            dev.tampilkanInfo(index);
            index++;
        }
    }
}
