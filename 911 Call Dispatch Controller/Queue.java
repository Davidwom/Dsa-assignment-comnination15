public class Queue {

    private Node front, rear;

    class Node {
        double data;   // call ID or priority value
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Add emergency call
    public void enqueue(double data) {
        Node n = new Node(data);

        if (isEmpty()) {
            front = rear = n;
        } else {
            rear.next = n;   // correct FIFO logic
            rear = n;
        }
    }

    // Dispatch emergency call
    public double dequeue() {
        if (isEmpty()) {
            System.out.println("No emergency calls in queue");
            return -1;
        }

        double dequeuedData = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return dequeuedData;
    }

    public double peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public void display() {
        Node t = front;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    public static void main(String[] args) {
        Queue callQueue = new Queue();

        callQueue.enqueue(101);
        callQueue.enqueue(10000092);
        callQueue.enqueue(103);

        callQueue.display();
        System.out.println("\nDispatched Call: " + callQueue.dequeue());
        System.out.println("Next Call: " + callQueue.peek());
    }
}