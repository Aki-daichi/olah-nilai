package kelompok1;

public class ScoreEvaluator implements ResultEvaluator {
    @Override
    public char getGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85) return 'A';
        if (nilaiAkhir >= 70) return 'B';
        if (nilaiAkhir >= 60) return 'C';
        if (nilaiAkhir >= 50) return 'D';
        return 'E';
    }

    @Override
    public String getGraduationStatus(double nilaiAkhir) {
        if (Double.isNaN(nilaiAkhir) || nilaiAkhir < 0 || nilaiAkhir > 100) {
            return "Nilai Tidak Valid"; 
        }
        return (nilaiAkhir >= 60) ? "Lulus" : "Tidak Lulus"; 
    }
}