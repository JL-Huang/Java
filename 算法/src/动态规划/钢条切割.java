package 动态规划;

//给定一段长度为n英寸的钢条和一个价格表二维数组p,(i=1,2,…,n),
//求切割钢条方案,使得销售收益r最大。
public class 钢条切割 {
    //    判断到是最优子结构问题
//    每次切割时切成两部分，左边不再切割，右边继续重复
//    最优解是r(n)=max(p(i-1)+r(n-i) 1<=i<=n)
//    状态转移方程为r(i)=max(p(j-1)+r(i-j) 1<=j<=i) (1<=i<=n)
//    i表示钢条的长度，j表示可以切割的长度，r(i)表示切割长度i的钢条的最优解，定义r(0)=0;之所以是p(i-1)是因为p(0)才是长度为1的价格
    public static void main(String[] args) {
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 25};
        int n = 10;
        System.out.println(recur(price, n));
    }

    private static int recur(int[] price, int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
            int temp_max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (temp_max <= price[j - 1] + r[i - j]) {
                    temp_max = price[j - 1] + r[i - j];
                }
            }
            r[i] = temp_max;
            System.out.println(String.format("长度为%d最优解", i) + r[i]);
        }
        return r[n];
    }
}

