package DSBinaryTrees;

import SharedClasses.Tree;

import java.util.*;

public class ZigzagTree {

    public static void main(String[] args) {
//        Tree root = new Tree(3);
//        root.left = new Tree(9);
//        root.right = new Tree(20);
//        root.right.left = new Tree(15);
//        root.right.right = new Tree(7);
//        System.out.println(zigzagLevelOrder(root));

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(7);
        root.left.right = new Tree(6);
        root.right = new Tree(3);
        root.right.left = new Tree(5);
        root.right.right = new Tree(4);
        System.out.println(zigzagByStack(root));
        System.out.println(zigzagByQueue(root));
    }

    public static List<List<Integer>> zigzagByStack(Tree root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> zigzag = new ArrayList<>();
        List<Integer> internal = new ArrayList<>();
        Stack<Tree> s1 = new Stack<>();
        Stack<Tree> s2 = new Stack<>();
        s1.add(root);
        boolean right = true;
        while (!s1.isEmpty()) {
            Tree current = s1.pop();
            if (right) {
                if (null != current.left) {
                    s2.add(current.left);
                }
                if (null != current.right) {
                    s2.add(current.right);
                }
            } else {
                if (null != current.right) {
                    s2.add(current.right);
                }
                if (null != current.left) {
                    s2.add(current.left);
                }
            }
            internal.add(current.val);
            if(s1.isEmpty()){
                right = !right;
                zigzag.add(internal);
                s1 = s2;
                s2 = new Stack<>();
                internal = new ArrayList<>();
            }
        }
        return zigzag;
    }

    public static List<List<Integer>> zigzagByQueue(Tree root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> zigzag = new ArrayList<>();
        List<Integer> internal = new ArrayList<>();


        return zigzag;
    }
}
