package kelompok1;

public class ScoreCalculator implements FinalScoreCalculator {
    private final ScoreValidator validator;

    // Dependency Injection: Validator dimasukkan lewat konstruktor
    public ScoreCalculator(ScoreValidator validator) {
        this.validator = validator;
    }

    @Override
    public double calculateFinal(StudentScore score) {
        if (!validator.isValid(score)) {
            throw new IllegalArgumentException("Data nilai tidak valid");
        }

        double finalScore = (0.3 * score.getTugas()) + (0.3 * score.getUts()) + (0.4 * score.getUas());
        if (finalScore > 100) {
            throw new IllegalArgumentException("Nilai akhir melebihi batas maksimum");
        }
        return finalScore;
    }
}