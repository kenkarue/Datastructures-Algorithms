package DSArrays;

import java.util.Arrays;

/**
 * Input:
 *   - List of Array
 *   - Point to reverse
 *
 * Output:
 *   - List of reversed Array after point N
 */
public class ReverseArrayAtN {

    public static void main(String[] args){
        int[] arr = {0,1, 2, 3, 0, 5, 6, 8, 0, 2, 4, 0, 0};
        int[] reversedArr = reverseArray(arr, 0);
        System.out.println(Arrays.toString(reversedArr));
    }

    private static int[] reverseArray(int[] arr, int target) {
        int start = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target)  {
                swap(arr, start, i-1);
                start = i + 1;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
