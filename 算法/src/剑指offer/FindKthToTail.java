package ��ָoffer;

import Tree.ListNode;

//����һ����������������е�����k����㡣
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindKthToTail {
    public ListNode test(ListNode head,int k) {
//    	���Ƿ����뷵�ؿ�
    	if(head==null||k<=0) return null;
    	ListNode p1=head;
    	ListNode p2=head;
//    	�Ȱ�p2�����ƶ�k-1��
        while(k-1>0) {
//        	k���������ȣ����ؿ�
        	if(p2.next==null) return null;
        	if(p2.next!=null) {
        		p2=p2.next;
        		k--;		
        	}
        }
//        �ٰ�p2�ƶ������һ�����ܹ�Ҫ�ƶ�n-1-(k-1)=n-k��
//        ��ʱp1Ҳ�ƶ���n-k�Σ�ǡ�þ��ǵ�����k��
        while(p2.next!=null) {
        	p1=p1.next;
        	p2=p2.next;
        }
        return p1;
    }
}
