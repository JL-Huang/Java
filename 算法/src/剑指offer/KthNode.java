package ��ָoffer;

import java.util.ArrayList;

import Tree.TreeNode;

//����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
//���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
public class KthNode {
//	��������������������ܼ�
//	ΨһҪע�����k��ȡֵ��k<=0��k>list.size()��Ӧ�÷���null
	ArrayList<TreeNode>list=new ArrayList<TreeNode>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
    	if(k<=0) return null;
    	recur(pRoot);
    	if(list.size()<k) return null;
    	return list.get(k-1);
    }
    TreeNode recur(TreeNode pRoot)
    {
    if(pRoot==null) return pRoot;
    recur(pRoot.left);
    list.add(pRoot);
    recur(pRoot.right);
    return null;
    }
}
