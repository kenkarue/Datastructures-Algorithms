package DSLinkedList;

import SharedClasses.Node;

/**
 * Merge Two Sorted LinkedList
 * Input::
 *   l1: 1->2->4
 *   l2: 1->3->4
 *
 * Output::
 *   merged: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] args){
        // scenario 1
        Node l1 = new Node(1, new Node(2, new Node(4, null)));
        Node l2 = new Node(1, new Node(3, new Node(4, null)));
        Node merged1 = merge(l1, l2);
        Node.print(merged1);
        // scenario 2
        Node l11 = new Node(1, new Node(2, null));
        Node l21 = new Node(1, new Node(3, new Node(4, null)));
        Node merged11 = merge(l11, l21);
        Node.print(merged11);
        // scenario 3
        Node l111 = null;
        Node l211 = new Node(1, new Node(3, new Node(4, null)));
        Node merged111 = merge(l111, l211);
        Node.print(merged111);
    }


    public static Node merge(Node l1, Node l2) {
        Node merged = new Node(-1, null);
        Node dummy = merged;
        while(l1 != null && l2 != null){
            Node temp = null;
            if(l1.value <= l2.value){
                temp = new Node(l1.value, null);
                l1 = l1.next;
            } else {
                temp = new Node(l2.value, null);
                l2 = l2.next;
            }
            merged.next = temp;
            merged = temp;
        }
        if(l1 != null){
            merged.next = l1;
        }
        if(l2 != null){
            merged.next = l2;
        }
        return dummy.next;
    }
}
