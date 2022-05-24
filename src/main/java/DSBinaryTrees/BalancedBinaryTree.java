package DSBinaryTrees;

import SharedClasses.Tree;

/**
 * Difference in height of left and right subtree is either 0 and 1
 */
public class BalancedBinaryTree {

    static boolean isBalanced = true;

    public static void main(String[] args){
        Tree head = new Tree(20);
        head.left = new Tree(10);
        head.left.left = new Tree(5);
        head.left.right = new Tree(15);

        head.right = new Tree(30);
        head.right.left = new Tree(25);
        head.right.right = new Tree(35);
        head.right.left.left = new Tree(23);
        head.right.left.right = new Tree(28);

        solution(head, 0);
        System.out.print("Is Balanced: "+isBalanced);
    }

    private static int solution(Tree current, int depth) {
        if(current == null){
            return depth;
        }
        int left = solution(current.left, depth + 1);
        int right = solution(current.right,  depth + 1);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return Math.max(left, right);
    }
}
