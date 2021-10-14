package «Ô’–;

import java.util.Arrays;

public class BiliBili3 {
    public int maxProfit (int[] prices) {
        // write code here
    	Arrays.sort(prices);
    	int length=prices.length;
    	System.out.println(prices[length-1]+prices.length-2-prices[0]-prices[1]);
    	int result=0-prices[0];
    	for(int i=0;i<prices.length;i++) {
    		for(int j=i;i<prices.length;j++) {
    		}
    	}
    	return 1;
    }
}
