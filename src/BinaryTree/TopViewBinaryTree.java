package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

class HelperPair {//to store node and their index
    TreeNode node;
    int col;

    HelperPair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class TopViewBinaryTree {

    public List<Integer> topView(TreeNode root) {
        //apply BFS-
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, Integer> colVsNodeValue = new TreeMap<>();
        Deque<HelperPair> queue = new ArrayDeque<>();
        queue.offer(new HelperPair(root, 0));
        while (!queue.isEmpty()) {
            HelperPair temp = queue.poll();
            colVsNodeValue.putIfAbsent(temp.col, temp.node.val);
            if (temp.node.left != null) {
                queue.offer(new HelperPair(temp.node.left, temp.col - 1));
            }
            if (temp.node.right != null) {
                queue.offer(new HelperPair(temp.node.right, temp.col + 1));
            }
        }

        for (Integer x : colVsNodeValue.values()) {
            result.add(x);
        }
        return result;
    }

    /*
                 1
                / \
               2   3
                \
                 4
                  \
                   5
        */
    //output: [2,1,3]
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        TopViewBinaryTree topViewBinaryTree = new TopViewBinaryTree();
        List<Integer> topView = topViewBinaryTree.topView(root);
        System.out.println("Top View of Tree: " + topView);
    }

}
