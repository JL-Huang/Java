package 剑指offer;

import java.util.ArrayList;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class FindNumbersWithSum {
    public ArrayList<Integer> test(int [] array,int sum) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<array.length-1;i++) {
        	int remain=sum-array[i];
        	for(int j=i;j<array.length;j++) {
        		if(array[j]==remain) {
        		if(list.isEmpty()) {
        			list.add(array[i]);
        			list.add(array[j]);
        		}else {
        			int mul=1;
        			for(Integer temp:list) {
        				mul*=temp;
        			}
        			if(mul>array[i]*array[j]) {
        				list.clear();
        				list.add(array[i]);
        				list.add(array[j]);
        			}
        			
        		}
        		}
        		if(array[j]>remain) continue;
        	}
        }
        return list;
    }
}
