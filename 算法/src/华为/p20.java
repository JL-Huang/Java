package »ªÎª;


import java.util.LinkedList;
import java.util.Scanner;

public class p20 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    LinkedList<Integer> list=new LinkedList<Integer>();
	int count=sc.nextInt();
		for(int j=0;j<count;j++) {
			String str=sc.nextLine();
			if(str.substring(0,2).equals("add")) {
				String[] strs=str.split(" ");
				int cin=Integer.valueOf(strs[1]);
				list.offer((cin));
			}
			if(str.equals("peek")) {
				if(list.size()>0)
				System.out.println(list.peek());
				else System.out.println(-1);
			}
			if(str.equals("poll")) {
				if(list.size()>0) {
					list.poll();				
				}
				else System.out.println(-1);
			}
		}
	

}
}
