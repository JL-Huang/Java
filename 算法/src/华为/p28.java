package 华为;

public class p28 {
public static void main(String[] args) {
}
public boolean Find(int target, int [][] array) {
	for(int i=0;i<array.length;i++) {
		int left=0;
		int right=array[i].length-1;
		int mid=0;
		while(left<=right) {
			mid=(left+right)/2;
			if(target==array[i][mid]) return true;	
			if(target>array[i][mid]) left=mid+1;
			if(target<array[i][mid]) right=mid-1;
		}
	}
	return false;
}
}
