package Classics;
//��ȫ�������⣬���޸�����i��Ӳ�ң��ճ���ֵj���м��ַ���
//f(i,v)=�� Mi+1	f(i-1,v-k*Ci)
//			k=0
//��Ȼ������k=Mi+2��һ���ȻΪ0����//f(i,v-Ci)=�� Mi+1 f(i-1,v-(k+1)*Ci)=�� Mi+2 f(i-1,v-k*Ci)=f(i,v)-f(i-1,v)
//										 		k=0					 	 k=1

//״̬ת�Ʒ���dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]]
//dp[i][j]��ʾi��Ӳ�������ֵj�ķ�����
public class Full_Package {
	public static void main(String[] args) {
		int[] coins= {9,41,1};
		int target=8;
//		�࿪һ��λ��
		int[][]dp1=new int[coins.length+1][target+1];
		System.out.println(get_num2(dp1, coins, target));
	}
	public static int get_num2(int[][]dp,int[] coins,int target) {
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=1;
		}
//		��1�ֵ�n��
		for(int i=1;i<dp.length;i++) {
//			��ֵ��1��target
			for(int j=1;j<target+1;j++) {
//				���Ŀ���ֵ�ȵ�ǰӲ��С���������ˣ�ֻ����i-1�ֹ���
				if(j-coins[i-1]<0) dp[i][j]=dp[i-1][j];
//				����֮�⣬Ҫô�ǲ�ѡ��ǰӲ�ң�Ҫô��ѡ��ǰӲ��
//				ע�������пӣ������漰coins[i],��Ҫд��[i-1],��Ϊi��������չ��һλ
				else dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
			}
		}
		return dp[coins.length][target];
	}
}
