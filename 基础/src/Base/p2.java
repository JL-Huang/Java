package Base;

import java.util.Scanner;

public class p2 {
	int test;
	public static void main(String args[]) {
		Scanner mscanner=new Scanner(System.in);
		int num=Integer.parseInt(mscanner.next());	//读取到有效字符才可结束输入，不能得到带空格的数据
		
		int[] p =new int[num];
		for(int i=0;i<num;i++) {
			p[i]=mscanner.nextInt();

		}
		
		String k=mscanner.next();	//获得输入回车前所有字符
		String n=mscanner.next();

	}
}
