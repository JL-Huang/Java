package 动态规划;

//给定两个序列X和Y,如果Z既是X的子序列,也是Y的子序列,我们称它是X和Y的公共子序列。
//例如,如果X=(A,B,C,B,D,A,B),Y=(B,D,C,A,B,A),那么序列(B,C,A)就是X和Y的公共子序列。
//但它不是X和Y的最长公共子序列(ILCS),因为它长度为3。
//而(B,C,B,A)是X和Y的最长公共子序列,(B,D,A,B)也是,因为X和Y不存在长度大于等于5的公共子序列

//我的题解：
//最优子结构：以x[i]开头的最长公共子序列，必然是x[i+1]开头的最长公共子序列加一或者不加
//重叠子问题：求x[i]开头的最长公共子序列与求x[i+1]开头的最长公共子序列是重叠的
//需要保存的结果：求x[i]开头的最长公共子序列长度，因为x[i]可以唯一确定结果，所以一维数组就够了
//状态转移方程：r[i]=y[j:y.length].contains(x[i])?r[i+1]+1:r[i+1],i=0:x.length-2,j=indexOf(x[i]==y[j])
//这里还有一个问题，就是上面的式子是矛盾的，i=0:x.length-1，求r[i]值时却需要r[i+1]，因此需要改造
//r[i]=y[j:0].contains(x[i])?r[i+1]+1:r[i+1],i=x.length-2:0,j=indexOf(x[i]==y[j])
//然而发现这个思路是错的，在最优子结构时出错了
//以x[i]开头的最长公共子序列，并不是x[i+1]开头的最长公共子序列加一或者不加，他可以丢弃后面的直接从x[i]开始

//官方题解：
//解题思路：根据两个序列的尾元素求最长公共子序列，相同则往前倒一位的结果加一，不同则两个序列分别倒一位取最大（跟上面错误思路不同的就是把两个序列都算上）
//重叠子问题：倒一位求解时，思路是一样的
//需要保存的结果：以x[i]与y[j]结尾的序列的最长子序列，二维数组
//递推公式：r[i][j]=x[i]==y[j]?r[i-1,j-1]+1:max(r[i-1,j],r[i,j-1])    i=1:n-1,j=1:n-1
//需要注意的就是初始化，r[0][..]和r[..][0]都要先初始化，因为递归是从1开始
public class 最长公共子序列 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] y = {7, 11, 12, 13, 14, 15, 5, 6, 16, 4, 17};
        String xx = "abcdefghij";
        String yy = "gklmnoefpdq";
        String mm = "ezupkr";
        String nn = "ubmrapg";
        String pp = "abcde";
        String qq = "ace";
        System.out.println(recur(pp, qq));
//        System.out.println(recur_wrong(x,y));
    }

    public static int recur_wrong(int[] x, int[] y) {
        int[] result = new int[x.length];
        result[x.length - 1] = 0;
        int k = y.length - 1;
        for (int j = y.length - 1; j >= 0; j--) {
            if (y[j] == x[x.length - 1]) {
                result[x.length - 1] = 1;
                k = j;
                if (x.length == 1) return result[x.length - 1];
                break;
            }
        }
        if (x.length == 1) return 0;
        for (int i = x.length - 2; i >= 0; i--) {
            boolean flag = false;
            for (int j = k - 1; j >= 0; j--) {
                if (x[i] == y[j]) {
                    k = j;
                    flag = true;
                }
            }
            result[i] = flag ? result[i + 1] + 1 : result[i + 1];
            System.out.println(result[i]);
        }
        return result[0];
    }

    public static int recur(String text1, String text2) {
        int[][] result = new int[text1.length()][text2.length()];
        for (int i = 0; i < text2.length(); i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                for (int j = i; j < text2.length(); j++) {
                    result[0][j] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                for (int j = i; j < text1.length(); j++) {
                    result[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                result[i][j] = text1.charAt(i) == text2.charAt(j) ? result[i - 1][j - 1] + 1 : Math.max(result[i - 1][j], result[i][j - 1]);
                System.out.println(i + "" + j + "" + result[i][j] + "");
            }
        }
        return result[text1.length() - 1][text2.length() - 1];
    }
}
