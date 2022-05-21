package DSQueues;

public class CircularQueue {

    static int SIZE = 3;
    static int[] queue = new int[SIZE];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args){
        enqueue(2);
        enqueue(3);
        enqueue(5);
        System.out.println(dequeue());
        System.out.println(peek());
        enqueue(9);
        System.out.println(dequeue());
        System.out.println(peek());
        enqueue(1);
        System.out.println(peek());
    }

    private static void enqueue(int item){
       if(isFull()){
           throw new IllegalArgumentException("Queue Is Full");
       }
       if(front == -1){
           front++;
       }
       rear = (rear + 1) % SIZE;
       queue[rear] = item;
    }

    private static int dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue Is Empty");
        }
        int item = queue[front];
        if (front == rear){
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
        return item;
    }

    private static int peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue Is Empty");
        }
        return queue[front];
    }

    private static boolean isFull(){
        if(front == 0 && rear == SIZE - 1){
            return true;
        }
        if(front == rear + 1){
            return true;
        }
        return false;
    }

    private static boolean isEmpty(){
        if(front == -1){
            return true;
        }
        return false;
    }
}
