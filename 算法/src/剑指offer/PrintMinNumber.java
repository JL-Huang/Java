package 剑指offer;
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
public class PrintMinNumber {
//	事实上，这就是一个排序，只是排序的规则变了，排序算法没变，这里用的冒泡
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
//    排序的规则就是两个数，如果拼起来小的排前面，字符串拼接即可
//    注意拼接之后比较要用long，不然有可能会溢出
    public boolean newcompare(int a,int b) {
    	String a_str=String.valueOf(a);
    	String b_str=String.valueOf(b);
    	if(Long.valueOf(a_str+b_str)>Long.valueOf(b_str+a_str)) return true;
    	else return false;
    }
}
