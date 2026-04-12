package kelompok1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreCalculatorTest {

  @Test
  public void testCalculateFinal_ValidScore() {
    ScoreCalculator calculator = new ScoreCalculator(new ScoreValidator());
    StudentScore score = new StudentScore(80, 70, 90);

    double result = calculator.calculateFinal(score);

    assertEquals(81.0, result, 0.0001);
  }

  @Test
  public void testCalculateFinal_InvalidScore_ThrowsException() {
    ScoreCalculator calculator = new ScoreCalculator(new ScoreValidator());
    StudentScore invalidScore = new StudentScore(-10, 80, 90);

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.calculateFinal(invalidScore));

    assertEquals("Data nilai tidak valid", exception.getMessage());
  }

  @Test
  public void testCalculateFinal_FinalScoreAboveMaximum_ThrowsException() {
    ScoreValidator alwaysValidValidator = new ScoreValidator() {
      @Override
      public boolean isValid(StudentScore score) {
        return true;
      }
    };

    ScoreCalculator calculator = new ScoreCalculator(alwaysValidValidator);
    StudentScore extremeScore = new StudentScore(200, 200, 200);

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.calculateFinal(extremeScore));

    assertEquals("Nilai akhir melebihi batas maksimum", exception.getMessage());
  }
}
