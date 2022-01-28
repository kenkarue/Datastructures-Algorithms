package SharedClasses;

public class SinglyLinkedNode {

    public SinglyLinkedNode next;
    public int val;

    public SinglyLinkedNode(){
    }
    public SinglyLinkedNode(int val){
        this.next = null;
        this.val = val;
    }

    public void print(SinglyLinkedNode head){
        SinglyLinkedNode current = head.next;
        System.out.print(head.val);
        while(current != null){
            System.out.print(" -> "+current.val);
            current = current.next;
        }
        System.out.println("");
    }
}
