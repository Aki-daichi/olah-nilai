package kelompok1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreValidatorTest {

  private final ScoreValidator validator = new ScoreValidator();

  @Test
  public void testIsValid_WhenAllScoresInRangeAndNotAllZero_ReturnsTrue() {
    StudentScore score = new StudentScore(80, 75, 90);

    assertTrue(validator.isValid(score));
  }

  @Test
  public void testIsValid_WhenBoundaryScores_ReturnsTrue() {
    StudentScore scoreLowerBoundary = new StudentScore(0, 50, 100);
    StudentScore scoreUpperBoundary = new StudentScore(100, 100, 1);

    assertTrue(validator.isValid(scoreLowerBoundary));
    assertTrue(validator.isValid(scoreUpperBoundary));
  }

  @Test
  public void testIsValid_WhenAnyScoreBelowZero_ReturnsFalse() {
    assertFalse(validator.isValid(new StudentScore(-1, 80, 90)));
    assertFalse(validator.isValid(new StudentScore(80, -1, 90)));
    assertFalse(validator.isValid(new StudentScore(80, 90, -1)));
  }

  @Test
  public void testIsValid_WhenAnyScoreAboveHundred_ReturnsFalse() {
    assertFalse(validator.isValid(new StudentScore(101, 80, 90)));
    assertFalse(validator.isValid(new StudentScore(80, 101, 90)));
    assertFalse(validator.isValid(new StudentScore(80, 90, 101)));
  }

  @Test
  public void testIsValid_WhenAllScoresAreZero_ReturnsFalse() {
    StudentScore score = new StudentScore(0, 0, 0);

    assertFalse(validator.isValid(score));
  }
}
