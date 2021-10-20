package 剑指offer;

import 树.TreeNode;

//操作给定的二叉树，将其变换为源二叉树的镜像。
public class Mirror {
    public void test(TreeNode root) {
    	if(root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        test(root.left);
        test(root.right);
    }
}
