package ��ָoffer;

import Tree.ListNode;
//����һ��������ת��������������ı�ͷ��
public class ReverseList {

    public ListNode test(ListNode head) {
    	ListNode pre = null;
    	ListNode next = head;
//    		������߼��Ƚϸ���
    	while(next!=null) {
//    		���ȣ��ǰѵ�ǰ�ڵ����һ�ڵ������
    		ListNode temp=next.next;
//    		Ȼ���õ�ǰ�ڵ�ָ��pre���׽ڵ�Ļ�preĿǰ����null�����׽ڵ�pre�Ѿ�������ǰ���������Ϣ��
    		next.next=pre;
//    		��������ʵ�ֵľ�����ǰŲ������ǰ�ڵ�Ų��pre����һ�ڵ�Ų����ǰ�ڵ㣬����������ֱ�Ӱѽڵ��滻�����ᵼ�����ڲ�ָ��Ҳ���滻
    		pre=next;
    		next=temp;
    	}
    	return pre;
    }
}
