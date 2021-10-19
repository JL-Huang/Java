package DFS;
//岛屿问题，求岛屿大小，经典DFS
//如果是求岛屿数量，就在遍历时遇到岛屿++，然后递归把相连岛屿全变0
public class Island {
	public static void main(String[] args) {
		int[][] nums= {{1,1,1,0},
						{0,1,0,1},
						{0,0,0,1},
						{1,1,1,1}};
		int result=0;
		int k = 0;
		boolean[][]flag=new boolean[4][4];
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums[0].length;j++) {
				if(nums[i][j]==1) {
//					k++;
//					recur2(nums, i, j);
					int temp=recur1(nums, i, j);
					result=result>temp?result:temp;
				}
			}
		}
		System.out.println(result);
	}
//	最大岛屿
	public static int recur1(int[][] nums,int row,int col) {
		if(row<0||row>=nums.length||col<0||col>=nums[0].length||nums[row][col]==0) return 0;
			nums[row][col]=0;
			return recur1(nums, row+1, col)+
					recur1(nums, row-1, col)+
					recur1(nums, row, col+1)+
					recur1(nums, row, col-1)+1;

	}
//	岛屿个数
	public static void recur2(int[][] nums,int row,int col) {
		if(row<0||row>=nums.length||col<0||col>=nums[0].length||nums[row][col]==0) return ;
		if(nums[row][col]==1) {
			nums[row][col]=0;
			recur2(nums, row+1, col);
			recur2(nums, row-1, col);
			recur2(nums, row, col+1);
			recur2(nums, row, col-1);
		}
		return ;
	}
}
