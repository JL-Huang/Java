package ��ָoffer;
import java.util.Stack;
//����ջʵ�ֶ���
public class StacktoQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public static void main(String[] args) {
    	StacktoQueue s2q=new StacktoQueue();
		s2q.push(1);
		s2q.push(2);
		s2q.push(3);
		System.out.println(s2q.pop());
		System.out.println(s2q.pop());
	}
//    ����ֱ�Ӵ��s1
    public void push(int node) {
        stack1.push(node);
    }
//    ���s2��Ϊ�գ������ִ�s1��������s2
//    s1�������֣��ڵ�һ��popʱȫ������s2���´�s1�ٴ������ֱ�Ȼ��s2ȫ������Ϊ�ղŽ���s2��ʵ�ֺ�����
    public int pop() {
        if (stack2.empty()) {
    	while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
    	return stack2.pop();    		
    }
}