package ��ָoffer;

import Tree.ListNode;
//x+d=(x+kc+d)/2
//���ٴ��ߵ���ڣ�һ������x��һ������c-d
public class EntryNodeOfLoop {
//	��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null
    public ListNode test(ListNode pHead) {
//    	����Ŀ���ָ��
        if(pHead==null) return null;
        ListNode fast=pHead;
        ListNode slow=pHead;
//        ��ָ���ٶ�����ָ����������Ȼ������
        while(fast!=null&&fast.next!=null) {
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast==slow) break;
        }
//        ����֮��һ��ͣ����ԭ�أ�һ��������㣬��һ���ڵ���ٶ�ͬ��ǰ�������Ȼ���ڻ���ڴ�����
//        �ر�ע������ж���䣬��ֻҪ��ָ�������յ���������Ȼû�л�������null
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
	
