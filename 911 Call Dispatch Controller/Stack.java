public class Stack {

    private Node top;

    class Node {
        double data;   // action ID
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Record dispatcher action
    public void push(double data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    // Undo last action
    public double pop() {
        if (isEmpty()) {
            System.out.println("No actions to undo");
            return -1;
        }

        double poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public double peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public void display() {
        Node t = top;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    public static void main(String[] args) {
        Stack actionStack = new Stack();

        actionStack.push(1);
        actionStack.push(2);
        actionStack.push(3);

        actionStack.display();
        System.out.println("\nUndo Action: " + actionStack.pop());
        System.out.println("Last Action: " + actionStack.peek());
    }
}