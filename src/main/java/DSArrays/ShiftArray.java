package DSArrays;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Arrays;

public class ShiftArray {

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int[] shifted = shiftArray(arr, k);
        System.out.println(Arrays.toString(shifted));
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static int[] shiftArray1(int[] arr, int k){
        int[] arr2 = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(i+k > arr.length - 1){
                arr2[(i + k) % arr.length] = arr[i];
            } else {
                arr2[i + k] = arr[i];
            }
        }
        return arr2;
    }

    /**
     * Time: 0(n * k)
     * Space: 0(1)
     */
    private static int[] shiftArray(int[] arr, int k) {
        if(k > arr.length){
            k = k % arr.length;
        }
        while(k > 0){
            int temp = arr[0];
            for(int i = 1; i < arr.length; i++){
                int current = arr[i];
                arr[i] = temp;
                temp = current;
            }
            arr[0] = temp;
            k--;
        }
        return arr;
    }
}
