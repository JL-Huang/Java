package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eight_Queen {
	public static void main(String[] args) {
		
	}
	public List<List<String>> solveNQueens(int n){
		char[][] board=new char[n][n];
		List<List<String>>list=new ArrayList<List<String>>();
		for(int i=0;i<board.length;i++) Arrays.fill(board[i], '.');
		backtrack(0, n, board, list);
		return list;
		
	}
//	回溯，输入参数r是表示遍历到第几行
	public void backtrack(int r,int n,char[][] board,List<List<String>> list) {
//	当遍历到最后一行，说明前面都是available的，整个棋盘一行一行输入到innerlist，在把innerlist添加到总集合
		if(r==n) {
			ArrayList<String> inner_list=new ArrayList<String>();
			for(int i=0;i<n;i++) {
				inner_list.add(String.valueOf(board[i]));
			}
			list.add(inner_list);
			return;
		}
//		当前行一列一列遍历，如果当前点可行，变成Q，对下一行递归，递归完回溯
		for(int i=0;i<n;i++) {
			if(available(n, n, r, i, board)) {
				board[r][i]='Q';
				backtrack(r+1,n,board,list);  
				board[r][i]='.';
			}
		}
	}
	//判断一个点是否可用
	boolean available(int rows,int cols,int row,int col,char[][]input) {
		for(int i=0;i<rows;i++) {
			if(input[i][col]=='Q') return false;
		}
		for(int i=0;i<cols;i++) {
			if(input[row][i]=='Q') return false;
		}
		for(int i=0,j=0;i>=0&&j>=0;i--,j--) {
			if(input[row][i]=='Q') return false;
		}
		for(int i=row,j=col;i>=0&&j>=0;i--,j--) {
			if(input[i][j]=='Q') return false;
		}
		for(int i=row,j=col;i>=0&&j<cols;i--,j++) {
			if(input[i][j]=='Q') return false;
		}
		return true;
	}
}
