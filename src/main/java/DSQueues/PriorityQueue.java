package DSQueues;

public class PriorityQueue {

    static int[] priorityQueue = new int[5];
    static int count = 0;

    private static void add(int x){
        // full
        if(count == priorityQueue.length){
            return;
        }
        // swapping
        int i;
        for(i = count-1; i >= 0; i--){
            if(priorityQueue[i] > x){
                priorityQueue[i + 1] = priorityQueue[i];
            } else {
                break;
            }
        }
        // add
        priorityQueue[i+1] = x;
        count++;
    }

    private static void print(){
        for(int i = 0; i < priorityQueue.length; i++){
            System.out.println(priorityQueue[i]);
        }
    }

    public static void main(String[] args){
        add(3);
        add(2);
        add(5);
        add(1);
        add(4);
        print();
    }
}
