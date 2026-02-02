import java.util.List;

public class Candidate {
    String id;
    int priority;
    List<Interval> availability;

    public Candidate(String id, int priority, List<Interval> availability) {
        this.id = id;
        this.priority = priority;
        this.availability = availability;
    }
}
