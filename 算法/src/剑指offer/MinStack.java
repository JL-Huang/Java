package 剑指offer;

import java.util.Stack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
public class MinStack {
//	时间复杂度最低，无非空间换时间
//	定义两个栈，一个正常栈，一个单调递减栈，min操作从递减栈出栈
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
//	进栈时，stack1正常进栈，stack2只有递减才进栈
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()) stack2.push(node);
        if(node<stack2.peek()) stack2.push(node);
    }
//    出栈时，stack1正常出栈，出栈元素刚好等于stack2栈顶元素，则stack2也要出栈
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
