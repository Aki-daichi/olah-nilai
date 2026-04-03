package kelompok1;

public class ValidationModule {
    public static boolean isValid(double tugas, double uts, double uas) {
        // Aturan 1 & 2: Semua harus antara 0–100
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            return false;
        }
        // Aturan 3: Tidak boleh semuanya 0
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }
        return true;
    }
}