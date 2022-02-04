package DSBinaryTrees;

import SharedClasses.Tree;
import java.util.Stack;

/**
 * Input:
 *   BST                 30
 *                    /      \
 *                   20         40
 *                 /  \       /    \
 *                10   29   36     49
 *
 *  Output::
 *   boolean: true
 *
 */
public class ValidateBST {

    public static void main(String[] args){
        // Test 1
//        Tree root = new Tree(30);
//        root.left = new Tree(20);
//        root.left.left = new Tree(10);
//        root.left.right = new Tree(29);
//        root.right = new Tree(40);
//        root.right.left = new Tree(36);
//        root.right.right = new Tree(49);

        // Test 2
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.left.right = new Tree(10);
        root.right = new Tree(15);


        boolean isValid = iterative(root);
        System.out.print("Is valid BST :: "+isValid);
    }

    /**
     * Inorder traversal starting from least to greater
     */
    private static boolean iterative(Tree node){
        int least = Integer.MIN_VALUE;
        Stack<Tree> s = new Stack<>();
        while(!s.isEmpty() || node != null){
            if(node != null){
                s.push(node);
                node = node.left;
                continue;
            }
            Tree temp = s.pop();
            if(temp.val < least){
                return false;
            }
            least = temp.val;
            if(temp.right != null){
                node = temp.right;
            }
        }
        return true;
    }
}
