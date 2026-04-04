package kelompok1;

import java.util.Scanner;

public class InputModule {
    private static final Scanner scanner = new Scanner(System.in);

    public static double[] getValidScores() {
        double tugas; 
        double uts; 
        double uas;
        
        while (true) {
            System.out.print("Masukkan Nilai Tugas: ");
            tugas = scanner.nextDouble();
            System.out.print("Masukkan Nilai UTS   : ");
            uts = scanner.nextDouble();
            System.out.print("Masukkan Nilai UAS   : ");
            uas = scanner.nextDouble();

            if (ValidationModule.isValid(tugas, uts, uas)) {
                return new double[]{tugas, uts, uas};
            }
            System.out.println("Data tidak valid! Pastikan semua nilai 0–100 dan tidak semuanya 0.\n");
        }
    }
}