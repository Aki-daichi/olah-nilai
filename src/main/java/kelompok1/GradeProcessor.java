package kelompok1;

public class GradeProcessor {
    private final InputHandler inputHandler;
    private final FinalScoreCalculator calculator;
    private final ResultEvaluator evaluator;

    public GradeProcessor(InputHandler inputHandler, FinalScoreCalculator calculator, ResultEvaluator evaluator) {
        this.inputHandler = inputHandler;
        this.calculator = calculator;
        this.evaluator = evaluator;
    }

    public FinalResult process() {
        StudentScore score = inputHandler.getValidScore();
        double nilaiAkhir;

        try {
            nilaiAkhir = calculator.calculateFinal(score);
        } catch (IllegalArgumentException ex) {
            return new FinalResult(-1, '-', "ERROR", true);
        }

        char grade = evaluator.getGrade(nilaiAkhir);
        String status = evaluator.getGraduationStatus(nilaiAkhir);

        return new FinalResult(nilaiAkhir, grade, status, false);
    }
}