package kelompok1;

public class StatusModule {
    public static String getGraduationStatus(double nilaiAkhir) { // 1 start
        // Lindungi modul dari nilai di luar domain skor akhir.
        if (Double.isNaN(nilaiAkhir) || nilaiAkhir < 0 || nilaiAkhir > 100) { // 2
            return "Nilai Tidak Valid"; // 3
        }

        if (nilaiAkhir >= 60) { // 4
            return "Lulus"; // 5
        }

        return "Tidak Lulus"; // 6
    } // 7 end
}
