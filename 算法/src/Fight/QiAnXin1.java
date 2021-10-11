package Fight;

public class QiAnXin1 {
	public static void main(String[] args) {
		int[] candies= {3,5,7,2,8,8,15,3};
		int[] coin= {1,0,1,0,1,0,1,0};
		int n=3;
		System.out.println(maxCandies(candies, coin, n));
	}
    public static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
    	int[] changed_candies=new int[candies.length];
    	for(int i=n-1;i<candies.length;i++) {
    		for(int j=i-(n-1);j<=i;j++) {
    			changed_candies[i]+=coin[j]==1?candies[j]:0;    			
    		}
    	}
    	int before=0;
    	for(int i=0;i<candies.length;i++) {
    		before+=(coin[i]==0?candies[i]:0);
    	}
    	int result=0;
    	for(int i=2;i<candies.length;i++) {
    		result=before+changed_candies[i]>=result?before+changed_candies[i]:result;
    	}
    	return result;
    }
}
