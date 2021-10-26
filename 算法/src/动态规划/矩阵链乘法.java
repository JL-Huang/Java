package 动态规划;
//矩阵链乘法是指当一些矩阵相乘时，如何加括号来改变乘法顺序从而来降低乘法次数。
//例如有三个矩阵连乘：A1*A2*A3，其维数分别为：10*100，100*5，5*50.
//如果按照（（A1*A2）A3）来计算的话，求（A1*A2）要10*100*5=5000次乘法，再乘以A3需要10*5*50=2500次乘法，因此总共需要7500次乘法。
//如果按照（A1（A2*A3））来计算的话，求（A2*A3）要100*5*50=25000次乘法，再乘以A1需要10*100*50=50000次乘法，因此总共需要75000次乘法。

//A1 30*35 A2 35*15 A3 15*5 A4 5*10 A5 10*20 A6 20*25，则p[0-6]={30,35,15,5,10,20,25}，即Ai=p[i-1]*p[i],i=1:6
//设分割点在Ak，则当前最优解结构为min{A(0:k-1)*Ak*A(k+1:n-1),A(0:k-1)*(Ak*A(k+1:n-1))}

//但是题解是另一种思路，只划分成了A1*A2*A3……*Ak和A(k+1)*A(k+2)*A(k+3)……*An两部分
//用一个二维数组r[n+1][n+1]保存结果，下标表示起点和终点,Ak=p[k-1]*p[k],A1*A2*A3……*Ak得到p[i-1]*p[k]矩阵，后者得到p[k]*p[j]矩阵

//求解思路：分割成两部分，在不同位置分割会有不同的结果，取最小的结果
//最优子结构：每次分割后，对分割出来的部分进行同样的操作
//保存的结果：对每个分割出来的部分都要保存其结果，保证自底向上，每次分割结果由起点和终点唯一确定，因此是二维数组
//递推关系：r[i][j]=min{r[i,k]+r[k+1,j]+p[i-1]p[k]p[j]，i<=k<j}
public class 矩阵链乘法 {
    public static void main(String[] args) {
        int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
        int n = p.length - 1;
        System.out.println(recur(p, n));
    }

    public static int recur(int[] p, int n) {
        int[][] result = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
//            单一个不用计算
            result[i][i] = 0;
        }
//        开区间，确保i<j
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int temp_min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    if (temp_min > result[i][k] + result[k + 1][j] + p[i - 1] * p[k] * p[j]) {
                        temp_min = result[i][k] + result[k + 1][j] + p[i - 1] * p[k] * p[j];
                    }
                }
                result[i][j] = temp_min;
            }
        }
        return result[1][n];
    }
}
