package DSBinaryTrees;

import SharedClasses.Tree;

import java.util.Stack;

/**
 *  Post-order:: LEFT RIGHT ROOT
 *   Input::
 *      Tree:          20
 *                   /     \
 *                 10       30
 *              8     15  25   35
 *   OutPut::
 *      List:: 10, 30, 20
 */
public class PostOrderTraversal {

    public static void main(String[] args){
        Tree root = new Tree(20);
        root.left = new Tree(10);
        root.left.left = new Tree(8);
        root.left.right = new Tree(15);
        root.right = new Tree(30);
        root.right.left = new Tree(25);
        root.right.right = new Tree(35);

        recursive(root);
        System.out.println(" - ");
        iterative(root);
    }

    private static void recursive(Tree root) {
        if(root == null){
            return;
        }
        recursive(root.left);
        recursive(root.right);
        System.out.print(" "+root.val);
    }

    private static void iterative(Tree root) {
        // s1 - 8, 15
        // s2 - 20, 30, 35, 25, 10, 15, 8
        Stack<Tree> s = new Stack<>();
        Stack<Tree> s1 = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Tree current = s.pop();
            if(current.left != null){
                s.push(current.left);
            }
            if(current.right != null){
                s.push(current.right);
            }
            s1.push(current);
        }
        while(!s1.isEmpty()){
            System.out.print(" "+s1.pop().val);
        }
    }
}
