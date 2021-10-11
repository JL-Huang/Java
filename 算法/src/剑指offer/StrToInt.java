package 剑指offer;
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
//输入
//+2147483647
//1a33
//输出
//2147483647
//0
public class StrToInt {
	public static void main(String[] args) {
		StrToInt strToInt=new StrToInt();
		System.out.println(strToInt.test("123"));
		
	}
    public int test(String str) {
//    	ASCII码基本操作，逐位转换成int乘以10的count-1次方
    	if(str==null||str.length()==0) return 0;
    	int result=0;
    	int count=1;
//    	注意从低位开始，因为第一位的情况比较复杂，之后再处理
        for(int i=str.length()-1;i>0;i--) {
        	if(str.charAt(i)>=48&&str.charAt(i)<=57)
        	result=result+(str.charAt(i)-48)*count;
        	else return 0;
        	count*=10;
        }
        if(str.charAt(0)=='+') return result;
        if(str.charAt(0)=='-') return result*(-1);
        if(str.charAt(0)>=48&&str.charAt(0)<=57) return result+(str.charAt(0)-48)*count;
        return 0;
        }
    }
