package DSArrays;

import java.util.Arrays;

/**
 * Input:
 *   Array: 1,4,20,3,10,5
 *   int: 33
 * Output:
 *   Array {2, 4}
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args){
        // int[] arr = new int[]{1,4,20,3,10,5};
        // int target = 33;
        // int[] arr = new int[]{1, 4, 0, 0, 3, 10, 5};
        // int target = 7;
        int[] arr = new int[]{1, 4};
        int target = 0;
        //
        System.out.println(Arrays.toString(subArray(arr, target)));
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static int[] subArray(int[] arr, int target){
        int start = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
           sum += arr[i];
           if(sum == target){
               return new int[]{start, i};
           }
           while(sum > target){
              sum -= arr[start];
              start++;
               if(sum == target && start <= i){
                   return new int[]{start, i};
               }
           }
        }
        return new int[]{-1, -1};
    }
}
