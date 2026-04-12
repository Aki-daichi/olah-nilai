package kelompok1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreEvaluatorTest {

    // Instansiasi objek yang akan dites
    private final ScoreEvaluator evaluator = new ScoreEvaluator();

    // ====================================================================
    // 1. Uji Coba Independent Paths untuk Method: getGrade()
    // ====================================================================

    @Test
    public void testGetGrade_Path1() {
        // Path 1: Node 1 -> 2 -> 10 (nilaiAkhir >= 85)
        // Expected: 'A'
        assertEquals('A', evaluator.getGrade(85.0));
        assertEquals('A', evaluator.getGrade(92.0));
    }

    @Test
    public void testGetGrade_Path2() {
        // Path 2: Node 1 -> 3 -> 4 -> 10 (70 <= nilaiAkhir < 85)
        // Expected: 'B'
        assertEquals('B', evaluator.getGrade(75.0));
        assertEquals('B', evaluator.getGrade(70.0));
    }

    @Test
    public void testGetGrade_Path3() {
        // Path 3: Node 1 -> 3 -> 5 -> 6 -> 10 (60 <= nilaiAkhir < 70)
        // Expected: 'C'
        assertEquals('C', evaluator.getGrade(65.0));
        assertEquals('C', evaluator.getGrade(60.0));
    }

    @Test
    public void testGetGrade_Path4() {
        // Path 4: Node 1 -> 3 -> 5 -> 7 -> 8 -> 10 (50 <= nilaiAkhir < 60)
        // Expected: 'D'
        assertEquals('D', evaluator.getGrade(55.0));
        assertEquals('D', evaluator.getGrade(50.0));
    }

    @Test
    public void testGetGrade_Path5() {
        // Path 5: Node 1 -> 3 -> 5 -> 7 -> 9 -> 10 (nilaiAkhir < 50)
        // Expected: 'E'
        assertEquals('E', evaluator.getGrade(45.0));
        assertEquals('E', evaluator.getGrade(0.0));
    }

    // ====================================================================
    // 2. Uji Coba Independent Paths untuk Method: getGraduationStatus()
    // ====================================================================

    @Test
    public void testGetGraduationStatus_Path1() {
        // Path 1: isNaN = True
        // Expected: "Nilai Tidak Valid"
        assertEquals("Nilai Tidak Valid", evaluator.getGraduationStatus(Double.NaN));
    }

    @Test
    public void testGetGraduationStatus_Path2() {
        // Path 2: isNaN = False, nilaiAkhir < 0 = True
        // Expected: "Nilai Tidak Valid"
        assertEquals("Nilai Tidak Valid", evaluator.getGraduationStatus(-5.0));
    }

    @Test
    public void testGetGraduationStatus_Path3() {
        // Path 3: isNaN = False, nilai < 0 = False, nilai > 100 = True
        // Expected: "Nilai Tidak Valid"
        assertEquals("Nilai Tidak Valid", evaluator.getGraduationStatus(105.0));
    }

    @Test
    public void testGetGraduationStatus_Path4() {
        // Path 4: Semua Valid, nilaiAkhir >= 60 = True
        // Expected: "Lulus"
        assertEquals("Lulus", evaluator.getGraduationStatus(75.0));
        assertEquals("Lulus", evaluator.getGraduationStatus(60.0));
    }

    @Test
    public void testGetGraduationStatus_Path5() {
        // Path 5: Semua Valid, nilaiAkhir >= 60 = False
        // Expected: "Tidak Lulus"
        assertEquals("Tidak Lulus", evaluator.getGraduationStatus(45.0));
        assertEquals("Tidak Lulus", evaluator.getGraduationStatus(59.9));
    }
}