package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToAllLeavesPath {
    List<List<Integer>> result = new ArrayList<>();
    boolean isLeaf(TreeNode node){
        return node!=null && node.left==null && node.right==null;
    }
    public void findAllPaths(TreeNode root, List<Integer> path){
        if(root==null)return;
        path.add(root.val);
        if(isLeaf(root)){
            result.add(new ArrayList<>(path));
        } else {
            findAllPaths(root.left,path);
            findAllPaths(root.right,path);
        }

        path.remove(path.size()-1);
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

        RootToAllLeavesPath sol = new RootToAllLeavesPath();
        List<Integer> path = new ArrayList<>();
        sol.findAllPaths(root,path);
        System.out.println("All Path from root to leaves : " + sol.result);
    }
}
