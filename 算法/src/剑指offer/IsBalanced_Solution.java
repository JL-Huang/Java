package 剑指offer;

import 树.TreeNode;

//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
public class IsBalanced_Solution {
//	思路很简单,分别求左右子树深度,比较
    public boolean test(TreeNode root) {
    	int left=0,right=0;
    	if(root==null) return true;
    	if(root.left!=null) left=depth(root.left);
    	if(root.right!=null) right=depth(root.right);
    	return !(left-right>1||right-left>1);
    }
    public int depth(TreeNode root) {
    	if(root==null) return 0;
    	int left=depth(root.left);
    	int right=depth(root.right);
        return left>right?left+1:right+1;
    }
}
