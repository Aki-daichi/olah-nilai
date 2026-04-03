package kelompok1;

public class CalculationModule {
    public static double calculateFinal(double tugas, double uts, double uas) {
        if (!ValidationModule.isValid(tugas, uts, uas)) {
            return -1; // Aturan 4c2
        }
        double finalScore = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        if (finalScore > 100) {
            return -1; // Aturan 4c3
        }
        return finalScore;
    }
}