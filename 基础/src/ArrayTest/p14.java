package ArrayTest;

import java.util.Arrays;

public class p14 {
public static void main(String[] args) {
	String s1="dadawd dawdaf fc f f ";
	String s2=s1.replace(' ', '&');
	System.out.println(s2);
	//indexof,���ص�һ�γ�����Ҫ���ҵ��ַ�������
	System.out.println(s1.indexOf("wd"));
	String[] s3= {"aa","bb","cc","dd","ee","ff"};
	String[] s4=new String[6];
//	��S3���Ƶ�s4����s3�±�Ϊ1�Ŀ�ʼ�����Ƶ�s4�±�Ϊ0�ģ�������3��
//	���Է�װ��ɾ��������ĳһ��Ԫ�صķ�����s3,index+1,s3,index,s3.length-index-1)
	System.arraycopy(s3, 1, s4, 0, 3);
	for(String n:s4) {
		System.out.println(n);
	}
	int[] s5= {1,2,3};
	System.out.println(s5);
//	Arrays.toString()��һ����̬������������������ӡ�����
	System.out.println(Arrays.toString(s5));
//	Arrays.binarySearch(a, key) Arrays�ṩ�Ĳ����������ݷ���
//	���ظ�Ԫ�ص����������������û�и�Ԫ�ػᱨ��
	System.out.println(Arrays.binarySearch(s5, 3));
	
	int[][] i1=new int[3][];
	i1[0]= new int[]{1,1,1,1};
	i1[1]=new int[] {2,2,2};
	i1[2]=new int[] {3,3,3};
	System.out.println(Arrays.deepToString(i1));
	for(int[] temp:i1) {
		System.out.println(Arrays.toString(temp));
	}
}
}
