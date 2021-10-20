package 剑指offer;

import 树.RandomListNode;
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点）
//请对此链表进行深拷贝，并返回拷贝后的头结点。
//（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
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
