package 剑指offer;
//输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
import Tree.ListNode;

public class FindFirstCommonNode {
//	这里的方法真可谓煞费苦心
//	总的思路是这样：假设短的为a+n，长的为b+n，两者同时遍历，等短的指针走完，长的指针也走到a+n
//	这时把短的那个指针指向长的头节点，两者继续往前，等长的那个指针走到尽头，短的指针走了b-a
//	这时，把长的指针指向短的头节点，这时两者就开始同步了，继续往后随时可能相等，一相等就返回，完成
    public ListNode test(ListNode pHead1, ListNode pHead2) {
//    	因为头节点不能更改，后面要用，所有首先整个操作的节点，
    	 ListNode p1=pHead1;
    	 ListNode p2=pHead2;
//    	 同时往后遍历
    	 while(p1!=null&p2!=null) {
    		 p1=p1.next;
    		 p2=p2.next;    		 
    	 }
//    	 因为无法确认谁是长谁是短，所以就做了个判断
//    	 若p1为空，说明pHead1是短，让p1指向pHead2，p2不变
//    	 若p2为空，说明pHead1是短，让p2指向pHead1，p1不变
    	 p1=p1==null?pHead2:p1;
    	 p2=p2==null?pHead1:p2;
//    	 然后开始新一轮遍历
    	 while(p1!=null&p2!=null) {
    		 p1=p1.next;
    		 p2=p2.next;    		 
    	 }
//    	 如果p1先遍历完，说明p1刚才没变，pHead1是长，让p1指向短的pHead2，p2不变
//    	 如果p2先遍历完，说明p2刚才没变，pHead2是长，让p2指向短的pHead1，p1不变
    	 p1=p1==null?pHead2:p1;
    	 p2=p2==null?pHead1:p2;
//    	 然后就可以开始愉快遍历比较，注意是先比较，后遍历
    	 while(p1!=null&p2!=null) {
    		 p1=p1.next;
    		 p2=p2.next;    
    		 if(p1==p2) return p1;
    	 }
//    	 到最后,前面的情况全是基于两者长度不等的情况的,如果两者长度相等再套入看看
//    	 发现还是可行的
    	 return p1;
    }
}
