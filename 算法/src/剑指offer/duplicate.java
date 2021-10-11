package 剑指offer;

import java.util.HashMap;

//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
//请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
//就是说输出结果赋值给duplication[0]
public class duplicate {
//	Hashmap.不解释了
    public boolean test(int numbers[],int length,int [] duplication) {
    	if(numbers==null||numbers.length==0) {
    		duplication[0]=-1;
    		return false;
    	}
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++) {
        	if(map.get(numbers[i])==null)
        		map.put(numbers[i], 1);
        	else map.put(numbers[i], map.get(numbers[i])+1);
        }
        for(int i=0;i<numbers.length;i++) {
        	if(map.get(numbers[i])!=1) {
        		duplication[0]=numbers[i];
        		return true;
        	}
        }
		duplication[0]=-1;
        return false;
    }
}
