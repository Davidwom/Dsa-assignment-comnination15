import java.util.LinkedList;
import java.util.List;

public class Interviewer {
    String id;
    List<Interval> availability; // LinkedList required
    int maxPerDay;
    int used;

    public Interviewer(String id, List<Interval> availability, int maxPerDay) {
        this.id = id;
        this.availability = new LinkedList<>(availability);
        this.maxPerDay = maxPerDay;
        this.used = 0;
    }

    public int remainingCapacity() {
        return maxPerDay - used;
    }
}
