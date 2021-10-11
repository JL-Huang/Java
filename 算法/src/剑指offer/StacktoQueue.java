package 剑指offer;
import java.util.Stack;
//两个栈实现队列
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
//    存是直接存进s1
    public void push(int node) {
        stack1.push(node);
    }
//    如果s2不为空，狂暴数字从s1弹出轰入s2
//    s1存入数字，在第一次pop时全部进入s2，下次s1再存入数字必然等s2全部弹出为空才进入s2，实现后进后出
    public int pop() {
        if (stack2.empty()) {
    	while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
    	return stack2.pop();    		
    }
}