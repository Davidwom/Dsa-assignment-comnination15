public class Stack {
    private Node top;

    class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(double data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    public double pop() {
        if (isEmpty()) return -1;
        double d = top.data;
        top = top.next;
        return d;
    }

    public void display() {
        Node t = top;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
}
