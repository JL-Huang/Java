package 常考;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import 树.TreeNode;

//二叉树的层序遍历BFS
//BFS的关键实现是队列， 那么多个元素出队列，每次出队列都把其左右孩子加入队列
//最后一次时，全部一层都出队列，又没有新元素加入，队列变空，作为循环结束条件
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
//			 这里必须要用n赋值
			 int n=queue.size();
			 ArrayList<Integer> inside_list=new ArrayList<Integer>();
			 for(int i=0;i<n;i++) {
				 TreeNode node=queue.poll();
//				 注意加入list在弹出队列的时候，不是加入队列的时候
				 inside_list.add(node.val);
				 if(node.left!=null) queue.add(node.left);
				 if(node.right!=null) queue.add(node.right);
			 }
			 list.add(inside_list);
		 }
		 return list;
	 }
}
