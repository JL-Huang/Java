package ��ָoffer;

import Tree.TreeLinkNode;

public class GetNext {
    public TreeLinkNode test(TreeLinkNode pNode) {
    	return pNode.right==null?recur2(pNode.next):recur1(pNode.right);
    }
//    ����ݹ���������ڵ�
    public TreeLinkNode recur1(TreeLinkNode pNode) {
    	if(pNode==null||pNode.left==null) return pNode;
    	return recur1(pNode.left);
    }
//    ����ݹ�����Ϊ���ڵ����ӵĽڵ㣬�����丸�ڵ�
    public TreeLinkNode recur2(TreeLinkNode pNode) {
//    	һֱ�ҵ����ڵ㶼�������ӣ�˵����β�ڵ㣬����null
    	if(pNode==null||pNode.next==null) return null;
    	if(pNode==pNode.next.left) return pNode.next;
    	else return recur2(pNode.next);
    }
}
