package DSBinaryTrees;

import SharedClasses.Tree;

/**
 * Each Node has two children and leaf is at same level
 */
public class PerfectBinaryTree {

    static int maxDepth = 0;

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
        // head.right.right.right = new Tree(40);
        boolean isPerfectBinary = solution(head, 0);
        System.out.println("Is Perfect Binary:: "+isPerfectBinary);
    }

    private static boolean solution(Tree current, int depth){
        if(current == null){
            if(maxDepth == 0){
                maxDepth = depth;
                return true;
            }
            return maxDepth == depth;
        }
        Tree left = current.left;
        Tree right = current.right;
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        boolean isLeft = solution(left, depth + 1);
        boolean isRight = solution(right, depth + 1);
        return isLeft && isRight;
    }
}
