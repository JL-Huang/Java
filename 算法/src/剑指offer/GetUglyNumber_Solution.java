package ��ָoffer;

import java.util.LinkedList;

//��ֻ����������2��3��5��������������Ugly Number����
//����6��8���ǳ�������14���ǣ���Ϊ������������7��
//ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
public class GetUglyNumber_Solution {
	public static void main(String[] args) {
		GetUglyNumber_Solution getUglyNumber_Solution=new GetUglyNumber_Solution();
		System.out.println(getUglyNumber_Solution.test(2178));
	}
//	�����˼·��ά����������,������O(n)ʱ�临�Ӷ������
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
