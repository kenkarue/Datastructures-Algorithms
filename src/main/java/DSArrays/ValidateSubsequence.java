package DSArrays;

import java.util.Stack;

/**
 * Input::
 *   Array    --> [5, 1, 22, 25, 6, -1, 8, 10]
 *   Sequence --> [1, 6, -1, 10]
 *
 * Output:: True, Because 1,6,-1,10 is a subsequence of array
 *
 */
public class ValidateSubsequence {

    public static void main(String[] args){
        int[] arr = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] seq = {1, 6, -1, 12};
        System.out.println(solution1(arr, seq)); // Stack
        System.out.println(solution2(arr, seq)); // efficient - one loop
    }

    /**
     * Put seq in hashset and remove item once you locate in hashset
     * Time --> 0(n + m)
     * Space --> 0(n)
     */
    private static boolean solution1(int[] arr, int[] seq){
        if(seq.length > arr.length){
            return false;
        }
        Stack<Integer> sequence = new Stack<>();
        for(int i = seq.length - 1; i >= 0; i--){
            sequence.push(seq[i]);
        }
        for(int j = 0; j < arr.length; j++){
            if(sequence.isEmpty()){
                return true;
            }
            if(arr[j] == sequence.peek()){
                sequence.pop();
            }
        }
        return sequence.isEmpty();
    }

    /**
     * Loop once through the array check if sequence exist
     * Time --> 0(n)
     * Space --> 0(1)
     */
    private static boolean solution2(int[] arr, int[] seq){
        if(seq.length > arr.length){
            return false;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(count == seq.length){
                break;
            }
            if(arr[i] == seq[count]){
                count++;
            }
        }
        return count == seq.length;
    }
}
