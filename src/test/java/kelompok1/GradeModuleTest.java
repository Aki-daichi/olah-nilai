package kelompok1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GradeModuleTest {

    @ParameterizedTest(name = "nilaiAkhir={0} => grade={1}")
    @CsvSource({
        "100, A",
        "85, A",
        "84.99, B",
        "70, B",
        "69.99, C",
        "60, C",
        "59.99, D",
        "50, D",
        "49.99, E",
        "0, E",
        "-10, E"
    })
    void shouldReturnExpectedGrade(double nilaiAkhir, char expectedGrade) {
        char actualGrade = GradeModule.getGrade(nilaiAkhir);
        assertEquals(expectedGrade, actualGrade);
    }
}
