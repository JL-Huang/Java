package ��ָoffer;

import Tree.TreeNode;

//����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
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
//	���������ã��ܼ򵥵Ķ������ݹ�
//	ע�⣬����֮���Գ�ֵΪ1����д��������޸ĵ�
//	���������շ���0������������������Ϊ�գ���ʱ�Ѿ������㣬����++ǰӦ��Ϊ1
//	��������㷨�����⣬�������ȣ�����left��right�������֣�left��������ȣ�right�����������Ǹ��Һ��ӵ����,
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
	
//	�������ȷ��,ע��left��rightֻ���м��¼��,�����������Ϊȫ�ֱ������,�ǵò�����ȷ�����
	public int test(TreeNode root) {
		if(root==null) return 0;
		int left=test(root.left);
		int right=test(root.right);
		return left>right?left+1:right+1;
	}
	

}
