package DSArrays;

import java.util.Arrays;

/**
 * Input:
 *  Array : of atleast size 3
 * Output
 *  Array : sorted 3 largest numbers
 */
public class FindThreeLargestNumbers {

    public static void main(String[] args){
        int[] array1 = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] array = new int[]{10, 5, 9, 10, 12};
        System.out.print(Arrays.toString(solution1(array)));
        System.out.print(Arrays.toString(solution1(array)));
    }

    /**
     * Time: 0(n * m)
     * Space: 0(1)
     */
    private static int[] solution1(int[] array){
        int[] arr = new int[3];
        for(int j = 0; j < arr.length; j++){
            arr[j] = Integer.MIN_VALUE;
        }
        for (int j : array) {
            int n = 0;
            while (n < arr.length && arr[n] < j) {
                n++;
            }
            n--;
            // swap
            if (n >= 0) {
                int temp = arr[n];
                arr[n] = j;
                n--;
                for (int z = n; z >= 0; z--) {
                    int newTemp = arr[z];
                    arr[z] = temp;
                    temp = newTemp;
                }
            }
        }
        return arr;
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static int[] solution2(int[] array){
        int[] arr = new int[3];
        for(int j = 0; j < arr.length; j++){
            arr[j] = Integer.MIN_VALUE;
        }
        for (int j : array) {
            if (j > arr[2]) {
                shiftValues(arr, j, 2);
            } else if (j > arr[1]) {
                shiftValues(arr, j, 1);
            } else if (j > arr[0]) {
                shiftValues(arr, j, 0);
            }
        }
        return arr;
    }

    private static void shiftValues(int[] arr, int j, int position){
        for(int i = 0; i <= position; i++){
            if(i == position){
                arr[i] = j;
            } else {
                arr[i] = arr[i + 1];
            }
        }
    }
}
