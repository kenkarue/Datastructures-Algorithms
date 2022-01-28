package DSLinkedList;

import SharedClasses.SinglyLinkedNode;

/**
 * Input::
 *    LinkedList --> 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6
 *
 *  Output::
 *    LinkedList --> 1 -> 3 -> 4 -> 5 ->6
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        // create static linkedlist
        SinglyLinkedNode head = new SinglyLinkedNode(1);
        head.next = new SinglyLinkedNode(1);
        head.next.next = new SinglyLinkedNode(3);
        head.next.next.next = new SinglyLinkedNode(4);
        head.next.next.next.next = new SinglyLinkedNode(4);
        head.next.next.next.next.next = new SinglyLinkedNode(4);
        head.next.next.next.next.next.next = new SinglyLinkedNode(5);
        head.next.next.next.next.next.next.next = new SinglyLinkedNode(6);
        head.next.next.next.next.next.next.next.next = new SinglyLinkedNode(6);

        new SinglyLinkedNode().print(head);
        solution1(head);
        new SinglyLinkedNode().print(head);
    }

    private static void solution1(SinglyLinkedNode head) {
        SinglyLinkedNode current = head;
        while(current != null && current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
}
