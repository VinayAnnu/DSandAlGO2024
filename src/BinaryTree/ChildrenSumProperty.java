package BinaryTree;

public class ChildrenSumProperty {
    boolean isLeaf(TreeNode node){
        return node!=null && node.left==null&&node.right==null;
    }

    boolean checkChildrenSum(TreeNode node) {
        if(node==null || isLeaf(node)){
            return true;
        }
        int leftVal = (node.left != null) ? node.left.val : 0;
        int rightVal = (node.right != null) ? node.right.val : 0;

        return (node.val == leftVal + rightVal)
                && checkChildrenSum(node.left)
                && checkChildrenSum(node.right);
    }

    public static void main(String[] args) {
         /*
                10
               /  \
              8    2
             / \     \
            3   5     2
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);
        ChildrenSumProperty childrenSumProperty = new ChildrenSumProperty();

        System.out.println("Does tree satisfy children sum property? " + childrenSumProperty.checkChildrenSum(root));
    }
}
