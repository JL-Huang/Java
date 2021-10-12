package ��ָoffer;

import Tree.TreeNode;
import java.util.HashMap;
//����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
//���������ǰ���������������Ľ���ж������ظ������֡�

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
//ͨ���ݹ��ö�����
private TreeNode recur(int left,int right,int predex) {
//	�ݹ���ֹ������������������Ҷ�ӽڵ㣬�ټ��������ͻᴥ��
	if(right<left) return null;
//	pre��ǰ��������飬predex���ϼ�һ��Ѱ�����ڶ������е�λ��
	TreeNode node=new TreeNode(pre[predex]);
//	map�����������ֵΪ�������Ϊֵ��dex���õ�node�ڵ���ֵ��Ӧ��������������
	int dex=(int) map.get(node.val);
//	�������node�ڵ����ߵ�������������������������߽���ԭ��һ�����ұ߽������������dex-1
//	����ǰ��������ص㣨�����ң������ڵ��ұߵ�һ���ڵ�һ����������������Ҷ��
	node.left=recur(left, dex-1, predex+1);
//	ͬ�������ұߵ�������������������߽�Ϊdex+1���ұ߽粻��
//	��ǰ������ֳɸ��ڵ㣬�������������������ڵ�����������Ӧ���У�֮���һ�����������ӽڵ�
//	dex-left+1������������Ӧ���еĳ���
	node.right=recur(dex+1,right,predex+(dex-left+1));
	return node;
}
}
