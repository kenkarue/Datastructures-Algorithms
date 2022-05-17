package DSArrays;

import java.util.Arrays;

/**
 * Merge two sorted arrays
 * Input:
 *   Array: 1,3,5,6,8
 *   Array: 2,4,7,9
 * Output:
 *   Array: 1,2,3,4,5,6,7,8,9
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args){
        int[] arr = new int[]{1,3,5,6,8};
        int[] arr2 = new int[]{2,4,7,9};
        System.out.println(Arrays.toString(mergeArray(arr, arr2)));
    }

    /**
     * Time: 0(n + m)
     * Space: 0(n + m)
     */
    private static int[] mergeArray(int[] arr, int[] arr2) {
        int[] arr3 = new int[arr.length + arr2.length];
        int a1 = 0;
        int a2 = 0;
        int count = 0;
        while(a1 < arr.length && a2 < arr2.length){
            if(arr[a1] < arr2[a2]){
                arr3[count] = arr[a1];
                a1++;
            } else {
                arr3[count] = arr2[a2];
                a2++;
            }
            count++;
        }
        while(a1 < arr.length){
            arr3[count] = arr[a1];
            a1++;
            count++;
        }
        while(a2 < arr2.length){
            arr3[count] = arr2[a2];
            a2++;
            count++;
        }
        return arr3;
    }
}
