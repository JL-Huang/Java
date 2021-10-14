package ̰��;
//�����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
public class �ж��Ƿ�Ϊ������ {
//��Ȼ��s��һ���ַ�s[i]��ʼ���ж���t��һ���ַ�t[j]�ǲ�����ȣ��������j++,�����i++,j++
//	�����һ��̰�ģ���Ϊ����״���ǿ�֪�ģ�״̬ת�Ʒ���Ϊ
//	s.charAt(i - 1) == t.charAt(j - 1)
//	dp= dp(i+1,j+1)
//	s.charAt(i - 1) != t.charAt(j - 1)
//	dp= dp(i,j+1)
	public static void main(String[] args) {
		�ж��Ƿ�Ϊ������ dp=new �ж��Ƿ�Ϊ������();
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
