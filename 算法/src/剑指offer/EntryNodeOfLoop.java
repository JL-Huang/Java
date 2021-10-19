package 剑指offer;

import Tree.ListNode;
//x+d=(x+kc+d)/2
//当再次走到入口，一个走了x，一个走了c-d
public class EntryNodeOfLoop {
//	给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
    public ListNode test(ListNode pHead) {
//    	经典的快慢指针
        if(pHead==null) return null;
        ListNode fast=pHead;
        ListNode slow=pHead;
//        快指针速度是慢指针两倍，必然会相遇
        while(fast!=null&&fast.next!=null) {
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast==slow) break;
        }
//        相遇之后一个停留在原地，一个返回起点，以一个节点的速度同速前进，则必然会在环入口处相遇
//        特别注意这个判断语句，当只要快指针遇到空的情况，则必然没有环，返回null
        if(fast==null||fast.next==null)
            return null;
        fast=pHead;
        while(fast!=slow) {
        	fast=fast.next;
        	slow=slow.next;
        }
        return slow;
    }
}
	
