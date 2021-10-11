package Classics;
//经典大数相加
public class addStrings {
    public static String addStrings(String num1, String num2) {
    	int i=num1.length()-1,j=num2.length()-1,cin=0;
    	StringBuilder sb=new StringBuilder();
    	while(i>=0||j>=0||cin!=0) {
    		int x=i>=0?num1.charAt(i)-'0':0;
    		int y=j>=0?num2.charAt(j)-'0':0;
    		int result=x+y+cin;
    		sb.append(result%10);
    		cin=result/10;
    		i--;
    		j--;
    	}
    	return sb.reverse().toString();
    }
    public static void main(String[] args) {
		System.out.println(addStrings("12252523523", "95422525256"));
	}
}
