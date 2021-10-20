package 秋招;

import java.util.ArrayList;
import java.util.LinkedList;

import 树.TreeNode;

public class T58_2 {
	public static void main(String[] args) {
		Integer[] nums={1,2,3,4,5,6,7,8,9,10};
		TreeNode node=TreeNode.getTreeNode(nums);
		System.out.println(printNode(node).toString());
	}
    public static ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
    	 if(node!=null) queue.offer(node);
    	while(!queue.isEmpty()) {
    		int n=queue.size();
    		ArrayList<Integer> list=new ArrayList<Integer>();
    		for(int i=0;i<n;i++) {
    			TreeNode temp=queue.poll();
    			list.add(temp.val);
    			if(temp.left!=null) queue.add(temp.left);
    			if(temp.right!=null) queue.add(temp.right);
    		}
    		result.add(list);
    	}
    	return result;
    }
}
