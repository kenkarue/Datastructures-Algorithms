package DSBinaryTrees;

import SharedClasses.Tree;

/**
 * Each node has Two or No children
 */
public class FullBinaryTree {

    public static void main(String[] args){
        Tree head = new Tree(20);
        head.left = new Tree(10);
        head.left.left = new Tree(5);
        head.left.right = new Tree(15);

        head.right = new Tree(30);
        head.right.left = new Tree(25);
        head.right.right = new Tree(35);
        head.right.left.left = new Tree(23);
        head.right.left.right = new Tree(40);

        boolean isFullBinary = solution(head);
        System.out.println("Is Full Binary :: "+isFullBinary);
    }

    private static boolean solution(Tree current){
        if(current == null){
            return true;
        }
        Tree left = current.left;
        Tree right = current.right;
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        boolean isLeft = solution(left);
        boolean isRight = solution(right);
        return isLeft && isRight;
    }
}
