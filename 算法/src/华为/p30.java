package »ªÎª;

import java.util.ArrayList;
import java.util.Stack;

public class p30 {
public static void main(String[] args) {
	Stack<Integer> stack=new Stack<Integer>();
	ListNode listNode=new ListNode(1);
	ArrayList<Integer>list=new ArrayList<Integer>();
	while(listNode.next!=null) {
		stack.push(listNode.val);
	}
	while(!stack.isEmpty()) {
		list.add(stack.pop());
	}
}
}
class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
   }
