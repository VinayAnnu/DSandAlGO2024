package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
        left=right=null;
    }
}
class Pair {
    TreeNode tnode;
    int state;
    Pair(TreeNode tnode, int state){
        this.tnode = tnode;
        this.state =state;
    }
}
public class PreInPostOrderSingleTraversal {
    private static List<List<Integer>> allTraversals(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair top = stack.peek();
            if(top.state == 1){ //case of preorder
                preorder.add(top.tnode.val);
                top.state +=1;
                if(top.tnode.left != null){
                    stack.push(new Pair(top.tnode.left, 1));
                }
            } else if(top.state ==2){//case of inorder
                inorder.add(top.tnode.val);
                top.state +=1;
                if(top.tnode.right != null){
                    stack.push(new Pair(top.tnode.right,1));
                }
            } else { //case of postorder
                postorder.add(top.tnode.val);
                stack.pop();
            }
        }

        result.add(preorder);
        result.add(inorder);
        result.add(postorder);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> res = allTraversals(root);
        System.out.println("preorder : "+ res.get(0));
        System.out.println("inorder : "+ res.get(1));
        System.out.println("postorder : "+ res.get(2));
    }
}
