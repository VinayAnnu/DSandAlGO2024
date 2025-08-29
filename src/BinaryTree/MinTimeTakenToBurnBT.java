package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinTimeTakenToBurnBT {
    Map<TreeNode, TreeNode> childVsParent = new HashMap<>();

    public void buildParentMap(TreeNode root, TreeNode parent){
        if(root == null) return;
        childVsParent.put(root,parent);
        buildParentMap(root.left,root);
        buildParentMap(root.right,root);
    }

    public int minTimeToBurn(TreeNode root, TreeNode target){
        buildParentMap(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int time = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int i=0;i<size;i++){
                TreeNode tnode = queue.poll();
                //move upward
                TreeNode parent = childVsParent.get(tnode);
                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.offer(parent);
                }
                //move left
                if(tnode.left!=null && !visited.contains(tnode.left)){
                    queue.offer(tnode.left);
                    visited.add(tnode.left);
                }
                //move right
                if(tnode.right!=null && !visited.contains(tnode.right)){
                    queue.offer(tnode.right);
                    visited.add(tnode.right);
                }
            }
        }
        return time;
    }
    public static void main(String[] args) {
        /*
                  1
                /  \
               2    3
              /    / \
             4    5   6
              \
               7   */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        MinTimeTakenToBurnBT sol = new MinTimeTakenToBurnBT();
        int ans = sol.minTimeToBurn(root, root.left); // target = node 2
        System.out.println("Minimum time to burn tree = " + ans);
    }
}
