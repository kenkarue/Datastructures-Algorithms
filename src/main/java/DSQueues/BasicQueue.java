package DSQueues;

public class BasicQueue {

    static int SIZE = 5;
    static int[] queue = new int[SIZE];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args){
        enqueue(3);
        enqueue(4);
        enqueue(5);
        enqueue(6);
        enqueue(7);
        System.out.println(peek());
        dequeue();
        enqueue(2);
        dequeue();
        System.out.println(peek());

    }

    private static void enqueue(int item){
        if(isFull()){
            throw new IllegalArgumentException("Queue Is Full");
        }
        if(front == -1){
            front++;
        }
        rear++;
        queue[rear] = item;
    }

    private static int dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue Is Empty");
        }
        int item = queue[front];
        front++;
        if(front > rear){
            front = -1;
            rear = -1;
        }
        return item;
    }

    private static int peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue Is Empty");
        }
        return queue[front];
    }

    private static boolean isFull() {
        if(front == 0 && rear == SIZE - 1){
           return true;
        }
        return false;
    }

    private static boolean isEmpty() {
        if(front == -1){
            return true;
        }
        return false;
    }
}
