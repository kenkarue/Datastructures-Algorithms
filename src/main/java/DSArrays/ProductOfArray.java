package DSArrays;

import java.util.Arrays;

/**
 * Input:
 *   Array: 1,2,3,4
 * Output:
 *   Array: 24, 12, 8, 6
 */
public class ProductOfArray {

    public static void main(String[] args){
        int[] nums = new int[]{'1','2','3','4'};
        bruteForce(nums);
    }

    /**
     * Time: 0(n*2)
     * Space: 0(1)
     */
    private static int[] bruteForce(int[] nums){
        int[] num = new int[nums.length];
        Arrays.fill(num, 1);

        for(int i = 0; i < nums.length; i++){
            int total = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    total = total * nums[j];
                }
            }
            num[i] = total;
        }
        return num;
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static int[] optimal(int[] nums){
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        // product for left side
        for(int l = 1; l < nums.length; l++){
            output[l] = nums[l - 1]  *  output[l - 1];
        }

        // product for right side
        int rProduct = nums[nums.length - 1];
        for(int r = nums.length - 2; r >= 0; r--){
            output[r] = rProduct * output[r];
            rProduct *= nums[r];
        }
        return output;
    }
}
