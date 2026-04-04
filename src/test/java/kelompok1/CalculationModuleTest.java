package kelompok1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Path Testing: CalculationModule.calculateFinal()")
class CalculationModuleTest {

    // Toleransi Epsilon untuk perbandingan bilangan floating-point (IEEE 754)
    private static final double DELTA = 0.0001;

    // PATH P1: Input fails validation → return value -1.0
    @ParameterizedTest(name = "[{index}] Path 1 | Tugas={0}, UTS={1}, UAS={2} = Expected: {3}")
    @CsvSource({
        "-10, 80, 90, -1.0",   // Lower bound violation (TC-CALC-01)
        "0, 0, 0, -1.0",       // All-zeros (TC-CALC-02)
        "101, 75, 80, -1.0",   // Upper bound violation (TC-CALC-03)
        "85, -5, 90, -1.0"     // Input invalid campur
    })
    void testPath1_InvalidInput_ReturnsMinusOne(double tugas, double uts, double uas, double expected) {
        assertEquals(expected, CalculationModule.calculateFinal(tugas, uts, uas), DELTA);
    }

    // PATH P3: Input valid, total nilai ≤ 100
    @ParameterizedTest(name = "[{index}] Path 3 | Tugas={0}, UTS={1}, UAS={2} = Expected: {3}")
    @CsvSource({
        "80, 85, 90, 85.5",     // Standard weighted average (TC-CALC-05)
        "50, 50, 50, 50.0",     // Uniform boundary (TC-CALC-06)
        "100, 100, 99.9, 99.96",// Near-upper-bound precision (TC-CALC-07)
        "0, 0, 1, 0.4",         // Input valid minimal
        "33.33, 33.33, 33.33, 33.33" // Stress test nilai decimal
    })
    void testPath3_ValidInput_ReturnsCorrectScore(double tugas, double uts, double uas, double expected) {
        assertEquals(expected, CalculationModule.calculateFinal(tugas, uts, uas), DELTA);
    }

    // PATH P2: Input valid, tapi total nilai melebihi 100
    @Test
    @DisplayName("Path P2: Input valid, tapi total nilai melebihi 100")
    void testPath2_UpperBoundCheck() {
        // Verifikasi behavior di batas atas: max valid input bernilai tepat 100.0
        double boundaryResult = CalculationModule.calculateFinal(100, 100, 100);
        assertEquals(100.0, boundaryResult, DELTA, "max valid input harus bernilai tepat 100.0");
    }
}
