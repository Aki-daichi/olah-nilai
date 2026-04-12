package kelompok1;

public class FinalResult {
    private final double nilaiAkhir;
    private final char grade;
    private final String status;
    private final boolean isError;

    public FinalResult(double nilaiAkhir, char grade, String status, boolean isError) {
        this.nilaiAkhir = nilaiAkhir;
        this.grade = grade;
        this.status = status;
        this.isError = isError;
    }

    public double getNilaiAkhir() { return nilaiAkhir; }
    public char getGrade() { return grade; }
    public String getStatus() { return status; }
    public boolean isError() { return isError; }
}