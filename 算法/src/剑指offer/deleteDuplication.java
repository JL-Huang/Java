package 剑指offer;

import 树.ListNode;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
//例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class deleteDuplication {
////	首先知道是要用递归
////	递归的内容是什么？可以观察得到，要做的是判断当前节点与下一节点是否重复
////	若重复，则把当前节点删除，对下一节点递归，直到不重复，将形参指针指向不重复那个节点
////	若不重复，则对下一节点递归,让它返回下一不重复节点
////	这里比较关键的是，如何保存修改后的头节?
////	要保持头节点,意味着不能直接对头节点指针进行操作,只能修改其next属性
////	所以函数的参数,应该是当前节点的下一节点
//    public ListNode deleteDuplication(ListNode pHead) {
//    	if(pHead==null||pHead.next==null) return pHead;
////    	然后是关注这个,这部分实现的是检测到重复后,返回后面第一个不重复的节点
//    	if(pHead.val==pHead.next.val) {
//    		ListNode p=pHead.next;
//    		while(p!=null&&p.val==pHead.val) p=p.next;
//    		 return deleteDuplication(p);
//    	}else {
////    		首先关注的是这个,对p.next进行操作,然后是通过返回值来传递节点
//    		pHead.next=deleteDuplication(pHead.next);
//    		return pHead;
//    	}	
//    }
	
//	忽略掉上面吧，垃圾题解
//	这个递归返回的是从root开始第一个不重复的节点
    public ListNode recur(ListNode root) {
    	if(root==null||root.next==null) return root;
//    	若重复，则一直跳到不重复的点，返回这个点
    	if(root.val==root.next.val) {
    		while(root.next!=null&&root.val==root.next.val) root=root.next;
    		return recur(root.next);	
    	}
//    	若不重复，则对下一点继续递归并返回当前节点
    	else {
    		root.next=recur(root.next);
    		return root;
    	}
    }
}
