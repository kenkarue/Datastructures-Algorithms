package DSArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Input::
 *  Array --> [3,4,-5,8,11,1,-1,6]
 *  Target --> 10
 *
 * Assumptions:
 *   --> Array is distinct
 *
 * Output - [-1, 11]
 */
public class TwoSum {

    public static void main(String[] args){
        int[] arr = {3,4,-5,8,11,1,-1,6};
        int targetSum = 10;
        System.out.println(solution1(arr, targetSum)); // brute force
        System.out.println(solution2(arr, targetSum)); // sorting/sliding window
        System.out.println(solution3(arr, targetSum)); // using Set


    }

    /**
     * Navigate through the whole array from array[i] to array[size -1] checking the sum
     * Time = o(n*2)
     * Space = o(1)
     */
    private static int[] solution1(int[] arr, int targetSum) {
        for(int i = 0; i < arr.length - 2; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == targetSum){
                    return new int[] {arr[i], arr[j]};
                }
            }
        }
        return new int[0];
    }

    /**
     * Sort, use sliding window from left to right
     * Time - 0(n)
     * Space - 0(1)
     */
    private static int[] solution2(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left != right){
            if(arr[left] + arr[right] == targetSum){
                return new int []{arr[left], arr[right]};
            }
            if(arr[left] + arr[right] < targetSum){
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    /**
     * Use Set and check if remainder exist
     * Time --> 0(n)
     * Space --> 0(n)
     */
    private static int[] solution3(int[] arr, int targetSum) {
        Set<Integer> sums = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            int rem = targetSum - arr[i];
            if(sums.contains(rem)){
                return new int[] {rem, arr[i]};
            }
        }
        return new int[0];
    }
}
