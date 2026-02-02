public class Queue {
    private Node front, rear;

    class Node {
        double data;
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

    public void enqueue(double data) {
        Node n = new Node(data);
        if (isEmpty()) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }

    public double dequeue() {
        if (isEmpty()) return -1;
        double d = front.data;
        front = front.next;
        if (front == null) rear = null;
        return d;
    }

    public void display() {
        Node t = front;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
}
