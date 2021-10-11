package Classics;

public class StringTest {
public static void main(String[] args) {
	String str="abcdefgh";
//	str.substring(3,2);
	StringBuffer sb=new StringBuffer();
	for(int i=0,j=3;i<str.length();i+=3,j+=3) {
		if(j<str.length())
		sb.append(str.substring(i, j));
		else sb.append(str.substring(i));
		sb.append(",");
	}
	System.out.println(sb.toString());
}
}
