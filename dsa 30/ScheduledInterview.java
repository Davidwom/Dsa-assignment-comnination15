public class ScheduledInterview {
    String candidateId;
    String interviewerId;
    int start;
    int end;

    public ScheduledInterview(String c, String i, int start, int end) {
        this.candidateId = c;
        this.interviewerId = i;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return candidateId + " <-> " + interviewerId +
               " @ " + start + ":00-" + end + ":00";
    }
}
