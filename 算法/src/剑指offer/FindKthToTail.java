package 剑指offer;

import Tree.ListNode;

//输入一个链表，输出该链表中倒数第k个结点。
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
//    	当非法输入返回空
    	if(head==null||k<=0) return null;
    	ListNode p1=head;
    	ListNode p2=head;
//    	先把p2向右移动k-1次
        while(k-1>0) {
//        	k大于链表长度，返回空
        	if(p2.next==null) return null;
        	if(p2.next!=null) {
        		p2=p2.next;
        		k--;		
        	}
        }
//        再把p2移动到最后一个，总共要移动n-1-(k-1)=n-k次
//        此时p1也移动了n-k次，恰好就是倒数第k个
        while(p2.next!=null) {
        	p1=p1.next;
        	p2=p2.next;
        }
        return p1;
    }
}
