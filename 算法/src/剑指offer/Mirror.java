package ��ָoffer;

import Tree.TreeNode;

//���������Ķ�����������任ΪԴ�������ľ���
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
