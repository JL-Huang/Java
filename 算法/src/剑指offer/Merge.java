package ��ָoffer;

import Tree.ListNode;

//���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
public class Merge {
    public ListNode test(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode result =null;
//        �ǳ��򵥵�һ���ݹ飬�Ƚϵ�ǰֵ������Сֵ��Ӧ�ڵ����������������һ�ڵ���еݹ�
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
