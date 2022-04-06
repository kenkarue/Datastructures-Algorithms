package DSBinaryTrees;

import SharedClasses.Tree;
import java.util.*;

/**
 * Input:
 *   Tree
 * Output:
 *   Left side view of the tree
 */
public class LeftViewOfBinaryTree {

    static int maxLevel = 0;

    public static void main(String[] args){
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.left.right = new Tree(8);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(30);
        root.right.right.left = new Tree(25);
        root.right.right.right = new Tree(40);

        List<Integer> leftView =  new ArrayList<>();
        leftView = iterative(root);
        recursive(root, 1, leftView);
        print(leftView);
    }

    private static void recursive(Tree root, int level, List<Integer> leftView){
        if(root == null){
            return;
        }
        if(maxLevel < level){
            leftView.add(root.val);
            maxLevel = level;
        }
        recursive(root.left, level + 1, leftView);
        recursive(root.right, level + 1, leftView);
    }

    private static List<Integer> iterative(Tree root){
        List<Integer> leftView = new ArrayList<>();
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            leftView.add(q.peek().val);
            int size = q.size();
            while(size > 0){
                Tree current = q.remove();
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
                size--;
            }
        }
        return leftView;
    }

    private static void print(List<Integer> left){
        left.stream().forEach(leftValue ->{
           System.out.println(leftValue);
        });
    }
}
