package ��ָoffer;

import java.util.Stack;

//���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
//����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
//����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
//��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
//��ע�⣺���������еĳ�������ȵģ�
public class IsPopOrder {
//˼·��ģ���ջ
    public boolean test(int [] pushA,int [] popA) {
    	if(pushA==null||popA==null) return false;
    	if(pushA.length==0||popA.length==0) return false;
        Stack<Integer> stack=new Stack<Integer>();
        int index=0;
//        ��pushAԪ�����ν�ջ
        for(int i=0;i<pushA.length;i++) {
        	stack.push(pushA[i]);
//        	ÿ�ν�ջ���ж�һ���Ƿ������popA��˳���ջ
//        	��ջ��Ԫ�ص���popA[index],������ͬʱ������һ��ջ��Ԫ���ܷ�ͬ����ջ���������ֻ�������������ջ
        	while(!stack.isEmpty()&&stack.peek()==popA[index]) {
        		stack.pop();
        		index++;
        	}
        }
        return stack.isEmpty();
    }
}
