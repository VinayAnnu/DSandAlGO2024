package BinarySearchTree;

import java.util.Arrays;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        left=right=null;
    }
}
public class FloorAndCeilOfBST {
    //Floor = greatest value ≤ key
    int floorOfBst(TreeNode root, int key){
        int floor=-1;
        while(root!=null){
            if(root.val<key){
                floor = root.val;
                root=root.right;
            } else if(root.val==key){
                return key;
            } else {
                root=root.left;
            }
        }
        return floor;
    }

    //Ceil = smallest value ≥ key.
    int ceilOfBst(TreeNode root, int key){
        int ceil=-1;
        while(root!=null){
            if(root.val<key){
                root=root.right;
            } else if(root.val==key){
                return key;
            } else {
                ceil = root.val;
                root=root.left;
            }
        }
        return ceil;
    }

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here

        int floor = floorOfBst(root,key);
        int ceil = ceilOfBst(root,key);
        return Arrays.asList(floor,ceil);
    }
    public static void main(String[] args) {
         /*
                 8
               /   \
              4     12
             / \   /  \
            2   6 10  14
        */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        FloorAndCeilOfBST sol = new FloorAndCeilOfBST();

        int[] testKeys = {5, 11, 15, 6};

        for (int key : testKeys) {
            List<Integer> ans = sol.floorCeilOfBST(root, key);
            System.out.println("Key = " + key + " → Floor = " + ans.get(0) + ", Ceil = " + ans.get(1));
        }
    }
}
