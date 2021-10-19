package 剑指offer;

import java.util.ArrayList;

public class printMatrix_2 {
		public static void main(String[] args) {
			int[][] a= {{2},{3},{4}};
			System.out.println(new printMatrix_2().test(a).toString());
		}
	public ArrayList<Integer> test(int [][] matrix) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return null;
		ArrayList<Integer>list=new ArrayList<Integer>();
		int up=0;
		int down=matrix.length-1;
		int left=0;
		int right=matrix[0].length-1;
		while(true) {
			if(up>down||left>right) return list;
			for(int i=left;i<=right;i++) list.add(matrix[up][i]);
			up++;
			if(up>down||left>right) return list;
			for(int i=up;i<=down;i++) list.add(matrix[i][right]);
			right--;
			if(up>down||left>right) return list;
			for(int i=right;i>=left;i--) list.add(matrix[down][i]);
			down--;
			if(up>down||left>right) return list;
			for(int i=down;i>=up;i--) list.add(matrix[i][left]);
			left++;
		}
	}
}
