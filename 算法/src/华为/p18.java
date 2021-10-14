package »ªÎª;

import java.util.LinkedList;
import java.util.Scanner;

public class p18 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	LinkedList<Integer> list=new LinkedList<Integer>();
	int count=sc.nextInt();
	for(int i=0;i<count;i++) {
		int nums=sc.nextInt();
		sc.nextLine();
		for(int j=0;j<nums;j++) {
			String str=sc.nextLine();
			if(str.length()>5) {
				String[] strs=str.split(" ");
				int cin=Integer.valueOf(strs[1]);
				list.offer((cin));
			}
			if(str.substring(0, 3).equals("PUSH")) {
				if(list.size()>0)
				System.out.println(list.peek());
				else System.out.println(-1);
			}
			if(str.equals("POP")) {
				if(list.size()>0) {
					list.poll();				
				}
				else System.out.println(-1);
			}
			if(str.equals("SIZE")) {
				System.out.println(list.size());
			}
			if(str.equals("CLEAR")) {
				list.clear();
			}
		}
	}

}
}
