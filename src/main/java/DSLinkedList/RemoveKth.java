package DSLinkedList;

import SharedClasses.Node;

/**
 * Remove the kth node in-place
 * Input:
 *   Node: 1 -> 7 -> 3 -> 4 -> 9 -> 8 -> 5 -> 6
 *   k: 4
 * Output:
 *  From Start: Node: 1 -> 7 -> 3 -> 9 -> 8 -> 5 -> 6
 *  From End:   Node: 1 -> 7 -> 3 -> 4 -> 8 -> 5 -> 6
 *
 * Input:
 *   Node: 1 -> 7 -> 3 -> 4 -> 9 -> 8 -> 5 -> 6
 *   k: 8
 *   k: 1
 * Output:
 *  From Start (Input 1): Node: 7 -> 3 -> 4 -> 9 -> 8 -> 5 -> 6
 *  From End (Input 8):   Node: 7 -> 3 -> 4 -> 9 -> 8 -> 5 -> 6
 */
public class RemoveKth {

    public static Node head;

    public static void main(String[] args){
        // 1 -> 7 -> 3 -> 4 -> 9 -> 8 -> 5 -> 6
        head = new Node(1);
        head.next = new Node(7);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next = new Node(6);

        //
        Node printing = new Node();
        removeKthNodeFromStart(4);
        printing.print(head);

//        removeKthNodeFromEnd(4); // time complexity 0(n)/ space 0(1)
//        printing.print(head);

//        removeKthNodeFromEnd1(4); // more optimized - time complexity 0(n)/ space 0(1)
//        printing.print(head);
    }

    /**
     * Space - 0(1)
     * Time  - 0(n)
     */
    public static void removeKthNodeFromStart(int k){
        Node current = head;
        Node previous = null;
        while(current != null){
            k--;
            if(k == 0){
                Node nextNode = current.next;
                if(previous != null){
                    previous.next = nextNode;
                }
                if(nextNode != null){
                    nextNode.prev = previous;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Space - 0(1)
     * Time  - 0(n)
     */
    public static void removeKthNodeFromEnd(int k){
        Node currentA = head;  // 1 -> 2 -> 3 -> 4 -> 5
        // do count
        int count = 0;
        while(currentA != null) {
            currentA = currentA.next;
            count++;
        }
        // remove
        int remove = (count - k) + 1;
        Node currentB = head;
        // if head
        if(remove == 1){
            head.value = currentB.next.value;
            head.next = currentB.next.next;
            return;
        }
        // not head
        Node previous = null;
        while(currentB != null){
            remove--;
            if(remove == 0){
                previous.next = currentB.next;
                return;
            }
            previous = currentB;
            currentB = currentB.next;
        }
    }

    /**
     * Space - 0(1)
     * Time  - 0(n)
     */
    public static void removeKthNodeFromEnd1(int k){
        Node nodeA = head;
        Node nodeB = head;
        int counter = 1;
        while(counter <= k){
            nodeA = nodeA.next;
            counter++;
        }
        if(nodeA == null){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while(nodeA.next != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        nodeB.next = nodeB.next.next;
    }
}
