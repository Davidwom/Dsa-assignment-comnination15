public class DLL {
    private Node head;

    private class Node {
        double data;
        Node prev, next;

        Node(double data) {
            this.data = data;
        }
    }

    public void insert(double data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node t = head;
            while (t.next != null) t = t.next;
            t.next = n;
            n.prev = t;
        }
    }

    public void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
}
