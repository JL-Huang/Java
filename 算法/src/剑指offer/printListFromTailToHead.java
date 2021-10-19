package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

import Tree.ListNode;

//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack=new Stack<Integer>();
        ArrayList<Integer>list=new ArrayList<Integer>();
	while(listNode!=null) {
		stack.push(listNode.val);
        listNode=listNode.next;
	}
	while(!stack.isEmpty()) {
		list.add(stack.pop());
	}
        return list;
    }
}
