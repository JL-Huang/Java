package Classics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Tree.TreeNode;

//�������Ĳ������BFS
//BFS�Ĺؼ�ʵ���Ƕ��У� ��ô���Ԫ�س����У�ÿ�γ����ж��������Һ��Ӽ������
//���һ��ʱ��ȫ��һ�㶼�����У���û����Ԫ�ؼ��룬���б�գ���Ϊѭ����������
public class BFS {
	public static void main(String[] args) {
		Integer[] nums={1,2,3,4,5,6,7,8,9,10};
		TreeNode node=TreeNode.getTreeNode(nums);
		System.out.println(Print(node).toString());
	}
	 static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		 ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();
		 if(pRoot!=null) queue.offer(pRoot);
		 while(!queue.isEmpty()){
//			 �������Ҫ��n��ֵ
			 int n=queue.size();
			 ArrayList<Integer> inside_list=new ArrayList<Integer>();
			 for(int i=0;i<n;i++) {
				 TreeNode node=queue.poll();
//				 ע�����list�ڵ������е�ʱ�򣬲��Ǽ�����е�ʱ��
				 inside_list.add(node.val);
				 if(node.left!=null) queue.add(node.left);
				 if(node.right!=null) queue.add(node.right);
			 }
			 list.add(inside_list);
		 }
		 return list;
	 }
}
