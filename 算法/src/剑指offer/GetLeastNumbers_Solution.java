package 剑指offer;
//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

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
//    	堆排序调整固定写法，强记
    	for(int k=2*i+1;k<length;k=2*k+1) {
//    		获取左右儿子最大值对应的k
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
