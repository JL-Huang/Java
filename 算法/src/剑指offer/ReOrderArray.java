package ��ָoffer;
//����һ���������飬ʵ��һ�����������������������ֵ�˳��
//ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
public class ReOrderArray {
    public void test1(int [] array) {
        for(int i=0;i<array.length-1;i++) {
//        	�����൱��ð�ݣ�����ǰż����ģ��ͽ�������ż������ð
        	for(int j=0;j<array.length-1-i;j++) {
        		if(array[j]%2==0&&array[j+1]%2==1) {
        			int temp=array[j];
        			array[j]=array[j+1];
        			array[j+1]=temp;
        		}
        	}
        }
    }
    public void test2(int [] array) {
        for(int i=0;i<array.length-1;i++) {
//        	�����൱��ð�ݣ�����ǰż����ģ��ͽ�������ż������ð
        	for(int j=array.length-1;j>i;j--) {
        		if(array[j]%2==1&&array[j-1]%2==0) {
        			int temp=array[j];
        			array[j]=array[j-1];
        			array[j-1]=temp;
        		}
        	}
        }
    }
}
