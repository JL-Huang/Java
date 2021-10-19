package 剑指offer;

import java.util.ArrayList;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
//例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
//则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
public class printMatrix {
	public static void main(String[] args) {
		int[][] a= {{2,3,4},{1,2,3},{3,2,4}};
		System.out.println(new printMatrix().test(a).toString());
	}
	ArrayList<Integer> result=new ArrayList<Integer>();
	 public ArrayList<Integer> test(int [][] matrix){
		 int up=0,down=matrix.length-1,left=0,right=matrix[0].length-1;
		 while(true) {
			 for(int i=left;i<=right;i++) 
				 result.add(matrix[up][i]);
			 up++;
			 if(up>down) break;
			 for(int i=up;i<=down;i++) 
				 result.add(matrix[i][right]);
			 right--;
			 if(right<left) break;
			 for(int i=right;i>=left;i--) 
				 result.add(matrix[down][i]);
			 down--;
			 if(down<up) break;
			 for(int i=down;i>=up;i--) 
				 result.add(matrix[i][left]);
			 left++;
			 if(right<left) break;
		 }
		 return result;
	 }
}
////	思路十分巧妙，每次输出一行后，将矩阵逆时针反转
//    public ArrayList<Integer> test(int [][] matrix) {
//    	if(matrix==null) return null;
//    	if(matrix.length==0) return null;
//    	if(matrix[0].length==0) return null;
//        for(Integer temp:matrix[0]) result.add(temp);
//        int[][] next1=deletefirstline(matrix);
//        int[][] next2=turnleft(next1);
//        test(next2);
//        return result;
//    }
////    删除矩阵第一行
//    public int[][] deletefirstline(int[][] matrix){
//    	if(matrix==null) return null;
//    	if(matrix.length==0) return null;
//    	if(matrix[0].length==0) return null;
//    	int[][] next=new int[matrix.length-1][matrix[0].length];
//    	for(int i=0;i<matrix.length-1;i++) {
//    		for(int j=0;j<matrix[0].length;j++) {
//    			next[i][j]=matrix[i+1][j];
//    		}
//    	}
//    	return next;
//    }
////    逆时针旋转一个矩阵
//    public int[][] turnleft(int[][] matrix){
//    	if(matrix==null) return null;
//    	if(matrix.length==0) return null;
//    	if(matrix[0].length==0) return null;
//        int[][] next=new int[matrix[0].length][matrix.length];
//        for(int j=0;j<next.length;j++) {
//        	for(int k=0;k<next[0].length;k++) {
//        		next[j][k]=matrix[k][next.length-1-j];
//        	}
//        }
//        return next;
//    }
