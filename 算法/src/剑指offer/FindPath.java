package ��ָoffer;

import java.util.ArrayList;

import Tree.TreeNode;

//����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
//·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
public class FindPath {
	ArrayList<ArrayList<Integer>> listall=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> test(TreeNode root,int target) {
        if(root==null) return listall;
        list.add(root.val);
        target-=root.val;
//        ����ע�⣬����������һ��list���������浱ǰlist����Ȼ���պ���Ĵ���list�ᱻ�޸�
//        listÿ�η��������������ͻ��ˣ�����ȻΪ��
        if(target==0&&root.left==null&root.right==null) listall.add(new ArrayList<Integer>(list));
        test(root.left,target);
        test(root.right,target);
//        ÿ�η���������������������Ҷ�ӽڵ㣬��Ҫ���ˣ�ɾ������Ҷ�ӽڵ㣬��Ȼ�ᵼ�¸�-��-��Ҷ��-��Ҷ��������list
//        �������ʮ�ֹؼ�����һ���ڵ����Һ��Ӷ�return֮��ͻ�ɾ����ǰ�ڵ㣬����Ҫ�������
        list.remove(list.size()-1);
//        ���return�ԷǸ��ڵ���ȫ����Ϊ���������Ҫ����Ϊ����ֵ���ᱻ����
        return listall;
    }
}
