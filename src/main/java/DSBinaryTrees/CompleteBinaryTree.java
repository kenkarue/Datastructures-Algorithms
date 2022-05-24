package DSBinaryTrees;

import SharedClasses.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leaf nodes lean towards the left and each node has two or one node but the leaf node must not have a right node
 */
public class CompleteBinaryTree {

    public static void main(String[] args){
        Tree head = new Tree(20);
        head.left = new Tree(10);
        head.left.left = new Tree(5);
        head.left.right = new Tree(15);
        head.left.left.left = new Tree(3);
        //head.left.left.right = new Tree(7);
        head.left.right.left = new Tree(13);

        head.right = new Tree(30);
        head.right.left = new Tree(25);
        head.right.right = new Tree(35);
        //head.right.left.left = new Tree(23);
        //head.right.left.right = new Tree(40);

        boolean isComplete = solution(head);
        System.out.println("Is Complete:: "+isComplete);
    }

    private static boolean solution(Tree current){
        if(current == null){
            return true;
        }
        Queue<Tree> q = new LinkedList<>();
        q.offer(current);
        boolean flag = false;
        while(!q.isEmpty()){
            Tree temp = q.remove();
            if(temp.left != null){
                if(flag){
                    return false;
                }
                q.offer(temp.left);
            } else {
                flag = true;
            }
            if(temp.right != null){
                if(flag){
                    return false;
                }
                q.offer(temp.right);
            } else {
                flag = true;
            }
        }
        return true;
    }
}
