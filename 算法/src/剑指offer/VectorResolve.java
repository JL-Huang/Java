package ��ָoffer;
//��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
//����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
//��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
//NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
public class VectorResolve {
//	�㷨˼·�ǳ��򵥣���ͼ������⣬���������ҵ�ͻ��Ϊ�ݼ��ĵ�
//			/|
//		   / |
//		     |
//		     |/
//��Ȼ��ʱ�临�Ӷȶȷǳ���
//    public int minNumberInRotateArray(int [] array) {
//        int low=0;
//        int high=array.length-1;
//        int mid=(low+high)/2;
//        while(array[low]<array[high]) {
//        	if(array[mid]<array[high]) high=mid-1;
//        	if(array[mid]==array[high]) high=high-1;
//        	if(array[mid]>array[high]) low=mid+1;
//        }
//        return array[low];
//    }
	
//	�����ǱȽ������������ֻ��Ҫһ�α���
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        if(array.length==1) return array[0];
        for(int i=0;i<array.length-1;i++) {
        	if(array[i]>array[i+1]) return array[i+1];
        }
        return 0;
    }
}