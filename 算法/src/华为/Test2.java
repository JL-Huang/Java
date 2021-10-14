package »ªÎª;

import java.util.Scanner;

public class Test2 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String input=sc.nextLine();
	String[] targets=input.split(" ");
	String target=targets[0];
	String[] regists=targets[1].split("],");
//	for(int i=0;i<regists.length;i++) {	
//		String[] operations=regists[i].split("],");
		for(int j=0;j<regists[j].length();j++) {
			String[] operation=regists[j].split("[");
			if(operation[0].equals(target)) {
				String[] things=operation[1].split(",");
				for(int k=0;k<things.length;k++) {
					String[] thing=things[k].split("=");
					System.out.println(thing[1]);
				}
			}
		}
	}
	
}

