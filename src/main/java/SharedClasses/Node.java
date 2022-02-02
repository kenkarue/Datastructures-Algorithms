package SharedClasses;

public class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public void print(Node head){
        Node current = head.next;
        System.out.print(head.value);
        while(current != null){
            System.out.print(" -> "+current.value);
            current = current.next;
        }
        System.out.println("");
    }
}
