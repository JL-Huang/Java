package ��ָoffer;

import Tree.TreeNode;

//����һ�ö��������жϸö������Ƿ���ƽ���������
//���������ֻ��Ҫ������ƽ���ԣ�����Ҫ�������ǲ������������
public class IsBalanced_Solution {
//	˼·�ܼ�,�ֱ��������������,�Ƚ�
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
