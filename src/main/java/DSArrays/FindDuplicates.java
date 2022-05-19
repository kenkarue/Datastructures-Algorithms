package DSArrays;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicates {

    public static void main(String[] args){
        int[] arr = new int[]{0, 4, 3, 2, 7, 8, 2, 3, 1};
        duplicates1(arr);
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static void duplicates(int[] arr) {
        Map<Integer, Integer> dups = new HashMap<>();
        for(int i = 0; i < arr.length; i++ ){
            dups.put(arr[i], dups.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Integer,Integer> m: dups.entrySet()){
            if(m.getValue() > 1){
                System.out.print(m.getKey()+ " ");
            }
        }
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static void duplicates1(int[] arr) {
        for(int i = 0; i < arr.length; i++ ){
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                System.out.print(i + " ");
            }
        }
    }
}
