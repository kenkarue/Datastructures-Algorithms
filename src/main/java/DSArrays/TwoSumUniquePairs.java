package DSArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input::
 *   1. List of numbers
 *   2. Target to find
 *
 * Output::
 *   int of number of times
 *
 */
public class TwoSumUniquePairs {

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(2);
        nums.add(45);
        nums.add(46);
        nums.add(46);
        int target = 47;
        System.out.println(twoSumUniquePairs(nums, target));
    }

    /**
     * Time - 0(n)
     * Space - 0(n)
     */
    public static int twoSumUniquePairs(List<Integer> nums, int target) {
        Set<Integer> pairs = new HashSet<>();
        Set<Integer> uniqueValue = new HashSet<>();
        int uniquePairs = 0;
        for(int num: nums){
            if(uniqueValue.contains(target - num) && !pairs.contains(num)){
                pairs.add(target - num);
                pairs.add(num);
                uniquePairs++;
            }
            uniqueValue.add(num);
        }
        return uniquePairs;
    }
}
