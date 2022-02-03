package DSBinaryTrees;

import SharedClasses.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Input:
 *   Balanced Tree:      30
 *                    /      \
 *                  20         40
 *                 /  \       /    \
 *                10   29   36     49
 *   Target = 39
 *
 *  Output:
 *    int: 40
 */
public class FindClosestValue {

    public static void main(String[] args){
        Tree root = new Tree(30);
        root.left = new Tree(20);
        root.left.left = new Tree(10);
        root.left.right = new Tree(29);
        root.right = new Tree(40);
        root.right.left = new Tree(36);
        root.right.right = new Tree(49);

        int target = 38;

        //int closest = depthSearch(root, target); // Time - 0(log n)  Space - 0(n)
        int closest = depthSearch1(root, target); // Time - 0(log n)  Space - 0(1)
        System.out.println("Closest :: "+closest);
    }

    /**
     * Time - 0(log n)
     * Space - 0(n)
     */
    private static int depthSearch(Tree root, int target) {
        int closest = Integer.MAX_VALUE;
        int closestVal = Integer.MIN_VALUE;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Tree current = q.remove();
            int val = current.val;
            if(Math.abs(target - val) < closest){
                closest = Math.abs(target - val);
                closestVal = val;
            }
            if(target < val && current.left != null){
               q.add(current.left);
            }
            if(target > val && current.right != null){
                q.add(current.right);
            }
        }
        return closestVal;
    }

    /**
     * Time - 0(log n)
     * Space - 0(1)
     */
    private static int depthSearch1(Tree current, int target) {
        int closest = Integer.MAX_VALUE;
        int closestVal = Integer.MIN_VALUE;
        while(current != null){
            int val = current.val;
            if(Math.abs(target - val) < closest){
                closest = Math.abs(target - val);
                closestVal = val;
            }
            if(target < val){
                current = current.left;
            }
            if(target > val){
                current = current.right;
            }
        }
        return closestVal;
    }
}
