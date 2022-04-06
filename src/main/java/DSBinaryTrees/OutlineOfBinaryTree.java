package DSBinaryTrees;

import SharedClasses.Tree;

import java.util.*;

/**
 * Input:
 *    Tree: Balanced Tree
 * Output:
 *    List: Outline of the binary tree
 * Complexity:
 *    Time: 0(n)
 *    Space: 0(n)
 */
public class OutlineOfBinaryTree {

    static int maxLeftLevel = 0;
    static int maxRightLevel = 0;
//    static Set<Integer> checkDuplicates = new HashSet<>();

    public static void main(String[] args){
//        Tree root = new Tree(10);
//        root.left = new Tree(5);
//        root.left.right = new Tree(8);
//        root.right = new Tree(20);
//        root.right.left = new Tree(15);
//        root.right.right = new Tree(30);
//        root.right.right.left = new Tree(25);
//        root.right.right.right = new Tree(40);

        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.left.left = new Tree(3);
        root.left.right = new Tree(8);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(30);

        List<Integer> outline = new LinkedList<>();

        leftSideView(root, 1, outline);
        Collections.reverse(outline);
        rightSideView(root.right, 1, outline);

        print(outline);
    }

    private static void leftSideView(Tree root, int level, List<Integer> leftSide){
        if(root == null){
            return;
        }
        if(maxLeftLevel < level){
            leftSide.add(root.val);
            maxLeftLevel = level;
        }
        leftSideView(root.left, level + 1, leftSide);
        leftSideView(root.right, level + 1, leftSide);
    }

    private static void rightSideView(Tree root, int level, List<Integer> rightSide){
        if(root == null){
            return;
        }
        if(maxRightLevel < level){
            rightSide.add(root.val);
            maxRightLevel = level;
        }
        rightSideView(root.right, level + 1, rightSide);
        rightSideView(root.left, level + 1, rightSide);
    }

    private static void print(List<Integer> outline){
        outline.stream().forEach(out-> {
            System.out.println(out);
        });
    }
}
