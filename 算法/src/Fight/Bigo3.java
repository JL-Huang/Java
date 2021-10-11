package Fight;

import Tree.ListNode;

public class Bigo3 {
	ListNode result=new ListNode();
	private ListNode test(ListNode node_1,ListNode node_2) {
		while(node_1!=null&&node_2!=null) {
			if(node_1.val>node_2.val) {
				result.next=node_1;
				result=result.next;
				node_1=node_1.next;
			}
			else  {
				result.next=node_2;
				result=result.next;
				node_2=node_2.next;
			}
		}
		return result;
	}
}
