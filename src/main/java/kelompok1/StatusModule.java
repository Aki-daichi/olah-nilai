package kelompok1;

public class StatusModule {
    public static String getGraduationStatus(double nilaiAkhir) {
        return (nilaiAkhir >= 60) ? "Lulus" : "Tidak Lulus";
    }
}