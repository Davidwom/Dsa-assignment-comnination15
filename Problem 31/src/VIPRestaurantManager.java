import java.util.HashMap;

public class VIPRestaurantManager {

    private Node head; // front
    private Node tail; // back
    private HashMap<String, Node> map;

    public VIPRestaurantManager() {
        head = null;
        tail = null;
        map = new HashMap<>();
    }
    public void arrive(String name) {
        Node node = new Node(name);

        if (tail == null) { // empty list
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        map.put(name, node);
    }
    public void arriveVIP(String name) {
        Node node = new Node(name);

        if (head == null) { // empty list
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        map.put(name, node);
    }
    public void leave(String name) {
        Node node = map.get(name);

        if (node == null) {
            System.out.println(name + " not found.");
            return;
        }

        removeNode(node);
        map.remove(name);
    }
    public void seat() {
        if (head == null) {
            System.out.println("No customers to seat.");
            return;
        }

        System.out.println("Seating " + head.name);
        map.remove(head.name);
        removeNode(head);
    }
    public void showLine() {
        Node current = head;
        System.out.print("Line: ");

        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // removing head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // removing tail
        }
    }
}
