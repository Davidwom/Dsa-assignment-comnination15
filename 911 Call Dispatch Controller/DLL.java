public class DLL {

    private Node head;

    private class Node {
        double data;   // unit ID
        Node prev, next;

        Node(double data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DLL() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Add emergency unit
    public void insert(double data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void displayBackward() {
        if (head == null) return;

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        DLL units = new DLL();

        units.insert(201);
        units.insert(202);
        units.insert(203);

        System.out.print("Units Forward: ");
        units.displayForward();

        System.out.print("\nUnits Backward: ");
        units.displayBackward();
    }
}