package ��ָoffer;

import java.util.HashMap;

//��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
//���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
//����˵��������ֵ��duplication[0]
public class duplicate {
//	Hashmap.��������
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
