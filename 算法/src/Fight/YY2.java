package Fight;

public class YY2 {
	public static void main(String[] args) {
		System.out.println(addStrings("1", "1"));
	}
    public static String addStrings (String num1, String num2) {
        // write code here
    	int a=Integer.parseInt(num1);
    	int b=Integer.parseInt(num2);
    	int c=a+b;
    	return(String.valueOf(c));
    }
}
