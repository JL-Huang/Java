package ��ָoffer;

import Tree.ListNode;

//��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
//���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
public class deleteDuplication {
////	����֪����Ҫ�õݹ�
////	�ݹ��������ʲô�����Թ۲�õ���Ҫ�������жϵ�ǰ�ڵ�����һ�ڵ��Ƿ��ظ�
////	���ظ�����ѵ�ǰ�ڵ�ɾ��������һ�ڵ�ݹ飬ֱ�����ظ������β�ָ��ָ���ظ��Ǹ��ڵ�
////	�����ظ��������һ�ڵ�ݹ�,����������һ���ظ��ڵ�
////	����ȽϹؼ����ǣ���α����޸ĺ��ͷ��?
////	Ҫ����ͷ�ڵ�,��ζ�Ų���ֱ�Ӷ�ͷ�ڵ�ָ����в���,ֻ���޸���next����
////	���Ժ����Ĳ���,Ӧ���ǵ�ǰ�ڵ����һ�ڵ�
//    public ListNode deleteDuplication(ListNode pHead) {
//    	if(pHead==null||pHead.next==null) return pHead;
////    	Ȼ���ǹ�ע���,�ⲿ��ʵ�ֵ��Ǽ�⵽�ظ���,���غ����һ�����ظ��Ľڵ�
//    	if(pHead.val==pHead.next.val) {
//    		ListNode p=pHead.next;
//    		while(p!=null&&p.val==pHead.val) p=p.next;
//    		 return deleteDuplication(p);
//    	}else {
////    		���ȹ�ע�������,��p.next���в���,Ȼ����ͨ������ֵ�����ݽڵ�
//    		pHead.next=deleteDuplication(pHead.next);
//    		return pHead;
//    	}	
//    }
	
//	���Ե�����ɣ��������
//	����ݹ鷵�ص��Ǵ�root��ʼ��һ�����ظ��Ľڵ�
    public ListNode recur(ListNode root) {
    	if(root==null||root.next==null) return root;
//    	���ظ�����һֱ�������ظ��ĵ㣬���������
    	if(root.val==root.next.val) {
    		while(root.next!=null&&root.val==root.next.val) root=root.next;
    		return recur(root.next);	
    	}
//    	�����ظ��������һ������ݹ鲢���ص�ǰ�ڵ�
    	else {
    		root.next=recur(root.next);
    		return root;
    	}
    }
}