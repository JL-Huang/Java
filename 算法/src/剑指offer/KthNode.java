package 剑指offer;

import java.util.ArrayList;

import Tree.TreeNode;

//给定一棵二叉搜索树，请找出其中的第k小的结点。
//例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
public class KthNode {
//	搜索二叉树中序遍历，很简单
//	唯一要注意的是k的取值，k<=0与k>list.size()都应该返回null
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
