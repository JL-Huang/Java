package ��ָoffer;

import Tree.RandomListNode;
//����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��randomָ��һ������ڵ㣩
//��Դ������������������ؿ������ͷ��㡣
//��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
public class Clone {
    public RandomListNode test(RandomListNode pHead){
        RandomListNode p=pHead;
        while(p!=null) {
        	RandomListNode new_p=new RandomListNode(p.label);
        	new_p.next=p.next;
        	p.next=new_p;
        	p=new_p.next;
        }
        RandomListNode t=pHead;
        while(t!=null) {
        	RandomListNode new_t=t.next;
        	if(t.random!=null) new_t.random=t.random;
        	t=new_t.next;
        }
        RandomListNode s=pHead;
        RandomListNode ss= new RandomListNode(0);
        ss=pHead.next;
        while(s!=null) {
        	RandomListNode s_copy =s.next;
        	s.next=s_copy.next;
        	s_copy.next=s_copy.next==null?null:s.next.next;
        	s=s.next;
        }
        return ss;
    }
}
