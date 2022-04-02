package DSBinaryTrees;

import SharedClasses.Tree;

/**
 * Create Balanced Tree
 * Input:
 *   Array: [1,2,3]
 * Output:
 *   Binary Tree
 *        2
 *      /   \
 *     1     3
 */
public class CreateBalancedTree {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        createBinaryTree(arr);
    }

    private static void createBinaryTree(int[] arr) {
        Tree root = createBinaryTree(arr, 0, arr.length - 1);
        System.out.println("We are here");
    }

    private static Tree createBinaryTree(int[] arr, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Tree root = new Tree(arr[mid]);
        root.left = createBinaryTree(arr, start, mid - 1);
        root.right = createBinaryTree(arr, mid + 1, end);

        return root;
    }
}
