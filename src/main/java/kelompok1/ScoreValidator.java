package kelompok1;

public class ScoreValidator {
    public boolean isValid(StudentScore score) {
        double tugas = score.getTugas();
        double uts = score.getUts();
        double uas = score.getUas();
        
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            return false;
        }
        return !(tugas == 0 && uts == 0 && uas == 0);
    }
}