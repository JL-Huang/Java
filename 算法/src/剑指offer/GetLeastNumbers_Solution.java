package ��ָoffer;
//����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4��

import java.util.ArrayList;
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> test(int [] input, int k) {
        if(input==null||input.length<k||k<=0) return null;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=input.length/2-1;i>=0;i--) adjust(input,i,input.length);
        for(int i=input.length-1;i>input.length-k;i--) {
			int temp=input[0];
			input[0]=input[i];
			input[i]=temp;
			adjust(input, 0, i);
        }
        for(int i=0;i<k;i++) {
        	list.add(input[k]);
        }
        return list;
    }
    public void adjust(int[] input,int i,int length) {
//    	����������̶�д����ǿ��
    	for(int k=2*i+1;k<length;k=2*k+1) {
//    		��ȡ���Ҷ������ֵ��Ӧ��k
			if(k+1<length&&input[k]<input[k+1]) k++;
			if(input[k]>input[i]) {
				int temp=input[i];
				input[i]=input[k];
				input[k]=temp;
				i=k;
			}else break;
    	}
    }
}
