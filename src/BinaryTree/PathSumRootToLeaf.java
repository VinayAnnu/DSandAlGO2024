package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumRootToLeaf {
    List<Integer> pathSumList = new ArrayList<>();
    public boolean isLeaf(TreeNode node){
        return node!=null && (node.left==null && node.right==null);
    }
    public void findAllPathsSumRootToLeaves(TreeNode node, int sum){
        if(node==null) return;
        sum=sum+node.val;
        if(isLeaf(node)){
            pathSumList.add(sum);
        } else {
            findAllPathsSumRootToLeaves(node.left, sum);
            findAllPathsSumRootToLeaves(node.right,sum);
        }
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

        PathSumRootToLeaf sol = new PathSumRootToLeaf();
        List<Integer> path = new ArrayList<>();
        sol.findAllPathsSumRootToLeaves(root,0);
        System.out.println("All Path sum from root to leaves : " + sol.pathSumList);
    }
}
