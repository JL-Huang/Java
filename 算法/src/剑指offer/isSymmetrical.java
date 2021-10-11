package 剑指offer;

import Tree.TreeNode;

//请实现一个函数，用来判断一棵二叉树是不是对称的。
//注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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
