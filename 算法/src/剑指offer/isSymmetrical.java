package ��ָoffer;

import Tree.TreeNode;

//��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ�
//ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
public class isSymmetrical {
    boolean test(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        recur(pRoot.left, pRoot.right);
        return true;
    }
    public boolean recur(TreeNode pRoot1,TreeNode pRoot2) {
    	if(pRoot1==null&&pRoot2==null) return true;
    	if(pRoot1==null||pRoot2==null) return false;
    	if(pRoot1.val!=pRoot2.val) return false;
    	recur(pRoot1.left, pRoot2.left);
    	recur(pRoot1.right, pRoot2.right);
    	return true;
    }
}
