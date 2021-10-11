package 剑指offer;

import Tree.TreeNode;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class HasSubtree {
public static void main(String[] args) {
	Integer[] a={5,8,5,9,2,5,5};
	Integer[] b={8,9,2};
	TreeNode root1=TreeNode.getTreeNode(a);
	TreeNode root2=TreeNode.getTreeNode(b);
	System.out.println(new HasSubtree().test(root1,root2));
}
//	写一个方法，判断二叉树2是不是二叉树1相同根节点的子树
public boolean check_if_equal(TreeNode node1,TreeNode node2){
//	这里判断的话要注意，要判断是否相等条件比较苛刻，但是不相等的条件是很容易想到的
//	一是二叉树2比二叉树1节点要多，二是两者有值不相等，只有当遍历到最后都没出现以上情况，才返回true
//	这里顺序不能反转，一定是二叉树2先为空则返回true，因为这意味着前面都没返回false
    if(node2==null) return true;
//    执行到这里，意味着二叉树2一定不为空
	if(node1==null) return false;
//	注意一定要注意递归终止条件！当二叉树2已经是叶子节点还没出现返回false，就可以返回true了
	if(node1.val!=node2.val) return false;
	return check_if_equal(node1.left, node2.left)&&check_if_equal(node1.right, node2.right);
}
public boolean test(TreeNode root1,TreeNode root2) {
//	调用check_if_equal()，
//	如果调用结果为false，则判断tree1的左子树和tree2是否相同，
//	再判断右子树和tree2是否相同
	boolean result=false;
	 if(root1 != null && root2 != null){
//	if(root1.val==root2.val) 这句可以加上，节省一点时间
		result=check_if_equal(root1, root2);
//	这里不能用else！因为上面只是判断了根节点是否相同，如果根节点相同，而result为false，还是要执行下面的递归
//	else {
		if(!result) result=test(root1.left, root2);
		if(!result) result=test(root1.right, root2);
//	}
	 }
	 return result;
}
}
//public boolean check_if_equal(TreeNode node1,TreeNode node2){
//	if(node2==null) return true;
//	if(node1==null) return false;
//	if(node1.val!=node2.val) return false;
//	else return check_if_equal(node1.left, node2.left)&&check_if_equal(node1.right, node2.right);
//}
//public boolean HasSubtree(TreeNode root1,TreeNode root2) {
//	if(root1==null||root2==null) return false;
//	if(check_if_equal(root1, root2)) return true;
//	return (HasSubtree(root1.left, root2)||(HasSubtree(root1.right, root2)));
//}
