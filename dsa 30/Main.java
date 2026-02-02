import java.util.*;

class Interval {
    int start, end;
    Interval(int s, int e) { start = s; end = e; }
}

class Candidate {
    String id;
    int priority;
    List<Interval> windows;

    Candidate(String id, int priority, List<Interval> windows) {
        this.id = id;
        this.priority = priority;
        this.windows = windows;
        // Sort windows for binary search
        this.windows.sort(Comparator.comparingInt(a -> a.start));
    }
}

class Interviewer {
    String id;
    LinkedList<Interval> slots;
    int capacity;

    Interviewer(String id, LinkedList<Interval> slots, int capacity) {
        this.id = id;
        this.slots = slots;
        this.capacity = capacity;
        // Sort slots for binary search
        this.slots.sort(Comparator.comparingInt(a -> a.start));
    }
}

public class Main {

    PriorityQueue<Candidate> candidateHeap;
    List<Interviewer> interviewers; // Array of linked lists
    List<String> schedule;
    List<String> unscheduled;

    public Main() {
        candidateHeap = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        interviewers = new ArrayList<>();
        schedule = new ArrayList<>();
        unscheduled = new ArrayList<>();
    }

    static List<Interval> parseRanges(String ranges) {
        List<Interval> list = new ArrayList<>();
        for (String r : ranges.split(",")) {
            r = r.trim();
            String[] parts = r.split("-");
            list.add(new Interval(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())));
        }
        return list;
    }

    // Binary search for overlap
    static Integer findOverlap(List<Interval> cWindows, LinkedList<Interval> iSlots) {
        for (Interval c : cWindows) {
            int lo = 0, hi = iSlots.size() - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                Interval i = iSlots.get(mid);
                int start = Math.max(c.start, i.start);
                if (start + 1 <= Math.min(c.end, i.end)) {
                    return start; // Found overlap
                }
                if (i.end < c.start) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return null;
    }

    static void consumeInterval(List<Interval> list, int time) {
        ListIterator<Interval> it = list.listIterator();
        while (it.hasNext()) {
            Interval in = it.next();
            if (in.start <= time && time + 1 <= in.end) {
                it.remove();
                if (in.start < time) it.add(new Interval(in.start, time));
                if (time + 1 < in.end) it.add(new Interval(time + 1, in.end));
                return;
            }
        }
    }

    public void addCandidate(String id, int priority, String windows) {
        candidateHeap.add(new Candidate(id, priority, parseRanges(windows)));
    }

    public void addInterviewer(String id, String slots, int capacity) {
        interviewers.add(new Interviewer(id, new LinkedList<>(parseRanges(slots)), capacity));
    }

    public void scheduleInterviews() {
        while (!candidateHeap.isEmpty()) {
            Candidate c = candidateHeap.poll();
            Interviewer best = null;
            Integer bestTime = null;
            int maxCap = -1;

            for (Interviewer i : interviewers) {
                if (i.capacity > 0) {
                    Integer t = findOverlap(c.windows, i.slots);
                    if (t != null && i.capacity > maxCap) {
                        best = i;
                        bestTime = t;
                        maxCap = i.capacity;
                    }
                }
            }

            if (best == null) {
                unscheduled.add(c.id);
            } else {
                schedule.add("Candidate " + c.id + " with Interviewer " +
                        best.id + " from " + bestTime + " to " + (bestTime + 1));
                consumeInterval(best.slots, bestTime);
                consumeInterval(c.windows, bestTime); // FIX: update candidate availability
                best.capacity--;
            }
        }
    }

    public void report() {
        System.out.println("\nScheduled Interviews:");
        for (String s : schedule) System.out.println(s);

        System.out.println("\nUnscheduled Candidates:");
        for (String u : unscheduled) System.out.println(u);
    }

    public static void main(String[] args) {
        Main scheduler = new Main();
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                String line = sc.nextLine().trim();
                if (line.equalsIgnoreCase("EXIT")) break;

                String[] parts = line.split(" ");
                switch (parts[0].toUpperCase()) {
                    case "CANDIDATE":
                        scheduler.addCandidate(parts[1],
                                Integer.parseInt(parts[2]),
                                parts[3]);
                        break;
                    case "INTERVIEWER":
                        scheduler.addInterviewer(parts[1],
                                parts[2],
                                Integer.parseInt(parts[3]));
                        break;
                    case "SCHEDULE":
                        scheduler.scheduleInterviews();
                        break;
                    case "REPORT":
                        scheduler.report();
                        break;
                    default:
                        System.out.println("Unknown command.");
                }
            }
        }
    }
}

