package 剑指offer;

import Tree.ListNode;
//输入一个链表，反转链表后，输出新链表的表头。
public class ReverseList {

    public ListNode test(ListNode head) {
    	ListNode pre = null;
    	ListNode next = head;
//    		这里的逻辑比较复杂
    	while(next!=null) {
//    		首先，是把当前节点的下一节点存下来
    		ListNode temp=next.next;
//    		然后，让当前节点指向pre（首节点的话pre目前还是null，非首节点pre已经保存了前面的所有信息）
    		next.next=pre;
//    		下面两行实现的就是往前挪，将当前节点挪到pre，下一节点挪到当前节点，具体做法是直接把节点替换掉，会导致其内部指针也被替换
    		pre=next;
    		next=temp;
    	}
    	return pre;
    }
}
