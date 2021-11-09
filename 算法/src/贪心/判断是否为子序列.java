package 贪心;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
public class 判断是否为子序列 {
//  从s第一个字符s[i]开始，判断与t第一个字符t[j]是不是相等，不相等则j++,相等则i++,j++
//	这就是一个贪心，因为优先状况是可知的，状态转移方程为
//	s.charAt(i - 1) == t.charAt(j - 1)
//	dp= dp(i+1,j+1)
//	s.charAt(i - 1) != t.charAt(j - 1)
//	dp= dp(i,j+1)
    public static void main(String[] args) {
        判断是否为子序列 dp = new 判断是否为子序列();
        String s = "bb";
        String t = "ahbgdc";
        System.out.println(dp.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        return iterate(s, t);
    }

    public boolean recur(int s_i, int t_j, String s, String t) {
        if (s_i == s.length()) return true;
        if (s_i != s.length() && t_j == t.length()) return false;
        if (s.charAt(s_i) == t.charAt(t_j)) return recur(s_i + 1, t_j + 1, s, t);
        else return recur(s_i, t_j + 1, s, t);
    }

    public boolean iterate(String s, String t) {
        if (s.length() > t.length()) return false;
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < t.length(); ) {
//                两个终结条件
                if (j == t.length() - 1 && i != s.length() - 1) {
                    return false;
                }
                if (j == t.length() - 1 && s.charAt(i) != t.charAt(j)) {
                    return false;
                }
//                关键代码，局部最优可推导出全局最优
                if (s.charAt(i) != t.charAt(j)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                if (i == s.length()) return true;
            }
        }
        return true;
    }
}
