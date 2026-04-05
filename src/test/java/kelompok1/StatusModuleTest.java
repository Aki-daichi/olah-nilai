package kelompok1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Path Testing: StatusModule.getGraduationStatus()")
class StatusModuleTest {

  // P1: Nilai tidak valid (out of range)
  @ParameterizedTest(name = "[{index}] P1 invalid value={0} -> {1}")
  @CsvSource({
      "-1, Nilai Tidak Valid",
      "101, Nilai Tidak Valid",
      "1000, Nilai Tidak Valid"
  })
  void shouldReturnInvalidForOutOfRangeValues(double nilaiAkhir, String expected) {
    assertEquals(expected, StatusModule.getGraduationStatus(nilaiAkhir));
  }

  // P2: Nilai valid dan memenuhi batas lulus (>= 60)
  @ParameterizedTest(name = "[{index}] P2 pass value={0} -> {1}")
  @CsvSource({
      "60, Lulus",
      "75.5, Lulus",
      "100, Lulus"
  })
  void shouldReturnLulusForPassingScores(double nilaiAkhir, String expected) {
    assertEquals(expected, StatusModule.getGraduationStatus(nilaiAkhir));
  }

  // P3: Nilai valid tapi belum lulus (< 60)
  @ParameterizedTest(name = "[{index}] P3 fail value={0} -> {1}")
  @CsvSource({
      "0, Tidak Lulus",
      "59.99, Tidak Lulus",
      "45, Tidak Lulus"
  })
  void shouldReturnTidakLulusForFailingScores(double nilaiAkhir, String expected) {
    assertEquals(expected, StatusModule.getGraduationStatus(nilaiAkhir));
  }
}
