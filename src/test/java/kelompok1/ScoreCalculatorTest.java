package kelompok1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreCalculatorTest {

    private ScoreCalculator calculator;
    private ScoreValidator validator;

    // Setup sebelum setiap test dijalankan
    @BeforeEach
    void setUp() {
        validator = new ScoreValidator();
        calculator = new ScoreCalculator(validator);
    }

    // ---------------------------------------------------------
    // Path P3: Perhitungan Normal (Happy Path)
    // ---------------------------------------------------------

    @Test
    void testCalculateFinal_Success_PerhitunganNormal() {
        // Kasus: Input nilai standar
        // Tugas: 80, UTS: 85, UAS: 90
        // Hitungan manual: (0.3*80) + (0.3*85) + (0.4*90) = 24 + 25.5 + 36 = 85.5
        StudentScore score = new StudentScore(80.0, 85.0, 90.0);

        double result = calculator.calculateFinal(score);

        // Delta 0.001 diperlukan untuk membandingkan double
        assertEquals(85.5, result, 0.001, "Hasil perhitungan seharusnya 85.5");
    }

    @Test
    void testCalculateFinal_Success_NilaiMaksimum() {
        // Kasus: Input nilai maksimal (100 semua)
        // Hitungan manual: 100
        StudentScore score = new StudentScore(100.0, 100.0, 100.0);

        double result = calculator.calculateFinal(score);

        assertEquals(100.0, result, 0.001);
    }

    @Test
    void testCalculateFinal_Success_NilaiMinimumValid() {
        // Kasus: Input nilai minimum yang masih dianggap valid oleh validator (> 0)
        // Validator menolak jika semua 0, jadi kita pakai nilai sangat kecil
        StudentScore score = new StudentScore(0.0, 0.0, 0.1);
        
        double result = calculator.calculateFinal(score);
        
        // Hanya UAS yang dihitung: 0.4 * 0.1 = 0.04
        assertEquals(0.04, result, 0.001);
    }

    // ---------------------------------------------------------
    // Path P1: Validasi Gagal (Exception Thrown)
    // ---------------------------------------------------------

    @Test
    void testCalculateFinal_Exception_InputNegatif() {
        // Kasus: Salah satu nilai negatif
        // Validator harusnya return false
        StudentScore score = new StudentScore(-10.0, 50.0, 50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFinal(score);
        }, "Seharusnya melempar exception untuk input negatif");
    }

    @Test
    void testCalculateFinal_Exception_InputMelebihi100() {
        // Kasus: Salah satu nilai > 100
        // Validator harusnya return false
        StudentScore score = new StudentScore(101.0, 50.0, 50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFinal(score);
        });
    }

    @Test
    void testCalculateFinal_Exception_SemuaNol() {
        // Kasus: Semua nilai 0
        // Validator logic: !(tugas == 0 && uts == 0 && uas == 0) -> false
        StudentScore score = new StudentScore(0.0, 0.0, 0.0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFinal(score);
        });

        assertEquals("Data nilai tidak valid", exception.getMessage());
    }
}