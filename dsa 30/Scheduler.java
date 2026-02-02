import java.util.*;

public class Scheduler {

    private List<Interviewer> interviewers;
    private List<ScheduledInterview> scheduled;
    private List<Candidate> unscheduled;

    public Scheduler(List<Interviewer> interviewers) {
        this.interviewers = interviewers;
        this.scheduled = new ArrayList<>();
        this.unscheduled = new ArrayList<>();
    }

    public void schedule(PriorityQueue<Candidate> heap) {
        while (!heap.isEmpty()) {
            Candidate candidate = heap.poll();
            boolean done = trySchedule(candidate);
            if (!done) {
                unscheduled.add(candidate);
            }
        }
    }

    private boolean trySchedule(Candidate c) {
        Interviewer chosen = null;
        Interval chosenCandidateSlot = null;
        Interval chosenInterviewerSlot = null;
        int chosenStart = -1;

        for (Interviewer interviewer : interviewers) {
            if (interviewer.remainingCapacity() <= 0) continue;

            for (Interval cSlot : c.availability) {
                for (Interval iSlot : interviewer.availability) {
                    int start = Math.max(cSlot.start, iSlot.start);
                    if (start + 1 <= Math.min(cSlot.end, iSlot.end)) {
                        if (chosen == null ||
                            interviewer.remainingCapacity() > chosen.remainingCapacity()) {

                            chosen = interviewer;
                            chosenCandidateSlot = cSlot;
                            chosenInterviewerSlot = iSlot;
                            chosenStart = start;
                        }
                    }
                }
            }
        }

        if (chosen == null) return false;

        // consume 1 hour
        consumeInterval(chosenCandidateSlot, chosenStart);
        consumeInterval(chosenInterviewerSlot, chosenStart);
        chosen.used++;

        scheduled.add(new ScheduledInterview(
                c.id,
                chosen.id,
                chosenStart,
                chosenStart + 1
        ));

        return true;
    }

    private void consumeInterval(Interval interval, int start) {
        interval.start = start + 1;
    }

    public void report() {
        System.out.println("\nScheduled Interviews:");
        for (ScheduledInterview s : scheduled) {
            System.out.println("- " + s);
        }

        System.out.println("\nUnscheduled Candidates:");
        if (unscheduled.isEmpty()) {
            System.out.println("None");
        } else {
            for (Candidate c : unscheduled) {
                System.out.println("- " + c.id);
            }
        }

        System.out.println();
        for (Interviewer i : interviewers) {
            System.out.println(i.id + " used " + i.used + "/" + i.maxPerDay + " slots.");
        }
    }
}
