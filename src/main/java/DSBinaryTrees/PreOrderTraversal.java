package DSBinaryTrees;

import SharedClasses.Tree;
import java.util.Stack;

/**
 *  Post-order:: LEFT RIGHT ROOT
 *  Input::
 *      Tree:          20
 *                   /     \
 *                 10       30
 *
 *  OutPut::
 *      List:: 20, 10, 30
 */
public class PreOrderTraversal {

    public static void main(String[] args){
        Tree root = new Tree(20);
        root.left = new Tree(10);
        //root.left.left = new Tree(5);
        root.left.right = new Tree(15);
        root.right = new Tree(30);

        recursive(root);
        iterative(root);
    }

    private static void recursive(Tree root) {
        if(root == null){
            return;
        }
        System.out.print(" "+root.val);
        recursive(root.left);
        recursive(root.right);
    }

    private static void iterative(Tree current) {
        Stack<Tree> s = new Stack<>();
        while(current != null || !s.isEmpty()){
            if(current != null){
                System.out.print(" "+current.val);
                s.push(current);
                current = current.left;
                continue;
            }
            Tree temp = s.pop();
            if(temp.right != null){
                current = temp.right;
            }
        }

    }
}
