package ��ָoffer;
//{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
//��һ�����飬���������������������
public class FindGreatestSumOfSubArray {
//	���ᶯ̬�滮д�����Ĵ����,˼·��˫ָ��,���ָ��̶�,�ұ�ָ�벻������ֱ���ҵ���ǰ��ָ���Ӧ����������ֵ,��������
//	��ʵ��,�������˺ܶ��ظ����߲���Ҫ���������ж�
//    public int test(int[] array) {
//        if(array.length==0) return 0;
//        int sum=Integer.MIN_VALUE;
//        for(int i=0;i<array.length;i++) {
//        	int maxtempsum=Integer.MIN_VALUE;
//        	for(int j=i;j<array.length;j++) {
//            	int tempsum=array[j];
//        		if(j!=array.length-1) {
//        			maxtempsum=tempsum<tempsum+array[j]?tempsum+array[j]:tempsum;
//        			tempsum+=array[j];
//        		}
//        	}
//        	sum=sum>maxtempsum?sum:maxtempsum;
//        }
//        return sum;
//    }
	public int test(int[] array) {
		if(array.length==0) return 0;
//		������������,tempmax����ÿ��������к�,max�������ս��
		int tempmax=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) {
//			����ж�ʮ�ֹؼ�,������tempmax<=0,��ôǰ����붪��,�����Ԫ����Ϊtempmax��
//			��Ϊ���������,�Ǽ��ϵ�ǰԪ��,ֻ��ȵ�ǰԪ��С
			if(tempmax<=0) tempmax=array[i];
//			ֱ�Ӱѵ�ǰ��������������,��������,��Ϊ�����Ǹ���,max�Ѿ���¼�ü����������ǰ������
//			����ʱ��Ӧ�ü�������̽��,������û�д���ʹ�����ת
			else tempmax+=array[i];
			max=max>tempmax?max:tempmax;	
		}
		return max;
	}
}
