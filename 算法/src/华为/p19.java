package »ªÎª;

import java.util.Scanner;

public class p19 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int[] pa=getnum(sc.nextLine(), num);
	int[] pb=getnum(sc.nextLine(), num);
	
}
//private static int answer(int[] pa,int[] pb) {
//	int[] nums=new int[pa.length];
//	
//}
private static int[] getnum(String str,int num) {
	int[] points=new int[num];
		if(str.length()==1) {
			System.out.println(1);
			return null;
		}
		else {
			String[] strs=str.split(" ");
			for(int j=0;j<points.length;j++) {
				points[j]=Integer.parseInt(strs[j]);
			}
		}
		return points;
}
}
