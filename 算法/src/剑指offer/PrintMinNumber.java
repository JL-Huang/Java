package ��ָoffer;
//����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
//������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
public class PrintMinNumber {
//	��ʵ�ϣ������һ������ֻ������Ĺ�����ˣ������㷨û�䣬�����õ�ð��
    public String test(int [] numbers) {
    	for(int i=0;i<numbers.length-1;i++) {
    		for(int j=numbers.length-1;j>i;j--) {
    			if(newcompare(numbers[j-1],numbers[j])) {
    				int temp=numbers[j-1];
    				numbers[j-1]=numbers[j];
    				numbers[j]=temp;
    			}
    		}
    	}
    	String result="";
    	for(int i=0;i<numbers.length;i++) result+=numbers[i];
    	return result;
    }
//    ����Ĺ�����������������ƴ����С����ǰ�棬�ַ���ƴ�Ӽ���
//    ע��ƴ��֮��Ƚ�Ҫ��long����Ȼ�п��ܻ����
    public boolean newcompare(int a,int b) {
    	String a_str=String.valueOf(a);
    	String b_str=String.valueOf(b);
    	if(Long.valueOf(a_str+b_str)>Long.valueOf(b_str+a_str)) return true;
    	else return false;
    }
}