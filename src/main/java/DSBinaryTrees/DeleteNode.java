package DSBinaryTrees;

import SharedClasses.Tree;

/**
 * Delete Node in a binary Tree
 * Case:
 *  1. No child - Set parent to null
 *  2. 1 child - Set Parent to point child
 *  3. 2 children - Take the left node from the right most and replace
 */
public class DeleteNode {

    public static void main(String[] args){
        Tree head = new Tree(50);

        head.left = new Tree(25);
        head.left.left = new Tree(15);
        head.left.right = new Tree(35);

        head.right = new Tree(75);
        head.right.left = new Tree(65);
        head.right.right = new Tree(85);
        head.right.left.left = new Tree(60);
        head.right.left.right = new Tree(68);
        head.right.left.left.left = new Tree(55);

        printTree(head);
        Tree newHead = solution(head, 65);
        System.out.println("");
        printTree(newHead);
    }

    private static Tree solution(Tree head, int target){
        Tree current = head;
        Tree parent = null;
        while(current.val != target) {
            parent = current;
            if(current.val > target){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if(current == null){ // not found
            return head;
        }
        // Case 1: no child
        if(current.left == null && current.right == null){
            if(parent == null){
                head = null;
            } else if(parent.left == current){
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // case 2: 1 child
        else if(current.left != null && current.right == null){
            if(parent == null){
                head = current.left;
            } else if(parent.left == current){
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if(current.left == null && current.right != null){
            if(parent.left == current){
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // case 3: 2 children
        else{
            int temp = leftMostNode(current.right);
            solution(head, temp);
            if(current == head){
                head.val = temp;
            }
            current.val = temp;
        }
        return head;
    }

    private static int leftMostNode(Tree current){
        while(current.left != null){
            current = current.left;
        }
        return current.val;
    }

    private static void printTree(Tree current) {
        if(current == null){
            return;
        }
        printTree(current.left);
        System.out.print(current.val + " ");
        printTree(current.right);
    }
}
