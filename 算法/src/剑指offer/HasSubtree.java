package ��ָoffer;

import Tree.TreeNode;

//�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
public class HasSubtree {
public static void main(String[] args) {
	Integer[] a={5,8,5,9,2,5,5};
	Integer[] b={8,9,2};
	TreeNode root1=TreeNode.getTreeNode(a);
	TreeNode root2=TreeNode.getTreeNode(b);
	System.out.println(new HasSubtree().test(root1,root2));
}
//	дһ���������ж϶�����2�ǲ��Ƕ�����1��ͬ���ڵ������
public boolean check_if_equal(TreeNode node1,TreeNode node2){
//	�����жϵĻ�Ҫע�⣬Ҫ�ж��Ƿ���������ȽϿ��̣����ǲ���ȵ������Ǻ������뵽��
//	һ�Ƕ�����2�ȶ�����1�ڵ�Ҫ�࣬����������ֵ����ȣ�ֻ�е����������û��������������ŷ���true
//	����˳���ܷ�ת��һ���Ƕ�����2��Ϊ���򷵻�true����Ϊ����ζ��ǰ�涼û����false
    if(node2==null) return true;
//    ִ�е������ζ�Ŷ�����2һ����Ϊ��
	if(node1==null) return false;
//	ע��һ��Ҫע��ݹ���ֹ��������������2�Ѿ���Ҷ�ӽڵ㻹û���ַ���false���Ϳ��Է���true��
	if(node1.val!=node2.val) return false;
	return check_if_equal(node1.left, node2.left)&&check_if_equal(node1.right, node2.right);
}
public boolean test(TreeNode root1,TreeNode root2) {
//	����check_if_equal()��
//	������ý��Ϊfalse�����ж�tree1����������tree2�Ƿ���ͬ��
//	���ж���������tree2�Ƿ���ͬ
	boolean result=false;
	 if(root1 != null && root2 != null){
//	if(root1.val==root2.val) �����Լ��ϣ���ʡһ��ʱ��
		result=check_if_equal(root1, root2);
//	���ﲻ����else����Ϊ����ֻ���ж��˸��ڵ��Ƿ���ͬ��������ڵ���ͬ����resultΪfalse������Ҫִ������ĵݹ�
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
