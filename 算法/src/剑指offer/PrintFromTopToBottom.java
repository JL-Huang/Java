package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import 树.TreeNode;

//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class PrintFromTopToBottom {
	public static void main(String[] args) {
		Integer[] a={10,6,14,4,8,12,16};
		TreeNode root=TreeNode.getTreeNode(a);
		System.out.println(new PrintFromTopToBottom().test(root).toString());
	}
//	最最典型的广度优先BFS，用队列实现
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<Integer> test(TreeNode root) {
    	if(root==null) return list;
//    	首先把根节点存进队列
    	queue.offer(root);
    	while(!queue.isEmpty()) {
//    		取出队列头，存起来，并保存其数值
    		TreeNode temp=queue.poll();
    		list.add(temp.val);
//    		把左孩子加入队列
    		if(temp.left!=null) {
    			queue.offer(temp.left);
    		}
//    		把右孩子加入队列
    		if(temp.right!=null) {
    			queue.offer(temp.right);
    		}
    	}
        return list;
    }
}
