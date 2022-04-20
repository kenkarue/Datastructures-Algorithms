package SharedClasses;

public class Node {
    public int value;
    public Node prev;
    public Node next;
    public String label;

    public Node(int value) {
        this.value = value;
    }

    public Node(String label) {
        this.label = label;
    }

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static void print(Node head){
        Node current = head.next;
        System.out.print(head.value);
        while(current != null){
            System.out.print(" -> "+current.value);
            current = current.next;
        }
        System.out.println("");
    }
}
