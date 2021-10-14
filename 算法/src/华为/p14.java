package »ªÎª;

public class p14 {
	static int max=0;
	static int sum=0;
public static void main(String[] args) {
//	Scanner sc=new Scanner(System.in);
//	int n=sc.nextInt();
//	int m=sc.nextInt();
//	sc.nextLine();
//	String str=sc.nextLine();
//	if(str==null) System.out.println(0);
//	String[] strs=str.split(" ");
//	int[] nums=new int[strs.length];
//	for(int i=0;i<strs.length;i++)
//		nums[i]=Integer.parseInt(strs[i]);
	int[] container=new int[4];
//	getmax(nums,0,container);
//	for(int temp:getmax(nums,0,container))
//	System.out.println(temp);
	int[] nums= {1,2,3,4};
	getmax(nums,0,container);
}

public static void getmax(int[] nums,int m,int[] container) {
	if(m==nums.length) {
		if(container.length!=0) {
			for(int temp:container)
				System.out.print(temp);
			System.out.println(" ");
		}
		return;
//		return container;
	}
	getmax(nums,m+1,container);
	container[m]=nums[m];
	getmax(nums,m+1,container);
//	return container;
	
//	if(nums==null) return max;
//	max=max>sum%m?max:sum%m;
//
//	if(nums.length==0)return max;
//	boolean ischoice=true;
//	if(ischoice) {
//		sum+=nums[0];
//		int[] newnums=new int[nums.length-1];
//		for(int i=1;i<nums.length;i++) {
//			newnums[i-1]=nums[i];
//		}
//		getmax(newnums,m);
//	}
//	boolean notchoice=true;
//	if(notchoice) {
//	int[] newnums=new int[nums.length-1];
//	for(int i=1;i<nums.length;i++) {
//		newnums[i-1]=nums[i];
//	}
//	getmax(newnums,m);
//	}
//	
//
//return max;
}
}
