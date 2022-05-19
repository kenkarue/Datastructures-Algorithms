package DSStack;

public class ImplementationByArray {

    static int top = -1;
    static int[] stack = new int[3];

    public static void main(String[] args){
        push(23);
        push(31);
        System.out.println(peek());
        push(14);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(peek());
    }

    private static void push(int item){
        if(isFull()){
            throw new IllegalArgumentException("Stack Is Full");
        }
        top++;
        stack[top] = item;
    }

    private static int pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack Is Empty");
        }
        int topItem = stack[top];
        top--;
        return topItem;
    }

    private static int peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack Is Empty");
        }
        return stack[top];
    }

    private static boolean isFull(){
        if(top >= stack.length - 1){
            return true;
        }
        return false;
    }

    private static boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
}
