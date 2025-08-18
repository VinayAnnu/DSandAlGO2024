package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

public class BottomViewBinaryTree {
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> colVsNodeValue = new TreeMap<>();
        Deque<Object[]> queue = new ArrayDeque<>();//store Node Vs column
        queue.offer(new Object[]{root,0});//without using Helper Class
        while(!queue.isEmpty()){
            Object[] obj = queue.poll();
            TreeNode tnode = (TreeNode) obj[0];
            int col = (int) obj[1];
            colVsNodeValue.put(col,tnode.val);//replace with latest value, this is the requirement of question.
            if(tnode.left!=null){
                queue.offer(new Object[]{tnode.left,col-1});
            }
            if(tnode.right!=null){
                queue.offer(new Object[]{tnode.right,col+1});
            }
        }

        colVsNodeValue.forEach((k,v)->{
            result.add(v);
        });
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        BottomViewBinaryTree bottomViewBinaryTree = new BottomViewBinaryTree();
        List<Integer> bottomView = bottomViewBinaryTree.bottomView(root);
        System.out.println("Bottom View of Tree: " + bottomView);   //[5, 10, 3, 14, 25]
    }
}
