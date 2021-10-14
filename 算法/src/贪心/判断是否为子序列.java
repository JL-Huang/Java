package 贪心;
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
public class 判断是否为子序列 {
//显然从s第一个字符s[i]开始，判断与t第一个字符t[j]是不是相等，不相等则j++,相等则i++,j++
//	这就是一个贪心，因为优先状况是可知的，状态转移方程为
//	s.charAt(i - 1) == t.charAt(j - 1)
//	dp= dp(i+1,j+1)
//	s.charAt(i - 1) != t.charAt(j - 1)
//	dp= dp(i,j+1)
	public static void main(String[] args) {
		判断是否为子序列 dp=new 判断是否为子序列();
		String s="abc";
		String t="ahbgdc";
		System.out.println(dp.isSubsequence(s, t));
	}
    public boolean isSubsequence(String s, String t) {
    	return recur(0, 0, s, t);
    }
    public boolean recur(int s_i,int t_j,String s, String t) {
    	if(s_i==s.length()) return true;
    	if(s_i!=s.length()&&t_j==t.length()) return false;
    	if(s.charAt(s_i)==t.charAt(t_j)) return recur(s_i+1, t_j+1, s, t);
    	else return recur(s_i, t_j+1, s, t);
    }
}
