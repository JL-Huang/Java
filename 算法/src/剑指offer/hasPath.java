package 剑指offer;

//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
//例如
//	a	b	c	e
//	s	f	c	s
//	a	d	e	e
//矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
//因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
public class hasPath {
//	这是很经典的回溯
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    	boolean[] flag=new boolean[matrix.length];
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
//    			对每一个点，尝试能否以它为起点遍历完目标字符串
    			if(recur(matrix, rows, cols, str, i, j, flag,0)) return true;
    		}
    	}
    	return false;
    }
//    这个递归要解决的是，对于给定矩阵的一个点，递归尝试能否从这点出发走完目标字符串
//    最关键的参数是k，k记录的是遍历目标字符串的当前下标
//    flag记录的是每个各自有没有被走过，走过为false，没走过为false，一定是这样，因为初值就是false
	public boolean recur(char[] matrix, int rows, int cols, char[] str,int row,int col,boolean[] flag,int k) {
//		index记录的当前格子
		int index=row*cols+col;
//		如果越界了，或者当前格子已经走过了，或者当前格子跟需要的目标字符不同，返回false
		if(row<0||col<0||row>=rows||col>=cols||flag[index]||matrix[index]!=str[k]) return false;
//		k==str.length-1，意味着遍历到最后一个字符都没有差错，可以返回true了
		if(k==str.length-1) return true;
//		遍历过了当前格子，就要把这个格子标记
		flag[index]=true;
//		然后对上下左右依次递归，注意k+1
		if(recur(matrix, rows, cols, str, row, col+1, flag,k+1)||
			recur(matrix, rows, cols, str, row+1, col, flag,k+1)||
			recur(matrix, rows, cols, str, row-1, col, flag,k+1)||
			recur(matrix, rows, cols, str, row, col-1, flag,k+1)) return true;
//		上面没有返回，说明上下左右没一个符合了，当前路径是废了
//		然后就要把flag变回false，因为标记只是一条路径内标记，这里会回溯把这条废了的路径上所有点都标记都消除
		flag[index]=false;
		return false;
	}
}