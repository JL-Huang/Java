package 剑指offer;

import 树.TreeNode;

//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class TreeDepth {
	public static void main(String[] args) {
		Integer[] nums= {1,2,3,4,5,0,0,6,7};
		TreeNode root=TreeNode.getTreeNode(nums);
		TreeDepth treeDepth=new TreeDepth();
//		treeDepth.test(root);
		System.out.println(treeDepth.test(root));
//		System.out.println(treeDepth.right);
//		System.out.println(treeDepth.left);
	}
//	所见即所得，很简单的二叉树递归
//	注意，这里之所以初值为1，是写到后面才修改的
//	当遍历到空返回0，当遍历到左子树不为空，此时已经有两层，所以++前应该为1
//	发现这个算法有问题，能算出深度，但是left与right意义很奇怪，left是左孩子深度，right左孩子最下面那个右孩子的深度,
//	int left=1,right=1;
//    public void test(TreeNode root) {
//        if(root==null) return ;
//        if(root.left!=null) {
//        	left++;
//        	test(root.left);
//        }
//        if(root.right!=null) {
//        	right++;
//        	test(root.right);
//        }
//        return;
//    }
	
//	这才是正确答案,注意left与right只是中间记录的,如果把他们作为全局变量输出,是得不到正确结果的
	public int test(TreeNode root) {
		if(root==null) return 0;
		int left=test(root.left);
		int right=test(root.right);
		return left>right?left+1:right+1;
	}
	

}
