import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DispatchController {

    // Emergency Call
    static class Call {
        String id;
        int severity;
        long arrivalTime;

        Call(String id, int severity, long arrivalTime) {
            this.id = id;
            this.severity = severity;
            this.arrivalTime = arrivalTime;
        }
    }

    private PriorityQueue<Call> heap;
    private Map<String, Call> callMap;
    private long time;

    // Integrated structures
    public Queue callLog;
    public Stack actionHistory;
    public DLL units;

    public DispatchController() {
        time = 0;

        heap = new PriorityQueue<>(
            (a, b) -> {
                if (a.severity != b.severity)
                    return a.severity - b.severity;
                return Long.compare(a.arrivalTime, b.arrivalTime);
            }
        );

        callMap = new HashMap<>();
        callLog = new Queue();
        actionHistory = new Stack();
        units = new DLL();
    }

    public void call(String id, int severity) {
        Call c = new Call(id, severity, time++);
        heap.offer(c);
        callMap.put(id, c);

        callLog.enqueue(severity);
        actionHistory.push(1); // CALL action

        System.out.println("CALL: " + id + " (Sev " + severity + ")");
    }

    public void dispatch() {
        if (heap.isEmpty()) {
            System.out.println("No calls to dispatch");
            return;
        }

        Call c = heap.poll();
        callMap.remove(c.id);
        actionHistory.push(2); // DISPATCH action
        System.out.println("DISPATCHED: " + c.id +
                " (Sev " + c.severity + ")");
    }

    public void escalate(String id, int newSeverity) {
        Call c = callMap.get(id);
        if (c == null) return;

        heap.remove(c);
        c.severity = newSeverity;
        heap.offer(c);
        actionHistory.push(3); // ESCALATE action

        System.out.println("ESCALATED: " + id +
                " to Sev " + newSeverity);
    }
}
