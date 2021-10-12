package ��ָoffer;

import java.util.Stack;
//����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
//ע�⣺��֤�����в��ᵱջΪ�յ�ʱ�򣬶�ջ����pop()����min()����top()������
public class MinStack {
//	ʱ�临�Ӷ���ͣ��޷ǿռ任ʱ��
//	��������ջ��һ������ջ��һ�������ݼ�ջ��min�����ӵݼ�ջ��ջ
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
//	��ջʱ��stack1������ջ��stack2ֻ�еݼ��Ž�ջ
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()) stack2.push(node);
        if(node<stack2.peek()) stack2.push(node);
    }
//    ��ջʱ��stack1������ջ����ջԪ�ظպõ���stack2ջ��Ԫ�أ���stack2ҲҪ��ջ
    public void pop() {
        int i=Integer.MIN_VALUE;
        if(!stack1.isEmpty()) i=stack1.pop();
        if(i==stack2.peek()) stack2.pop();
    }
    
    public int top() {
        if(!stack1.isEmpty()) return stack1.peek();
        else return 0;
    }
    
    public int min() {
        if(!stack2.isEmpty()) return stack2.peek();
        else return 0;
    }
}
