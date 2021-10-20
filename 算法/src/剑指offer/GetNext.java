package 剑指offer;

import 树.TreeLinkNode;

public class GetNext {
    public TreeLinkNode test(TreeLinkNode pNode) {
    	return pNode.right==null?recur2(pNode.next):recur1(pNode.right);
    }
//    这个递归是找最左节点
    public TreeLinkNode recur1(TreeLinkNode pNode) {
    	if(pNode==null||pNode.left==null) return pNode;
    	return recur1(pNode.left);
    }
//    这个递归是找为父节点左孩子的节点，返回其父节点
    public TreeLinkNode recur2(TreeLinkNode pNode) {
//    	一直找到根节点都不是左孩子，说明是尾节点，返回null
    	if(pNode==null||pNode.next==null) return null;
    	if(pNode==pNode.next.left) return pNode.next;
    	else return recur2(pNode.next);
    }
}
