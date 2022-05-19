package DSArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 *   Integer: 5
 * Output: List
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 */
public class PascalsTriangle {

    public static void main(String[] args){
        int n = 6;
        List<List<Integer>> triangle  = solution(n);
        System.out.println(triangle);
    }

    /**
     * Time: 0(n * 2)
     * Space: 0(n)
     */
    private static List<List<Integer>> solution(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        int count = 0;
        while(count < n){
            List<Integer> level = new ArrayList<>();
            level.add(1);
            if(count == 0){
                triangle.add(level);
                count++;
                continue;
            }
            List<Integer> preLevel = triangle.get(count - 1);
            for(int i = 1; i < preLevel.size(); i++){
                int prev = preLevel.get(i - 1);
                int current = preLevel.get(i);
                level.add(prev + current);
            }
            level.add(1);
            triangle.add(level);
            count++;
        }
        return triangle;
    }
}
