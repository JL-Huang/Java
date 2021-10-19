package 华为;

import java.util.Stack;

public class p11 {
	public static void main(String[] args) {
		int[]a=new int[10];
		new Solution().largestRectangleArea(null);
	}
}
class Solution {
    public  int largestRectangleArea(int[] heights) {
       Stack<Integer> stack=new Stack();
       stack.push(-1);
       int maxarea=0;
       for(int i=0;i<heights.length;i++){    
           while(stack.peek()!=-1&&heights[stack.peek()]>heights[i]){
               maxarea=Math.max(heights[stack.pop()]*(i-stack.peek()-1),maxarea);
           }
            stack.push(i);
            stack.get(0);
       }
        if(stack.peek()==-1){
            maxarea=heights[0]*heights.length;
        }
       return maxarea;
        
    }
}
