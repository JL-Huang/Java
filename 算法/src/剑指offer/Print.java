package ��ָoffer;

import java.util.ArrayList;

import Tree.TreeNode;

public class Print {
    ArrayList<ArrayList<Integer> > test(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        depth(pRoot, 1, list);
        return list;
    }
//    ��������ǳ������Ҫ˼·����depth��¼ÿһ��Ĳ�����������0��ʼ��depth��1��ʼ
//    ��depth>size,��list��depthλ����һ���µķ���List��ȷ��size=depth-1
//    Ȼ������ӷ���List��ʱ����depth-1����ѵ�ǰroot�ӽ�ȥ
//    Ȼ�����ҵݹ飬Ҫע����ǣ�������ʵ��������ȱ���
//    ������ȷ����ÿһ�㶼ֻ�����Ӧ�ķ���List�����
    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
    	if(root==null) return;
    	if(depth>list.size()) list.add(new ArrayList<Integer>());
    	list.get(depth-1).add(root.val);
    	depth(root.left, depth+1, list);
    	depth(root.right, depth+1, list);   	
    }
}
