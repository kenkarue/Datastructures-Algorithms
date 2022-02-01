package SharedClasses;

/**
 * Doubly LinkedList  Implementation
 */
public class DoublyLinkedList {

    public Node head;
    public Node tail;


    public void  print() {
        System.out.print(head.value);
        Node current = head.next;
        while(current != null){
            System.out.print(" -> "+current.value);
            current = current.next;
        }
    }

    public void setHead(Node node) {
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        Node temp = head;
        temp.prev = node;
        node.next = temp;
        head = node;
        print();
    }

    public void setTail(Node node) {
        if(tail == null){
            head = node;
            tail = node;
            return;
        }
        Node temp = tail;
        temp.next = node;
        node.prev = temp;
        tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if(node == head){
            setHead(nodeToInsert);
            return;
        }
        Node current = head;
        Node previous = null;
        while(current != null){
            if(current == node){
                previous.next = nodeToInsert;
                nodeToInsert.prev = previous;
                nodeToInsert.next = current;
                current.prev = nodeToInsert;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if(node == tail){
            setTail(nodeToInsert);
            return;
        }
        Node current = head;
        while(current != null && current.next != null){
            if(current == node){
              Node nextNode = current.next;
              current.next = nodeToInsert;
              nodeToInsert.prev = current;
              nodeToInsert.next = nextNode;
              nextNode.prev = nodeToInsert;
              return;
            }
            current = current.next;
        }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        if(position == 1){
            setHead(nodeToInsert);
            return;
        }
        Node current = head;
        Node previous = null;
        while(current != null){
            position--;
            if(position == 0){
                previous.next = nodeToInsert;
                nodeToInsert.prev = previous;
                nodeToInsert.next = current;
                current.prev = nodeToInsert;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void removeNodesWithValue(int value) {
        Node current = head;
        Node previous = null;
        while(current != null){
            if(current.value == value && current == head && current == tail){
                head = null;
                tail = null;
                return;
            }
            if(current.value == value && current == head){
                Node nextNode = current.next;
                nextNode.prev = null;
                head = nextNode;
                current = head;
            } else if (current.value == value ) {
                Node nextNode = current.next;
                nextNode.prev = previous;
                previous.next = nextNode;
                current = nextNode;
            } else {
                previous = current;
                current = current.next;
            }
        }
        tail = previous;
    }

    public void remove(Node node) {
        Node current = head;
        Node previous = null;
        while(current != null){
            if(current == node && node == head && node == tail){
                tail = null;
                head = null;
                return;
            }
            if(current == node && node == head){
                Node nextNode = current.next;
                nextNode.prev = null;
                head = nextNode;
                current = head;
            } else if (current == node){
                Node nextNode = current.next;
                nextNode.prev = previous;
                previous.next = nextNode;
                current = nextNode;
            } else {
                previous = current;
                current = current.next;
            }
        }
        tail = previous;
    }

    public boolean containsNodeWithValue(int value) {
        Node current = head;
        while(current != null){
            if(current.value == value){
                return true;
            }
        }
        return false;
    }
}
