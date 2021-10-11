package Fight;

import java.util.HashMap;

public class vivo3 {
public static void main(String[] args) {
	
}
public String compileSeq (String input) {
    // write code here
	String[] strs=input.split(",");
	int[] nums=new int[strs.length];
	nums[0]=strs[0].charAt(1)-'0';
	nums[strs.length-1]=strs[strs.length-1].charAt(0)-'0';
	for(int i=1;i<strs.length-1;i++) {
		nums[i]=strs[i].charAt(0)-'0';
	}
	StringBuilder sb=new StringBuilder();
	for(int i=1;i<strs.length-1;i++) {
		sb.append(nums[i]);
	}
	return sb.toString();

	
}
}
