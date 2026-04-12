package kelompok1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            // 1. Instansiasi Objek (Dependency Injection)
            ScoreValidator validator = new ScoreValidator();
            InputHandler inputHandler = new ConsoleInputHandler(scanner, validator);
            FinalScoreCalculator calculator = new ScoreCalculator(validator);
            ResultEvaluator evaluator = new ScoreEvaluator();
            
            GradeProcessor processor = new GradeProcessor(inputHandler, calculator, evaluator);
            
            boolean running = true;
            
            while (running) {
                System.out.println("\n╔════════════════════════════════════════════╗");
                System.out.println("║   PROGRAM PENGOLAHAN NILAI MAHASISWA       ║");
                System.out.println("╠════════════════════════════════════════════╣");
                System.out.println("║  1. Input & Proses Nilai                   ║");
                System.out.println("║  2. Keluar                                 ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.print("Pilih menu (1/2): ");
                
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        FinalResult result = processor.process();
                        System.out.println("\n HASIL PENGOLAHAN:");
                        if (result.isError()) {
                            System.out.println("Nilai Akhir : ERROR");
                            System.out.println("Grade       : -");
                            System.out.println("Status      : -");
                        } else {
                            System.out.printf("Nilai Akhir : %.2f%n", result.getNilaiAkhir());
                            System.out.printf("Grade       : %s%n", result.getGrade());
                            System.out.printf("Status      : %s%n", result.getStatus());
                        }
                        System.out.println("────────────────────────────────────────────");
                    }
                    case 2 -> {
                        System.out.println("Terima kasih! Program ditutup.");
                        running = false;
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        }
    }
}