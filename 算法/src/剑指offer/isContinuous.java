package ��ָoffer;

import java.util.Arrays;

//һ�����ĸ���С������С����Ϊ0��JΪ11,QΪ12��KΪ13��AΪ1����С������Ϊ�����������������ǲ���˳��
public class isContinuous {
public static void main(String[] args) {
	
}
public boolean test(int [] numbers) {
	if(numbers==null||numbers.length==0) return false;
	int numofzero=0;
//	������
	Arrays.sort(numbers);
	for(Integer temp:numbers) {
		if(temp==0) numofzero++;
	}
	int target=numbers.length-numofzero;
//	˼·�ܼ򵥣��ӵ�һ���㿪ʼ�������һ��Ԫ��ǰһ��
	for(int i=numofzero;i<numbers.length-1;i++) {
//		�����������˳�ӣ���ǰһ������һ��ͬʱ���������һ
//		������껹����˳�ӣ��ͷ���false��
		while(numbers[i]!=numbers[i+1]-1) {
			numofzero--;
			numbers[i]++;
			if(numofzero<0) return false;
		}
	}
	return true;
	
}
}
