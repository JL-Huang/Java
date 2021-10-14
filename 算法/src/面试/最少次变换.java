package 面试;
//给定一个m行n列的网格(矩阵)grid和一个整数x，你每次操作可以对其中的任意元素增加或者减少x。返回至少执行几次操作可以把网格变成单值的(所有元素值都一样)。如果不可能，返回-1。
//        数据范围: m = grid.size(), n = grid[.].size()。
//        1 <= m , n <= 100000
//        1 <= m * n <= 100000
//        1 <= x , grid[.][.] <= 10000
//        例如：输入grid[][] = {{2, 4}, {6, 8}}, x = 2
//        输出4。
//        因为可以都变为4。这样2需要操作1次，4需要操作0次，6需要操作1次，8需要操作2次。
//        或者可以都变为6， 这样2需要操作2次，4需要操作1次，6需要操作0次，8需要操作1次。

import java.lang.reflect.Array;
import java.util.Arrays;

//思路：如果有解的话，那肯定是变成矩阵中的某个数字，而矩阵中每个数字变换的量一定是x的整数倍n1,n2……
//每个数对x取模，将每个数表示为mx+a，那么最终变换的结果就是(m+n)x+a,也就是说如果有解的情况下a一定是相同的
//大胆推测，如果有解的情况下，一定是把所有数都变成矩阵中的某一个数，即m+n的取值是可以穷举的
//目的是让n的绝对值之和最小
//问题就变成了数轴上从已知点选择一个点，使它到所有已知的各个点距离之和最小
//在数学上肯定是选最中间的点
public class 最少次变换 {
    public static void main(String[] args) {
        int[][] grid={{1, 3}, {5, 19}};
        int x=2;
        System.out.println(最少次变换.test(grid,x));
    }
    private static int test(int[][] grid, int x) {
        int a = grid[0][0] % x;
        int[] m = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] % x != a) {
//                    a不等，直接返回-1了
                    return -1;
                }
//                将各个m存起来
                m[j + i * grid[0].length] = grid[i][j] / x;
            }
        }
//        排一下序
        Arrays.sort(m);
        int result_1 = 0, result_2 = 0;
//        取中间的两个点到各点距离的绝对值
        for (int i = 0; i < m.length; i++) {
            result_1 += Math.abs(m[m.length / 2] - m[i]);
            result_2 += Math.abs(m[m.length / 2] - m[i]);
        }
        return result_1 > result_2 ? result_2 : result_1;
    }
}
