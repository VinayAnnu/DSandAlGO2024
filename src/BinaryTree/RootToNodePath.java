package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public boolean findPath(TreeNode root, int target, List<Integer> path) {
        if(root==null) return false;
        path.add(root.val);
        if(root.val==target){
            return true;
        }

        if(findPath(root.left, target, path)||findPath(root.right, target, path)){
            return true;
        }
        // If not found, remove current node (backtrack)
        path.remove(path.size() - 1);
        return false;
    }
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        RootToNodePath sol = new RootToNodePath();
        List<Integer> path = new ArrayList<>();

        int target = 5;
        if (sol.findPath(root, target, path)) {
            System.out.println("Path to " + target + " : " + path);
        } else {
            System.out.println("Target not found!");
        }
    }
}
