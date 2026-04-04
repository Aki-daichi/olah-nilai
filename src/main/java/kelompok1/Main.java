package kelompok1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
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
                        String[] result = GradeProcessor.process();
                        System.out.println("\n HASIL PENGOLAHAN:");
                        System.out.printf("Nilai Akhir : %s%n", result[0]);
                        System.out.printf("Grade       : %s%n", result[1]);
                        System.out.printf("Status      : %s%n", result[2]);
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