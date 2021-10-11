package 剑指offer;
//地上有一个m行和n列的方格。
//一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
//例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
//请问该机器人能够达到多少个格子？
public class movingCount {
    public int test(int threshold, int rows, int cols)
    {
        boolean[][] flag=new boolean[rows][cols];
        return recur(rows, cols, 0, 0, flag, threshold);
    }
//	思路跟haspath一模一样，都是回溯
//	记住参数意义就基本记住模式了，rows，cols固定输入
//	row，col记录每次行数列数，boolean[][]记录有无走过
//	limit是题目要求的范围
//  函数返回值很关键，这里要求的是路径数，就返回int
    public int recur(int rows, int cols, int row,int col,boolean[][] flag,int limit) {
    	if(row<0||col<0||row>=rows||col>=cols||flag[row][col]||sum(row)+sum(col)>limit) return 0;
//    	同样,走过了就标记为true
    	flag[row][col]=true;
//    	最后的结果是前后左右能走的路径+当前节点的1
    	return(recur(rows, cols, row+1, col, flag, limit)+
    			recur(rows, cols, row-1, col, flag, limit)+
    			recur(rows, cols, row, col+1, flag, limit)+
    			recur(rows, cols, row, col-1, flag, limit)+1);
    }
    int sum(int input) {
    	return input%10+input/10;
    }
}
