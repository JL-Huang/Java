package 剑指offer;

import java.util.LinkedList;

//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
//例如6、8都是丑数，但14不是，因为它包含质因子7。
//习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class GetUglyNumber_Solution {
	public static void main(String[] args) {
		GetUglyNumber_Solution getUglyNumber_Solution=new GetUglyNumber_Solution();
		System.out.println(getUglyNumber_Solution.test(2178));
	}
//	这里的思路是维护三个队列,可以在O(n)时间复杂度内求解
    public int test(int index) {
        LinkedList<Integer> list2=new LinkedList<Integer>();
        LinkedList<Integer> list3=new LinkedList<Integer>();
        LinkedList<Integer> list5=new LinkedList<Integer>();
        int result=1;
        for(int i=1;i<index;i++) {
        	list2.offer(result*2);
        	list3.offer(result*3);
        	list5.offer(result*5);
        	result=min(list2.peek(), list3.peek(), list5.peek());
        	if(result==list2.peek()) list2.poll();
        	if(result==list3.peek()) list3.poll();
        	if(result==list5.peek()) list5.poll();
        	
        }
        return result;
    }
    public int min(int a,int b,int c) {
    	int result=a;
    	if(a>=b) result=b;
    	if(a>=b&&b>=c) result=c;
    	return result;
    }
}
