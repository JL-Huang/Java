package ��ָoffer;

import java.util.ArrayList;

//����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
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
