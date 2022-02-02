package DSBinaryTrees;

import SharedClasses.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Input:
 *   Unbalanced Tree:    30
 *                      /
 *                     20
 *                    /
 *                   10
 *  Output:
 *    Balanced Tree:   20
 *                   /    \
 *                 10      30
 */
public class BalanceATree {

    public static void main(String[] args){
        Tree root = new Tree(30);
        root.left = new Tree(20);
        root.left.left = new Tree(10);

        Tree balancedRoot = balanceTree(root);
        System.out.println("");
    }

    private static Tree balanceTree(Tree root) {
        // Put Nodes in a list - sorted
        List<Tree> sortedNodes = new ArrayList<>();
        inorderTranversal(root, sortedNodes);
        // balance the tree
        return buildBalanceTree(sortedNodes, 0, sortedNodes.size() - 1);
    }

    private static void inorderTranversal(Tree root, List<Tree> sortedNodes) {
        if(root == null){
            return;
        }
        inorderTranversal(root.left, sortedNodes);
        sortedNodes.add(root);
        inorderTranversal(root.right, sortedNodes);
    }

    private static Tree buildBalanceTree(List<Tree> sortedNodes, int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        Tree root = sortedNodes.get(mid);
        root.left = buildBalanceTree(sortedNodes, l, mid -1);
        root.right = buildBalanceTree(sortedNodes, mid + 1, r);
        return root;
    }
}

