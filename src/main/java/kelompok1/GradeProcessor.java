package kelompok1;

public class GradeProcessor {
    public static String[] process() {
        // 1. Ambil data valid dari modul input
        double[] scores = InputModule.getValidScores();
        double tugas = scores[0];
        double uts   = scores[1];
        double uas   = scores[2];

        // 2. Hitung nilai akhir
        double nilaiAkhir = CalculationModule.calculateFinal(tugas, uts, uas);
        if (nilaiAkhir == -1) {
            return new String[]{"ERROR", "-", "-"};
        }

        // 3. Tentukan Grade & Status
        char grade = GradeModule.getGrade(nilaiAkhir);
        String status = StatusModule.getGraduationStatus(nilaiAkhir);

        // 4. Kembalikan hasil ke Main Program sebagai interface
        return new String[]{
            String.format("%.2f", nilaiAkhir),
            String.valueOf(grade),
            status
        };
    }
}