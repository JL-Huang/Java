package 剑指offer;

import java.util.Stack;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
//假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
//序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
//但4,3,5,1,2就不可能是该压栈序列的弹出序列。
//（注意：这两个序列的长度是相等的）
public class IsPopOrder {
//思路：模拟出栈
    public boolean test(int [] pushA,int [] popA) {
    	if(pushA==null||popA==null) return false;
    	if(pushA.length==0||popA.length==0) return false;
        Stack<Integer> stack=new Stack<Integer>();
        int index=0;
//        将pushA元素依次进栈
        for(int i=0;i<pushA.length;i++) {
        	stack.push(pushA[i]);
//        	每次进栈，判断一下是否可以用popA的顺序出栈
//        	当栈顶元素等于popA[index],弹出，同时尝试下一个栈顶元素能否同样出栈，不行则又会跳出，继续进栈
        	while(!stack.isEmpty()&&stack.peek()==popA[index]) {
        		stack.pop();
        		index++;
        	}
        }
        return stack.isEmpty();
    }
}
