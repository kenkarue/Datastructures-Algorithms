package DSLinkedList;

import SharedClasses.Node;

/**
 * Input::
 *   Node: 1 -> 2 -> 3
 * Output::
 *   Node: 2
 */
public class MiddleOfList {

    public static void main(String[] args){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;

        Node mid = solution1(a);
        System.out.println(mid.value);
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static Node solution(Node head) {
        Node currentA = head;
        Node currentB = head;
        int count = 0;
        while(currentA != null){
            currentA = currentA.next;
            count++;
        }
        System.out.println("Count:: "+count+" :: "+count/2);
        count /= 2;
        while(count != 0){
            currentB = currentB.next;
            count--;
        }
        return currentB;
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static Node solution1(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
