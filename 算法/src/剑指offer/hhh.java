package 剑指offer;

public class hhh {
    public boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
    	if(matrix==null||matrix[0]==null) return false;
    	boolean[][] flag=new boolean[matrix.length][matrix[0].length];
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			return recur(matrix, rows, cols, i, j, str, 0, flag);
    		}
    	}
    	return false;
    }
	public boolean recur(char[][] matrix,int rows, int cols,int cur_row,int cur_col,char[] target,int k,boolean[][] flag) {
		if(cur_col<0||cur_row<0||cur_col>cols||cur_row>rows||flag[cur_row][cur_col]==true||target[k]!=matrix[cur_row][cur_col]) return false;
		if(k==target.length-1) return true;
		flag[cur_row][cur_col]=true;
		if(recur(matrix, rows, cols, cur_row+1, cur_col, target, k+1, flag)||
			recur(matrix, rows, cols, cur_row, cur_col+1, target, k+1, flag)||	
			recur(matrix, rows, cols, cur_row-1, cur_col, target, k+1, flag)||
			recur(matrix, rows, cols, cur_row, cur_col-1, target, k+1, flag)) return true;
		flag[cur_row][cur_col]=false;
		return false;
	}
}
