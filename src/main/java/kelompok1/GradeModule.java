package kelompok1;

public class GradeModule {
    public static char getGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85) return 'A';
        if (nilaiAkhir >= 70) return 'B';
        if (nilaiAkhir >= 60) return 'C';
        if (nilaiAkhir >= 50) return 'D';
        return 'E';
    }
}