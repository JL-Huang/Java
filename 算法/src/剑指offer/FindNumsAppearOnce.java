package ��ָoffer;
//һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
public class FindNumsAppearOnce {
    public void test(int [] array,int num1[] , int num2[]) {
//    	�߽����
        if(array.length==2) {
        	num1[0]=array[0];
        	num2[0]=array[1];
        }
//        ˼·�ǽ������������Ϊ������㽻���ɣ��Լ����Լ����Ϊ0����0���Ϊ�������������һ��������Ŀ�������Ľ��
        int xorreslt=0;
        for(int i=0;i<array.length;i++) xorreslt^=array[i];
//        Ȼ�����ҵ��������һ��1���±꣬˵����������һλ�������ǲ�ͬ��
        int index=IndexOfOne(xorreslt);
//        Ȼ��������飬�ж��±���һλ�������Ϊ1��������ȡ��򣬵ó�һ���𰸣�Ϊ0��ͬ���������õ���һ����
        for(int i=0;i<array.length;i++) {
        	switch(OneorZero(array[i],index)) {
        	case 1:
        		num1[0]^=array[i];
        		break;
        	case 0:
        		num2[0]^=array[i];
        		break;   	
        	}
        }
        return;
    }
//    �ҵ�һ��1���ֵ�λ��
//    �����ǲ�����1�룬����֮����Ϊ0��ԭ�����ƣ�index++��ֱ����Ľ��Ϊ1�������ʱindex
    public int IndexOfOne(int i) {
    	int index=0;
    	while((i&1)==0&&index<=32) {
    		i>>=1;
    		index++;
    	}
    	return index;
    }
//    ֪��index��ֻ��Ҫ��һ��������indexλ��1�룬�Ϳ���֪����һλ��0����1
    public int OneorZero(int i,int index) {
    	return (i>>index)&1;
    }
}
