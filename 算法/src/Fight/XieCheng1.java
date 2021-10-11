package Fight;

import java.util.Arrays;
import java.util.Scanner;

public class XieCheng1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] power_str=sc.nextLine().split(" ");
		int[] power=new int[power_str.length];
		for(int i=0;i<power_str.length;i++) {
			power[i]=Integer.parseInt(power_str[i]);
		}
		String[] mission_str=sc.nextLine().split(" ");
		int[] mission=new int[mission_str.length];
		for(int i=0;i<mission.length;i++) {
			mission[i]=Integer.parseInt(mission_str[i]);
		}
		int result=0;
        Arrays.sort(mission);
		Arrays.sort(power);
		boolean[] flag=new boolean[mission.length];
		for(int i=0;i<power.length&&i<mission.length;i++) {
			if(power[i]<=mission[i]&&!flag[i]) {
				flag[i]=true;
				result++;
				continue;
			}else {
				for(int j=i;j<mission.length;j++) {
					if(power[i]<=mission[j]&&!flag[j]) {
						flag[j]=true;
						result++;
						continue;
					}
				}
			}
		}
		System.out.println(result);
	}
}