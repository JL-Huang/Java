package «Ô’–;

import Tree.ListNode;

public class YY1 {
    public ListNode reverseList (ListNode head) {
        // write code here
    	if(head==null) return null;
    	ListNode pre=null;
    	ListNode cur=head;
    	while(cur!=null) {
    		ListNode temp=cur.next;
    		cur.next=pre;
    		pre=cur;
    		cur=temp;
    	}
    	return pre;
    }
}
