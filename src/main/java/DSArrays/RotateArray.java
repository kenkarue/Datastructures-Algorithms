package DSArrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        System.out.println(Arrays.toString(solution(arr, k)));
    }

    /**
     * Time: 0(1)
     * Space: 0(n)
     */
    private static int[] solution(int[] arr, int k){
        int[] rotatedArr = new int[arr.length];
        k = k % arr.length;
        for(int i = arr.length - 1; i >= 0; i--){
            int index = (i - k);
            if(index < 0){
                index = arr.length + index;
            }
            rotatedArr[index] = arr[i];
        }
        return rotatedArr;
    }
}
