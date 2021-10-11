package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class p1 {
public static void main(String[] args) {
	Integer[] a= {1,2,3,4,5,8};
	TreeNode h=TreeNode.getTreeNode(a);
	getTree(h);
	String str="322222223";
	System.out.println(str.split("5").length);
	LinkedList<Integer>list=new LinkedList<Integer>();
	list.offer(3);
	list.offer(2);
//	Collections.sort(list);
	System.out.println(list.peek());
}
private static void getTree(TreeNode root) {
	System.out.println(root.right.left.val);
}
}
