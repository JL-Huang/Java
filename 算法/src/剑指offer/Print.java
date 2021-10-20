package 剑指offer;

import java.util.ArrayList;

import 树.TreeNode;

public class Print {
    ArrayList<ArrayList<Integer> > test(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        depth(pRoot, 1, list);
        return list;
    }
//    这个做法非常巧妙，主要思路是用depth记录每一层的层数，层数从0开始，depth从1开始
//    当depth>size,在list的depth位置增一个新的泛型List，确保size=depth-1
//    然后，在添加泛型List的时候，在depth-1这里，把当前root加进去
//    然后左右递归，要注意的是，这里其实是深度优先遍历
//    但是它确保了每一层都只在其对应的泛型List里操作
    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
    	if(root==null) return;
    	if(depth>list.size()) list.add(new ArrayList<Integer>());
    	list.get(depth-1).add(root.val);
    	depth(root.left, depth+1, list);
    	depth(root.right, depth+1, list);   	
    }
}
