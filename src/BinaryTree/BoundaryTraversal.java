package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundaryTraversal {
    List<Integer> result = new ArrayList<>();

    boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    void addLeftBoundary(TreeNode node) {
        while(node!=null){
            if(!isLeaf(node)){
                result.add(node.val);
            }
            if(node.left!=null){
                node=node.left;
            }
            else{
                node=node.right;
            }
        }
    }

    void addLeaves(TreeNode node) {
        if(node==null){
            return;
        }
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left);
        addLeaves(node.right);
    }

    void addRightBoundary(TreeNode node) {
        Deque<Integer> deque = new ArrayDeque<>();
        while(node!=null){
            if(!isLeaf(node)) {
                deque.offerFirst(node.val); //add to deque using offerFirst()//kind of doing revese insertion in list
            }
            if(node.right!=null){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
        result.addAll(deque);
    }

    public List<Integer> boundaryTraversal(TreeNode root) {
        // your code goes here
        if (root == null) {
            return result;
        }
        if (isLeaf(root) == false) {
            result.add(root.val);
        }

        addLeftBoundary(root.left);
        addLeaves(root);
        addRightBoundary(root.right);
        return result;
    }
    // Driver code
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        BoundaryTraversal bt = new BoundaryTraversal();

        List<Integer> boundary = bt.boundaryTraversal(root);

        System.out.println("Boundary Traversal: " + boundary);
    }
}
