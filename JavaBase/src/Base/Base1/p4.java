package Base.Base1;

import java.util.Scanner;

public class p4 {


	public static void main(String[] args) {
		 Scanner mscanner=new Scanner(System.in);
		int k=Integer.parseInt(mscanner.next());
		int sum=1;
			for(int i=1;i<=k;i++) {
			sum=sum*i;
			}
		System.out.print(sum);
		
		
	}

}
