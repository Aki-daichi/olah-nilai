package kelompok1;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    private final Scanner scanner;
    private final ScoreValidator validator;

    public ConsoleInputHandler(Scanner scanner, ScoreValidator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    @Override
    public StudentScore getValidScore() {
        while (true) {
            System.out.print("Masukkan Nilai Tugas: ");
            double tugas = scanner.nextDouble();
            System.out.print("Masukkan Nilai UTS   : ");
            double uts = scanner.nextDouble();
            System.out.print("Masukkan Nilai UAS   : ");
            double uas = scanner.nextDouble();

            StudentScore score = new StudentScore(tugas, uts, uas);
            if (validator.isValid(score)) {
                return score;
            }
            System.out.println("Data tidak valid! Pastikan semua nilai 0–100 dan tidak semuanya 0.\n");
        }
    }
}