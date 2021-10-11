package 剑指offer;

import java.util.Arrays;

//一副牌四个大小王，大小王视为0，J为11,Q为12，K为13，A为1，大小王可视为任意点数，求抽五张是不是顺子
public class isContinuous {
public static void main(String[] args) {
	
}
public boolean test(int [] numbers) {
	if(numbers==null||numbers.length==0) return false;
	int numofzero=0;
//	先排序
	Arrays.sort(numbers);
	for(Integer temp:numbers) {
		if(temp==0) numofzero++;
	}
	int target=numbers.length-numofzero;
//	思路很简单，从第一非零开始，到最后一个元素前一个
	for(int i=numofzero;i<numbers.length-1;i++) {
//		如果遇到不是顺子，则前一个数加一，同时零的数量减一
//		当零耗完还不是顺子，就返回false了
		while(numbers[i]!=numbers[i+1]-1) {
			numofzero--;
			numbers[i]++;
			if(numofzero<0) return false;
		}
	}
	return true;
	
}
}
