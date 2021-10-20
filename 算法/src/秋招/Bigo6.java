package 秋招;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 树.TreeNode;

public class Bigo6 {
	private List<List<TreeNode>> test(TreeNode node) {
		List<List<TreeNode>> list=new ArrayList<List<TreeNode>>();
		HashMap<Integer, List<TreeNode>> map=new HashMap<Integer, List<TreeNode>>();
		Queue<Integer> queue1=new LinkedList<Integer>();
		Queue<TreeNode> queue2=new LinkedList<TreeNode>();
		queue1.offer(1);
		queue2.offer(node);
		while(!queue1.isEmpty()) {
			Integer temp_int=queue1.poll();
			TreeNode temp_node=queue2.poll();
			map.put(temp_int, new ArrayList<TreeNode>());
			map.get(temp_int).add(temp_node);
		}
		return null;
	}
}
