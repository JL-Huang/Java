package 剑指offer;

import Tree.ListNode;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class Merge {
    public ListNode test(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode result =null;
//        非常简单的一个递归，比较当前值，将较小值对应节点存入结果链表，对其下一节点进行递归
        if(list1.val<list2.val) {
        	result=list1;
        	result.next=test(list1.next,list2);
        }else {
        	result=list2;
        	result.next=test(list2.next,list1);
        }
        return result;
    }
}
