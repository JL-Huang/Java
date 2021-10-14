package »ªÎª;

import java.util.ArrayList;
import java.util.List;

public class p22 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		recur(list, 6, "", 0,0,"()");
		for(String temp:list) {
			System.out.print(temp+",");
		}
	}
private static void recur(List<String>list,int dights,String s,int ll,int lr,String source) {
	if(ll==dights/2&&lr==dights/2) {
		list.add(s);
		return;
	}
		if(ll<dights/2)
		recur(list, dights, s+"(", ll+1,lr,source);
		if(ll>lr)
		recur(list, dights, s+")", ll,lr+1,source);
}
}

