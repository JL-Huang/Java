package ��ָoffer;
//��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
//��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
//��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
//��������������0��
public class MoreThanHalfNum_Solution {
    public int test(int [] array) {
        int temp=0;
        int count=0;
//        Ħ��ͶƱ������һ����countΪ1��֮��ÿ������������ͬ�ģ�count--����count����0�����õ�ǰ�����������滻
        for(int i=0;i<array.length;i++){
            if(count==0) temp=array[i];
            if(array[i]==temp) count++;
            else count--;
        }
//        ��֪tempΪ�������ģ�������ֻ��Ҫ�жϳ��ִ���
        int count1=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==temp) count1++;
        }
        return count1>array.length/2?temp:0;
    }
}
