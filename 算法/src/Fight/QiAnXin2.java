package Fight;

public class QiAnXin2 {
//	public static void main(String[] args) {
//		System.out.println(getMaxArea(4, 1, 6, 9, 1, 4, 9, 6));
//	}
//	static boolean[][] flag=new boolean[11][11];
//    public static int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
//        // write code here
//    	for(int i=x1;i<=x2;i++) {
//    		for(int j=y1;j<=y2;j++) {
//    			flag[i][j]=true;
//    		}
//    	}
//    	for(int i=x3;i<=x4;i++) {
//    		for(int j=y3;j<=y4;j++) {
//    			flag[i][j]=true;
//    		}
//    	}
//    	return recur(1, 1, 0, 1, 1);
//    }
//    public static int recur(int x,int y,int s,int start_x,int start_y) {
//    	if(x==10||y==10) return 0;
//    	if(flag[x][y]) return s;
//    	boolean x_flag=false;
//    	for(int i=start_x;i<=x;i++) if(flag[i][y-1]) x_flag=true;
//    	boolean y_flag=false;
//    	for(int i=start_y;i<=y;i++) if(flag[x-1][i]) y_flag=true;
//    	int a=recur(x+1, y, s+(x_flag?s+y-start_y:s), x_flag?start_x:x, start_y);
//    	int b=recur(x, y+1, s+(y_flag?s+x-start_x:s), start_x, y_flag?start_y:y);
//    	return Math.max(a, b);
//    }
    public int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int a=(10-x4)*(10-y4);
        int b=x1*y1;
        return Math.max(a, b);
    }
}
