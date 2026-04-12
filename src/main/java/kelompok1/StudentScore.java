package kelompok1;

public class StudentScore {
    private final double tugas;
    private final double uts;
    private final double uas;

    public StudentScore(double tugas, double uts, double uas) {
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    public double getTugas() { return tugas; }
    public double getUts() { return uts; }
    public double getUas() { return uas; }
}