package DSBinaryTrees;

import SharedClasses.Tree;
import java.util.Stack;

/**
 *  BST Inorder:: LEFT ROOT RIGHT
 *   Input::
 *      Tree:          20
 *                   /     \
 *                 10       30
 *
 *   OutPut::
 *      List:: 10, 20, 30
 */
public class InorderTraversal {

    public static void main(String[] args){
//        Tree root = new Tree(20);
//        root.left = new Tree(10);
//        root.left.right = new Tree(15);
//        root.right = new Tree(30);

        Tree root = new Tree(10);
        root.right = new Tree(20);
        root.right.right = new Tree(30);
        root.right.right.left = new Tree(25);
        root.right.right.right = new Tree(40);

        recursive(root);
        iterative(root);
    }

    private static void recursive(Tree root) {
        if(root == null){
            return;
        }
        recursive(root.left);
        System.out.print(" "+root.val);
        recursive(root.right);
    }

    private static void iterative(Tree current){
        Stack<Tree> s = new Stack<>();
        while(!s.isEmpty() || current != null){
            if(current != null){
                s.push(current);
                current = current.left;
                continue;
            }
            Tree temp = s.pop();
            System.out.print(" "+temp.val);
            if(temp.right != null){
                current = temp.right;
            }
        }
    }
}
