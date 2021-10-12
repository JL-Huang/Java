package ��ָoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Tree.TreeNode;

//�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
public class PrintFromTopToBottom {
	public static void main(String[] args) {
		Integer[] a={10,6,14,4,8,12,16};
		TreeNode root=TreeNode.getTreeNode(a);
		System.out.println(new PrintFromTopToBottom().test(root).toString());
	}
//	������͵Ĺ������BFS���ö���ʵ��
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<Integer> test(TreeNode root) {
    	if(root==null) return list;
//    	���ȰѸ��ڵ�������
    	queue.offer(root);
    	while(!queue.isEmpty()) {
//    		ȡ������ͷ��������������������ֵ
    		TreeNode temp=queue.poll();
    		list.add(temp.val);
//    		�����Ӽ������
    		if(temp.left!=null) {
    			queue.offer(temp.left);
    		}
//    		���Һ��Ӽ������
    		if(temp.right!=null) {
    			queue.offer(temp.right);
    		}
    	}
        return list;
    }
}
