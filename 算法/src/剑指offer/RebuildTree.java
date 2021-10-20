package 剑指offer;

import 树.TreeNode;
import java.util.HashMap;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

public class RebuildTree {
	HashMap map=new HashMap<Integer, Integer>();
	int[] pre;
	int[] in;
private TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	this.pre=pre;
	for(int i=0;i<in.length;i++) {
		map.put(in[i], i);		
	}
	return recur(0,in.length,0);
        
    }
//通过递归获得二叉树
private TreeNode recur(int left,int right,int predex) {
//	递归终止条件，当遍历到最后的叶子节点，再继续遍历就会触发
	if(right<left) return null;
//	pre是前序遍历数组，predex不断加一并寻找其在二叉树中的位置
	TreeNode node=new TreeNode(pre[predex]);
//	map以中序遍历数值为键，序号为值，dex是拿到node节点数值对应在中序遍历的序号
	int dex=(int) map.get(node.val);
//	中序遍历node节点的左边的子列是其左子树，该子列左边界与原来一样，右边界是中序遍历的dex-1
//	根据前序遍历的特点（中左右），根节点右边的一个节点一定是左子树的最左叶子
	node.left=recur(left, dex-1, predex+1);
//	同样道理，右边的子列是其右子树，左边界为dex+1，右边界不变
//	将前序遍历分成根节点，左子树与右子树，根节点跨过左子树对应子列，之后第一个就是其右子节点
//	dex-left+1就是左子树对应子列的长度
	node.right=recur(dex+1,right,predex+(dex-left+1));
	return node;
}
}
