import java.util.*;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Candidate> candidateHeap =
                new PriorityQueue<>((a, b) -> b.priority - a.priority);

        candidateHeap.add(new Candidate(
                "C1", 90,
                Arrays.asList(new Interval(9, 12), new Interval(14, 17))
        ));
        candidateHeap.add(new Candidate(
                "C2", 85,
                Arrays.asList(new Interval(10, 11))
        ));
        candidateHeap.add(new Candidate(
                "C3", 80,
                Arrays.asList(new Interval(15, 18))
        ));

        List<Interviewer> interviewers = new ArrayList<>();
        interviewers.add(new Interviewer(
                "I1",
                Arrays.asList(new Interval(9, 12), new Interval(14, 18)),
                3
        ));
        interviewers.add(new Interviewer(
                "I2",
                Arrays.asList(new Interval(10, 12)),
                2
        ));

        Scheduler scheduler = new Scheduler(interviewers);
        scheduler.schedule(candidateHeap);
        scheduler.report();
    }
}
